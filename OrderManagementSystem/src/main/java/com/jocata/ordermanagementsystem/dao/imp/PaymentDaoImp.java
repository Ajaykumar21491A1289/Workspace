package com.jocata.ordermanagementsystem.dao.imp;

import com.jocata.ordermanagementsystem.dao.PaymentDao;
import com.jocata.ordermanagementsystem.form.PaymentForm;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImp implements PaymentDao {
    private List<PaymentForm> payments;
    private final Path path = Paths.get("D:\\Notes\\paymentObject.txt");

    public PaymentDaoImp() {
        this.payments = loadPaymentData();
    }

    @Override
    public String processPayment(Integer productId, Integer amountPaid) {
        PaymentForm paymentForm = new PaymentForm();
        paymentForm.setProductId(productId);
        paymentForm.setAmountPaid(amountPaid);
        paymentForm.setDate(LocalDate.now().toString());

        payments.add(paymentForm);
        savePaymentsToFile();
        return "Payment Processed Successfully";
    }

    private void savePaymentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(payments);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save payments", e);
        }
    }

    private List<PaymentForm> loadPaymentData() {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                return new ArrayList<>();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create payment file", e);
            }
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (List<PaymentForm>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load payment data", e);
        }
    }
}
