package com.module4.hibernate2.domain;

public enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG13"),
    R("R"),
    NC17("NC17");

    private final String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}