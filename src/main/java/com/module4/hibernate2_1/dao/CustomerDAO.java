package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Customer;

public class CustomerDAO extends BaseDAOImpl<Customer, Short> {
    public CustomerDAO() {
        super(Customer.class);
    }

}