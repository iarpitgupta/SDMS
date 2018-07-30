package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Trainer_id")
    private Integer trainerId;

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public TrainingPartner getTrainingPartnerId() {
        return trainingPartnerId;
    }

    public void setTrainingPartnerId(TrainingPartner trainingPartnerId) {
        this.trainingPartnerId = trainingPartnerId;
    }

    @Column(name="Trainer_name")

    private String trainerName;

    @Column(name="Designation")
    private String designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Training_partner_id ")
    private TrainingPartner trainingPartnerId;
}
