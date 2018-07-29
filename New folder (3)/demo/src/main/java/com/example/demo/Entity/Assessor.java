package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Assessor")
public class Assessor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int assesorId;

    @Column
    private String assesorName;

    @Column
    private String email;

    @Column
    private String location;

    @Column
    private String designation;

    @Column
    private long contactNumber;

    @Column
    private String qualification;

    @Column
    private String experience;

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getAssesorId() {
        return assesorId;
    }

    public void setAssesorId(int assesorId) {
        this.assesorId = assesorId;
    }

    public String getAssesorName() {
        return assesorName;
    }

    public void setAssesorName(String assesorName) {
        this.assesorName = assesorName;
    }

    public AssessmentAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(AssessmentAgency agencyId) {
        this.agencyId = agencyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Agency_id")
    private AssessmentAgency agencyId;


}
