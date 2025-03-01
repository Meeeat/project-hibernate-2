package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Payment;

public class PaymentDAO extends BaseDAOImpl<Payment, Short> {
    public PaymentDAO() {
        super(Payment.class);
    }

}