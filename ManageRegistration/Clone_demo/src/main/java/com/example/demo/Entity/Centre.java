package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Centre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Centre_id")
    private Integer centreId;

    @Column(name="Centre_name")
    private String centreName;

    public TrainingPartner getTrainingPartnerId() {
        return trainingPartnerId;
    }

    public void setTrainingPartnerId(TrainingPartner trainingPartnerId) {
        this.trainingPartnerId = trainingPartnerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Training_partner_id ")
    private TrainingPartner trainingPartnerId;

    public Integer getCentreId() {
        return centreId;
    }

    public void setCentreId(Integer centreId) {
        this.centreId = centreId;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getCentrePoContactName() {
        return centrePoContactName;
    }

    public void setCentrePoContactName(String centrePoContactName) {
        this.centrePoContactName = centrePoContactName;
    }

    public String getCentreAddress() {
        return centreAddress;
    }

    public void setCentreAddress(String centreAddress) {
        this.centreAddress = centreAddress;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    @Column(name ="Centre_po_contact_name")

    private String centrePoContactName;

    @Column(name ="Cenre_address")
    private String centreAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location_id")
    private Location locationId;

}
