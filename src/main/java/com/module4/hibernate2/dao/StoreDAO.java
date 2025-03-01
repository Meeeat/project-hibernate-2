package com.module4.hibernate2.dao;

import com.module4.hibernate2.domain.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends GenericDAO<Store> {

    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}