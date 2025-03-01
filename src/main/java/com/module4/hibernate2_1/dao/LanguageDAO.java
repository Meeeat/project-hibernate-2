package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Language;

public class LanguageDAO extends BaseDAOImpl<Language, Byte> {
    public LanguageDAO() {
        super(Language.class);
    }

}