package com.module4.hibernate2_1.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, ID extends Serializable> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(ID id);
    List<T> findAll();
}