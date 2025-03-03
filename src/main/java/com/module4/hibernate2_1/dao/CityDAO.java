package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.entity.City;
import com.module4.hibernate2_1.entity.Country;
import org.hibernate.Session;

public class CityDAO extends BaseDAOImpl<City, Short> {
    public CityDAO() {
        super(City.class);
    }

    public City findByNameAndCountry(String name, Country country) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            String query = "FROM City WHERE city = :name AND country = :country";

            return session.createQuery(query, City.class)
                    .setParameter("name", name)
                    .setParameter("country", country)
                    .uniqueResult();
        }
    }

}