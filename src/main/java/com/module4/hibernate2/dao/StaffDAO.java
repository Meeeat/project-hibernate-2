package com.module4.hibernate2.dao;

import com.module4.hibernate2.domain.Staff;
import org.hibernate.SessionFactory;

public class StaffDAO extends GenericDAO<Staff> {

    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}