package com.module4.hibernate2.dao;

import com.module4.hibernate2.domain.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends GenericDAO<Language> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}