package com.module4.hibernate2_1.config;

import com.module4.hibernate2_1.entity.*;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static final String DB_URL = "jdbc:p6spy:mysql://localhost:3306/movie";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";

    public static Configuration getConfiguration() {
        Configuration configuration = setupProperty();

        configuration.addAnnotatedClass(Actor.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(City.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Film.class);
        configuration.addAnnotatedClass(FilmText.class);
        configuration.addAnnotatedClass(Inventory.class);
        configuration.addAnnotatedClass(Language.class);
        configuration.addAnnotatedClass(Payment.class);
        configuration.addAnnotatedClass(Rental.class);
        configuration.addAnnotatedClass(Staff.class);
        configuration.addAnnotatedClass(Store.class);

        return configuration;
    }

    private static Configuration setupProperty() {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "com.p6spy.engine.spy.P6SpyDriver");
        configuration.setProperty("hibernate.connection.url", DB_URL);
        configuration.setProperty("hibernate.connection.username", DB_USER);
        configuration.setProperty("hibernate.connection.password", DB_PASSWORD);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
        return configuration;
    }

}