package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.entity.Rental;
import org.hibernate.Session;

public class RentalDAO extends BaseDAOImpl<Rental, Integer> {
    public RentalDAO() {
        super(Rental.class);
    }

    public Rental findLastRentalByInventoryId(int inventoryId) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            String query = "FROM Rental WHERE inventory.id = :inventoryId ORDER BY rentalDate DESC";

            return session.createQuery(query, Rental.class)
                    .setParameter("inventoryId", inventoryId)
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }

}