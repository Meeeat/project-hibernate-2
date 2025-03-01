package com.module4.hibernate2_1.service;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.dao.*;
import com.module4.hibernate2_1.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {

    private final CustomerDAO customerDAO = DAOFactory.getCustomerDAO();
    private final AddressDAO addressDAO = DAOFactory.getAddressDAO();
    private final CityDAO cityDAO = DAOFactory.getCityDAO();
    private final CountryDAO countryDAO = DAOFactory.getCountryDAO();
    private final StoreDAO storeDAO = DAOFactory.getStoreDAO();

    public void createNewCustomer(
            String firstName,
            String lastName,
            String email,
            String address,
            String district,
            String cityName,
            String countryName,
            String postalCode,
            String phone
    ) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Country country = countryDAO.findByName(countryName);
            if (country == null) {
                country = new Country();
                country.setCountry(countryName);
                countryDAO.save(country);
            }

            City city = cityDAO.findByNameAndCountry(cityName, country);
            if (city == null) {
                city = new City();
                city.setCity(cityName);
                city.setCountry(country);
                cityDAO.save(city);
            }

            Address customerAddress = new Address();
            customerAddress.setAddress(address);
            customerAddress.setDistrict(district);
            customerAddress.setCity(city);
            customerAddress.setPostalCode(postalCode);
            customerAddress.setPhone(phone);
            addressDAO.save(customerAddress);

            Store store = storeDAO.findById((byte) 1);
            if (store == null) {
                throw new RuntimeException("Store not found");
            }

            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setAddress(customerAddress);
            customer.setStore(store);
            customer.setActive(true);
            customerDAO.save(customer);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to create customer", e);
        } finally {
            session.close();
        }
    }
}