package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Film;

public class FilmDAO extends BaseDAOImpl<Film, Short> {
    public FilmDAO() {
        super(Film.class);
    }

}