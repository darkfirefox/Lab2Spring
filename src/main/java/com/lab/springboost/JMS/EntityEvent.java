package com.lab.springboost.JMS;

import java.io.Serializable;

public class EntityEvent implements Serializable {
    private Object entity;
    private String method;

    public EntityEvent(Object entity, String method) {
        this.entity = entity;
        this.method = method;
    }

    public Object getEntity() {
        return entity;
    }

    public String getMethod() {
        return method;
    }
}
