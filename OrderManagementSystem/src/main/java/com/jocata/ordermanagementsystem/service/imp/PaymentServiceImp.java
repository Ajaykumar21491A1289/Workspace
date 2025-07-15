package com.jocata.ordermanagementsystem.service.imp;

import com.jocata.ordermanagementsystem.dao.PaymentDao;
import com.jocata.ordermanagementsystem.dao.imp.PaymentDaoImp;
import com.jocata.ordermanagementsystem.form.ProductForm;
import com.jocata.ordermanagementsystem.service.OrderManagerService;
import com.jocata.ordermanagementsystem.service.PaymentService;
import com.jocata.ordermanagementsystem.service.ProductService;

public class PaymentServiceImp implements PaymentService {
    private PaymentDao dao = new PaymentDaoImp();
    private ProductService productService = new ProductServiceImp();
    private OrderManagerService orderService = new OrderManagerServiceImp(); // Assuming this is implemented elsewhere

    @Override
    public String makePayment(Integer productId, Integer amountPaid) {
        ProductForm product = productService.getProduct(String.valueOf(productId));
        int productPrice = Integer.parseInt(product.getPrice());

        if (amountPaid > 0 && amountPaid == productPrice) {
            return dao.processPayment(productId, amountPaid);
        } else {
            return "Failure";
        }
    }
}
