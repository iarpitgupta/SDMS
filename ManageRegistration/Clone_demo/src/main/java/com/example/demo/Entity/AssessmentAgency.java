package com.example.demo.Entity;



import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Assessment_agency")
public class AssessmentAgency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Agency_id")
    private int agencyId;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Application_id")
    private Application application;

    @Column(name = "Agency_name")
    private String agencyName;


    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }
}
