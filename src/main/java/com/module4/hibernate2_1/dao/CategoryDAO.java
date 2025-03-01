package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Category;

public class CategoryDAO extends BaseDAOImpl<Category, Byte> {
    public CategoryDAO() {
        super(Category.class);
    }

}