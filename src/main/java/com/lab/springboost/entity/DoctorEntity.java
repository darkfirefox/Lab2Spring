package com.lab.springboost.entity;

import com.lab.springboost.JMS.AuditListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "doctor", schema = "public", catalog = "pavel")
@XmlRootElement(name = "doctor")
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners({AuditListener.class})
public class DoctorEntity implements Serializable {
    @XmlElement
    private Integer id;
    @XmlElement
    private String firstname;
    @XmlElement
    private String fathername;
    @XmlElement
    private String lastname;
    @XmlElement
    private String specification;

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
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "fathername")
    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(fathername, that.fathername) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(specification, that.specification);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, fathername, lastname, specification);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(id).append(' ')
                .append(firstname).append(' ')
                .append(fathername).append(' ')
                .append(lastname).toString();
    }

}
