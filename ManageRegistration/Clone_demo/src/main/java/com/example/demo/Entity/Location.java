package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @Column(name = "Location_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locationId;

    @Column(name = "District")
    private String  district;

    @Column(name="State")
    private String state;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
