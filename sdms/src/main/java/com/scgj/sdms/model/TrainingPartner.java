package com.scgj.sdms.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Training_Partner")
public class TrainingPartner {

    @Id
    @Column(name=" Training_partner_id ")
   // @OneToMany(mappedBy = "trainingPartnerId")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String trainingPartnerId;

    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public void setTrainingPartnerName(String trainingPartnerName) {
        this.trainingPartnerName = trainingPartnerName;
    }

    public String getTrainingPartnerId() {
        return trainingPartnerId;
    }

    public void setTrainingPartnerId(String trainingPartnerId) {
        this.trainingPartnerId = trainingPartnerId;
    }

    public Application getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Application applicationId) {
        this.applicationId = applicationId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Application_id")
    private Application applicationId;

    @Column(name="Training_partner_name")
    private String trainingPartnerName;
}
