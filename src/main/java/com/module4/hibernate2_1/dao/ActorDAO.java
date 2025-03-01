package com.module4.hibernate2_1.dao;

import com.module4.hibernate2_1.entity.Actor;

public class ActorDAO extends BaseDAOImpl<Actor, Short> {
    public ActorDAO() {
        super(Actor.class);
    }

}