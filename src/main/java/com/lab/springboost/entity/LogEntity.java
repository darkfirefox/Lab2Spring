package com.lab.springboost.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "log", schema = "public", catalog = "pavel")
public class LogEntity {
    private Integer id;
    private String classname;
    private String typechange;
    private String value;

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
    @Column(name = "classname")
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
    @Basic
    @Column(name = "typechange")
    public String getTypechange() {
        return typechange;
    }

    public void setTypechange(String typechange) {
        this.typechange = typechange;
    }
    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return Objects.equals(id, logEntity.id) &&
                Objects.equals(classname, logEntity.classname) &&
                Objects.equals(typechange, logEntity.typechange) &&
                Objects.equals(value, logEntity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classname, typechange, value);
    }
}
