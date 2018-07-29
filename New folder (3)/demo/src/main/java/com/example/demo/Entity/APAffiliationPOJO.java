package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Component
public class APAffiliationPOJO {

    //Application

    private String status;//hardcode
    private int userId;//hardcode

    //Assesment Agency
    private String assesmentAgencyName;

    private Date dateSubmission;// System current date

    // Assesor
    private String assesorName;
    private int agencyId; // From Assesment Agency
    private String State;


    private String designation;
    private long contactNumber;
    private String qualification;
    private String experience;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAssesmentAgencyName() {
        return assesmentAgencyName;
    }

    public void setAssesmentAgencyName(String assesmentAgencyName) {
        this.assesmentAgencyName = assesmentAgencyName;
    }

    public Date getDateSubmission() {
        return dateSubmission;
    }

    public void setDateSubmission(Date dateSubmission) {
        this.dateSubmission = dateSubmission;
    }

    public String getAssesorName() {
        return assesorName;
    }

    public void setAssesorName(String assesorName) {
        this.assesorName = assesorName;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getDesignation() {
        return designation;
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
}
