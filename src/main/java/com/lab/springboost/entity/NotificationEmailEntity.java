package com.lab.springboost.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notification", schema = "public", catalog = "pavel")
public class NotificationEmailEntity implements Serializable {
    private Integer id;
    private String email;
    private String condition;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Basic
    @Column(name = "condition")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
