package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.entity.Country;
import org.hibernate.Session;

public class CountryDAO extends BaseDAOImpl<Country, Short> {
    public CountryDAO() {
        super(Country.class);
    }

    public Country findByName(String name) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            String query = "FROM Country WHERE country = :name";

            return session.createQuery(query, Country.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

}