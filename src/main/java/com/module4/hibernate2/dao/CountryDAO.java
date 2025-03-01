package com.module4.hibernate2.dao;

import com.module4.hibernate2.domain.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends GenericDAO<Country> {

    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}