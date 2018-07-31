package com.scgj.sdms.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Assessor")
public class Assessor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Assesor_id")

    //@OneToMany(mappedBy = "assesorId")
    private int assesorId;

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name = "contact_no")

    private long contactNumber;

    @Column(name="Assesor_name")
    private String assesorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location_id")
    private Location locationId;
    @Column(name = "designation")
    private String designation;
    @Column(name = "experience")
    String experience;
    @Column(name = "qualification")
    String qualification;
    @Column(name = "email")
    String email;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public AssessmentAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(AssessmentAgency agencyId) {
        this.agencyId = agencyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Agency_id")
    private AssessmentAgency agencyId;


}
