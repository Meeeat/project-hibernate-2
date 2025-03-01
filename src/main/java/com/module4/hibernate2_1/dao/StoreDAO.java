package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Store;

public class StoreDAO extends BaseDAOImpl<Store, Byte> {
    public StoreDAO() {
        super(Store.class);
    }

}