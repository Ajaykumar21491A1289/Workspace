package com.jocata.ordermanagement.payment.dao.impl;

import com.jocata.ordermanagement.payment.dao.PaymentDao;
import com.jocata.ordermanagement.payment.entity.PaymentEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PaymentDaoImpl implements PaymentDao {

    private Map<Integer, PaymentEntity> payments = new HashMap<>();
    private Path path = Paths.get("D:\\Files\\paymentObject.txt");


    public PaymentDaoImpl() {
        this.payments = loadPaymentData();
    }

    @Override
    public String setPayment(PaymentEntity entity){

        payments.put(entity.getOrderId(), entity);
        savePayments();
        return "Payment recorded successfully";

    }
    public String getPaymentStatus(int orderId){

        PaymentEntity entity = payments.get(orderId);
        if (entity != null) {
            return entity.getPaymentStatus();
        }
        return "Payment not found";

    }

    private void savePayments() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(payments);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save payment data to file", e);
        }
    }

    private Map<Integer, PaymentEntity> loadPaymentData() {
        if (!Files.exists(path)) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            return (Map<Integer, PaymentEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }


}
