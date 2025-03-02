package com.module4.hibernate2_1.service;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.dao.DAOFactory;
import com.module4.hibernate2_1.dao.PaymentDAO;
import com.module4.hibernate2_1.dao.RentalDAO;
import com.module4.hibernate2_1.dao.StaffDAO;
import com.module4.hibernate2_1.entity.Payment;
import com.module4.hibernate2_1.entity.Rental;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentalService {

    private final RentalDAO rentalDAO = DAOFactory.getRentalDAO();
    private final PaymentDAO paymentDAO = DAOFactory.getPaymentDAO();
    private final StaffDAO staffDAO = DAOFactory.getStaffDAO();

    public void returnRentedFilm(int rentalId, byte staffId, BigDecimal amount) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Rental rental = rentalDAO.findById(rentalId);
            if (rental == null) {
                throw new RuntimeException("Rental not found with ID: " + rentalId);
            }

            if (rental.getReturnDate() == null) {
                rental.setReturnDate(LocalDateTime.now());
                rentalDAO.update(rental);

                if (amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
                    Payment payment = new Payment();
                    payment.setCustomer(rental.getCustomer());
                    payment.setStaff(staffDAO.findById(staffId));
                    payment.setRental(rental);
                    payment.setAmount(amount);
                    payment.setPaymentDate(LocalDateTime.now());
                    paymentDAO.save(payment);
                }
            } else {
                System.out.println("Film already returned for rental ID: " + rentalId);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to return rented film", e);
        } finally {
            session.close();
        }
    }
}