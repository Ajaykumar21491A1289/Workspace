package com.jocata.service.impl;

import com.jocata.config.*;
import com.jocata.dao.orders.*;
import com.jocata.orders.entity.*;
import com.jocata.orders.forms.OrderInvoiceDto;
import com.jocata.orders.forms.OrderItemDto;
import com.jocata.orders.forms.OrderRequestDto;
import com.jocata.orders.forms.PaymentDto;
import com.jocata.promotions.forms.res.CouponResponse;
import com.jocata.promotions.forms.res.DiscountResponse;
import com.jocata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private OrderItemRepository itemRepo;
    @Autowired
    private PaymentRepository paymentRepo;
    @Autowired
    private ShippingInfoRepository shippingRepo;
    @Autowired
    private OrderStatusRepository statusRepo;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private InventoryClient inventoryClient;
    @Autowired
    private TransactionClient transactionClient;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ShippingClient shippingClient;
    @Autowired
    private PromotionClient promotionClient;
    

    @Transactional
    @Override
    public OrderRequestDto placeOrder(OrderRequestDto dto) {
        Orders order = initializeOrder(dto);
        List<OrderItems> items = createOrderItems(dto, order);
        BigDecimal totalAmount = calculateTotal(items);
        totalAmount = applyCouponDiscount(dto,totalAmount);
        order.setTotalAmount(totalAmount);
        orderRepo.save(order);
        saveOrderItems(items);
        createInitialStatus(order);

        dto.setOrderId(order.getId());
        dto.setTotalAmount(totalAmount);
        dto.setMessage("Order Created Successfully");
        return dto;
    }

    private BigDecimal applyCouponDiscount(OrderRequestDto dto, BigDecimal totalAmount) {
        if (dto.getCouponCode() != null && !dto.getCouponCode().isEmpty()) {
            CouponResponse coupon = promotionClient.getCouponDetails(dto.getCouponCode());
            if (coupon.getDiscountPercentage() != null) {
                BigDecimal discount = totalAmount.multiply(coupon.getDiscountPercentage().divide(BigDecimal.valueOf(100)));
                totalAmount = totalAmount.subtract(discount);
                dto.setMessage("Coupon applied successfully");
            } else {
                dto.setMessage("Invalid or expired coupon. Proceeding without discount.");
            }
        }
        return totalAmount;
    }

    private Orders initializeOrder(OrderRequestDto dto) {
        if (!userClient.isUserValid(dto.getUserId())) {
            throw new IllegalArgumentException("User not found with ID: " + dto.getUserId());
        }

        Orders order = new Orders();
        order.setUserId(dto.getUserId());
        order.setShippingAddress(dto.getShippingAddress());
        order.setStatus("PENDING");
        return order;
    }

    private List<OrderItems> createOrderItems(OrderRequestDto dto, Orders order) {
        List<OrderItems> items = new ArrayList<>();

        for (OrderItemDto itemDto : dto.getItems()) {
            BigDecimal price = productClient.getProductPrice(itemDto.getProductId());

            List<DiscountResponse> discounts = promotionClient.getDiscountsByProductId(itemDto.getProductId());
            if (!discounts.isEmpty()) {
                BigDecimal discountAmount = discounts.get(0).getDiscountAmount();
                price = price.subtract(discountAmount);
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    price = BigDecimal.ZERO;
                }
            }

            int availableQty = inventoryClient.getAvailableQuantity(itemDto.getProductId());
            if (availableQty < itemDto.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for product ID: " + itemDto.getProductId());
            }

            itemDto.setPrice(price);

            OrderItems item = new OrderItems();
            item.setOrder(order);
            item.setProductId(itemDto.getProductId());
            item.setQuantity(itemDto.getQuantity());
            item.setPrice(price);

            items.add(item);
        }

        return items;
    }


    private BigDecimal calculateTotal(List<OrderItems> items) {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItems item : items) {
            BigDecimal itemTotal = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

            total = total.add(itemTotal);
        }
        return total;
    }

    private void saveOrderItems(List<OrderItems> items) {
        itemRepo.saveAll(items);
    }

    private void createInitialStatus(Orders order) {
        OrderStatus status = new OrderStatus();
        status.setOrder(order);
        status.setStatus("PENDING");
        statusRepo.save(status);
    }

    @Override
    public String trackOrder(Long orderId) {
        List<OrderStatus> statuses = statusRepo.findByOrderIdOrderByStatusTimestampDesc(orderId);

        if (statuses.isEmpty()) {
            return "No status found for Order ID: " + orderId;
        }

        return statuses.get(0).getStatus();
    }



    @Transactional
    @Override
    public PaymentDto makePayment(Long orderId, PaymentDto paymentDto) {
        Orders order = validateAndFetchOrder(orderId, paymentDto);
        if(paymentDto.isPaymentStatus()) {
            Payments payment = createAndSavePayment(order, paymentDto);
            updateOrderStatusToPaid(order);
            paymentDto.setOrderId(order.getId());
            paymentDto.setStatus(payment.getStatus());


            transactionClient.createTransaction(paymentDto);
            updateInventory(order);
            createShippingInfo(order);
            shippingClient.createShipment(orderId, "TRK" + System.currentTimeMillis());

            paymentDto.setMessage("Payment Success");
            return paymentDto;
        }
        paymentDto.setPaymentMessage("Sorry payment Failed You have to pay"+  order.getTotalAmount());
        return paymentDto;
    }

    @Override
    public OrderInvoiceDto getOrderDetails(Long orderId) {
        Orders order = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        OrderInvoiceDto dto = new OrderInvoiceDto();
        dto.setOrderId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setOrderStatus(order.getStatus());

        List<OrderInvoiceDto.ItemDetail> itemDetails = new ArrayList<>();
        for (OrderItems item : order.getItems()) {
            OrderInvoiceDto.ItemDetail detail = new OrderInvoiceDto.ItemDetail();
            detail.setProductId(item.getProductId());
            detail.setQuantity(item.getQuantity());
            detail.setPrice(item.getPrice());
            itemDetails.add(detail);
        }
        dto.setItems(itemDetails);

        return dto;
    }



    private Orders validateAndFetchOrder(Long orderId, PaymentDto paymentDto) {
        Orders order = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        if (order.getTotalAmount().compareTo(paymentDto.getAmount()) != 0) {
            paymentDto.setPaymentStatus(false);
        }
        else paymentDto.setPaymentStatus(true);

        return order;
    }

    private Payments createAndSavePayment(Orders order, PaymentDto paymentDto) {
        Payments payment = new Payments();
        payment.setOrder(order);
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setStatus("PAID");
        return paymentRepo.save(payment);
    }

    private void updateOrderStatusToPaid(Orders order) {
        order.setStatus("SUCCESS");
        orderRepo.save(order);

        OrderStatus status = new OrderStatus();
        status.setOrder(order);
        status.setStatus("PAID");
        statusRepo.save(status);
    }

    private void updateInventory(Orders order) {
        for (OrderItems item : order.getItems()) {
            boolean success = inventoryClient.reduceStock(item.getProductId(), item.getQuantity());
            if (!success) {
                throw new RuntimeException("Failed to update stock for product id: " + item.getProductId());
            }
        }
    }

    private void createShippingInfo(Orders order) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setOrder(order);
        long sevenDaysMillis = 7L * 24 * 60 * 60 * 1000;
        shippingInfo.setDeliveryDate(new Timestamp(System.currentTimeMillis() + sevenDaysMillis));
        shippingInfo.setShippingStatus("SHIPPED");
        shippingRepo.save(shippingInfo);
    }
}