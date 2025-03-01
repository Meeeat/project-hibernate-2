package com.module4.hibernate2.dao;

import com.module4.hibernate2.domain.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends GenericDAO<Category> {

    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}