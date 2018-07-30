package com.model;

import javax.persistence.*;

@Entity
@Table(name="Training_Partner")
public class TrainingPartner {

    @Id
    @Column(name=" Training_partner_id ")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trainingPartnerId;

    public String getTrainingPartnerName() {
        return trainingPartnerName;
    }

    public void setTrainingPartnerName(String trainingPartnerName) {
        this.trainingPartnerName = trainingPartnerName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Application_id")
    private Application applicationId;

    @Column(name="Training_partner_name")
    private String trainingPartnerName;
}
