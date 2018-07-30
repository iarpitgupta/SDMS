package com.model;

import javax.persistence.*;

@Entity
@Table(name="Employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employer_id")
    private long employerId;

    @Column(name = "Employer_name")
    private String employerName;

    @Column(name = "Location_of_employer")
    private String locationOfEmployer;

    public long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(long employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getLocationOfEmployer() {
        return locationOfEmployer;
    }

    public void setLocationOfEmployer(String locationOfEmployer) {
        this.locationOfEmployer = locationOfEmployer;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Location_id")
    private Location locationId;

}
