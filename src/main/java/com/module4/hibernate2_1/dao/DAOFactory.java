package com.module4.hibernate2_1.dao;

public class DAOFactory {

    private static final ActorDAO actorDAO = new ActorDAO();
    private static final AddressDAO addressDAO = new AddressDAO();
    private static final CategoryDAO categoryDAO = new CategoryDAO();
    private static final CityDAO cityDAO = new CityDAO();
    private static final CountryDAO countryDAO = new CountryDAO();
    private static final CustomerDAO customerDAO = new CustomerDAO();
    private static final FilmDAO filmDAO = new FilmDAO();
    private static final InventoryDAO inventoryDAO = new InventoryDAO();
    private static final LanguageDAO languageDAO = new LanguageDAO();
    private static final PaymentDAO paymentDAO = new PaymentDAO();
    private static final RentalDAO rentalDAO = new RentalDAO();
    private static final StaffDAO staffDAO = new StaffDAO();
    private static final StoreDAO storeDAO = new StoreDAO();

    public static ActorDAO getActorDAO() {
        return actorDAO;
    }

    public static AddressDAO getAddressDAO() {
        return addressDAO;
    }

    public static CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public static CityDAO getCityDAO() {
        return cityDAO;
    }

    public static CountryDAO getCountryDAO() {
        return countryDAO;
    }

    public static CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public static FilmDAO getFilmDAO() {
        return filmDAO;
    }

    public static InventoryDAO getInventoryDAO() {
        return inventoryDAO;
    }

    public static LanguageDAO getLanguageDAO() {
        return languageDAO;
    }

    public static PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public static RentalDAO getRentalDAO() {
        return rentalDAO;
    }

    public static StaffDAO getStaffDAO() {
        return staffDAO;
    }

    public static StoreDAO getStoreDAO() {
        return storeDAO;
    }

}