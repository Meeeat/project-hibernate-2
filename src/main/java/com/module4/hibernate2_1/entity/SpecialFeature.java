package com.module4.hibernate2_1.entity;

import static java.util.Objects.isNull;

public enum SpecialFeature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    SpecialFeature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SpecialFeature getFeatureByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }
        for (SpecialFeature specialFeature : values()) {
            if (specialFeature.value.equals(value)) {
                return specialFeature;
            }
        }
        return null;
    }
}