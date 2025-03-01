package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Address;

public class AddressDAO extends BaseDAOImpl<Address, Short> {
    public AddressDAO() {
        super(Address.class);
    }

}