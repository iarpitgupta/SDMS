package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Assessor")
public class Assessor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Assesor_id")
    private int assesorId;

    @Column(name="Assesor_name")
    private String assesorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Location_id")
    private Location locationId;

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
