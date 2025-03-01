package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Staff;

public class StaffDAO extends BaseDAOImpl<Staff, Byte> {
    public StaffDAO() {
        super(Staff.class);
    }

}