package com.lab.springboost.entity;

import com.lab.springboost.JMS.AuditListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "prescription", schema = "public", catalog = "pavel")
@XmlRootElement(name = "prescription")
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners({AuditListener.class})
public class PrescriptionEntity implements Serializable {
    @XmlElement
    private Integer id;
    @XmlElement
    private Timestamp datetime;
    @XmlElement
    private String description;
    @XmlElement
    private String priority;
    @XmlElement(name = "doctor")
    private DoctorEntity doctorByIddoctor;
    @XmlElement(name = "patient")
    private PatientEntity patientByIdpatient;

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
    @Column(name = "datetime")
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionEntity entity = (PrescriptionEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(datetime, entity.datetime) &&
                Objects.equals(description, entity.description) &&
                Objects.equals(priority, entity.priority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, datetime, description, priority);
    }

    @ManyToOne
    @JoinColumn(name = "iddoctor", referencedColumnName = "id")
    public DoctorEntity getDoctorByIddoctor() {
        return doctorByIddoctor;
    }

    public void setDoctorByIddoctor(DoctorEntity doctorByIddoctor) {
        this.doctorByIddoctor = doctorByIddoctor;
    }

    @ManyToOne
    @JoinColumn(name = "idpatient", referencedColumnName = "id")
    public PatientEntity getPatientByIdpatient() {
        return patientByIdpatient;
    }

    public void setPatientByIdpatient(PatientEntity patientByIdpatient) {
        this.patientByIdpatient = patientByIdpatient;
    }
}
