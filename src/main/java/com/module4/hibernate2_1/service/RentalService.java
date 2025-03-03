package com.module4.hibernate2_1.service;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.dao.*;
import com.module4.hibernate2_1.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class RentalService {

    private final RentalDAO rentalDAO = DAOFactory.getRentalDAO();
    private final PaymentDAO paymentDAO = DAOFactory.getPaymentDAO();
    private final StaffDAO staffDAO = DAOFactory.getStaffDAO();
    private final InventoryDAO inventoryDAO = DAOFactory.getInventoryDAO();
    private final CustomerDAO customerDAO = DAOFactory.getCustomerDAO();

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

    public void rentInventory(int customerId, int inventoryId, byte staffId, BigDecimal amount) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Customer customer = customerDAO.findById((short) customerId);
            if (customer == null) {
                throw new RuntimeException("Customer not found with ID: " + customerId);
            }

            Inventory inventory = inventoryDAO.findById(inventoryId);
            if (inventory == null) {
                throw new RuntimeException("Inventory not found with ID: " + inventoryId);
            }

            if (!isInventoryAvailable(inventoryId)) {
                throw new RuntimeException("Inventory is not available for rental: " + inventoryId);
            }

            Staff staff = staffDAO.findById(staffId);
            if (staff == null) {
                throw new RuntimeException("Staff not found with ID: " + staffId);
            }

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setRental(rental);
            payment.setAmount(amount);
            payment.setPaymentDate(LocalDateTime.now());
            paymentDAO.save(payment);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to rent inventory", e);
        } finally {
            session.close();
        }
    }

    private boolean isInventoryAvailable(int inventoryId) {
        Rental lastRental = rentalDAO.findLastRentalByInventoryId(inventoryId);

        return lastRental == null || lastRental.getReturnDate() != null;
    }

}