package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Rental;

public class RentalDAO extends BaseDAOImpl<Rental, Integer> {
    public RentalDAO() {
        super(Rental.class);
    }

}