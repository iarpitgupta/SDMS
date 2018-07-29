package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Training_Partner")
public class TrainingPartner {

    @Id
    @Column(name="Training_partner_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trainingPartnerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Application_id")
    private Application application;

    @Column(name="Training_partner_name")
    private String trainingPartnerName;

    public Integer getTrainingPartnerId() {
        return trainingPartnerId;
    }

    public void setTrainingPartnerId(Integer trainingPartnerId) {
        this.trainingPartnerId = trainingPartnerId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public void setTrainingPartnerName(String trainingPartnerName) {
        this.trainingPartnerName = trainingPartnerName;
    }

}
