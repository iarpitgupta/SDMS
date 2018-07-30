package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="Batch")
public class Batch {


    @Id
    @Column(name = "Batch_id ")
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int batchId;

    @Column(name = "Batch_name")
    private String batchType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Training_partner_id")
    private TrainingPartner trainingPartnerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Centre_id")
     private Centre centreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Trainer_id")
    private  Trainer trainerId;

    @Column(name="Total_candidates_in_batch")
    private int totalCandidatesInBatch;

    @Column(name="Batch_mode")
    private String batchMode;

    @Column(name="Batch_start_date")
    private Date batchStartDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Job_role_id")
     private  JobRole jobRoleId;

    @Column(name="Level")
    private int level;

    @Column(name="Result_approved")
    private boolean resultApproved;

    @Column(name="Result_approved_date")
    private Date resultApprovedDate;

    @Column(name="Total_pass")
    private int totalPass;

    @Column(name="Total_fail")
    private int totalFail;

    @Column(name=" Total_not_appeared")
    private int totalNotAppeared;

    @Column(name = "Total_certified ")
    private int totalCertified;

    @Column(name="Batch_assignment_date")
    private Date batchAssinmentDate;

    @Column(name = "Assessment_date")
    private Date assessmentDate;

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

    public TrainingPartner getTrainingPartnerId() {
        return trainingPartnerId;
    }

    public void setTrainingPartnerId(TrainingPartner trainingPartnerId) {
        this.trainingPartnerId = trainingPartnerId;
    }

    public Centre getCentreId() {
        return centreId;
    }

    public void setCentreId(Centre centreId) {
        this.centreId = centreId;
    }

    public Trainer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Trainer trainerId) {
        this.trainerId = trainerId;
    }

    public int getTotalCandidatesInBatch() {
        return totalCandidatesInBatch;
    }

    public void setTotalCandidatesInBatch(int totalCandidatesInBatch) {
        this.totalCandidatesInBatch = totalCandidatesInBatch;
    }

    public String getBatchMode() {
        return batchMode;
    }

    public void setBatchMode(String batchMode) {
        this.batchMode = batchMode;
    }

    public Date getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public JobRole getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(JobRole jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isResultApproved() {
        return resultApproved;
    }

    public void setResultApproved(boolean resultApproved) {
        this.resultApproved = resultApproved;
    }

    public Date getResultApprovedDate() {
        return resultApprovedDate;
    }

    public void setResultApprovedDate(Date resultApprovedDate) {
        this.resultApprovedDate = resultApprovedDate;
    }

    public int getTotalPass() {
        return totalPass;
    }

    public void setTotalPass(int totalPass) {
        this.totalPass = totalPass;
    }

    public int getTotalFail() {
        return totalFail;
    }

    public void setTotalFail(int totalFail) {
        this.totalFail = totalFail;
    }

    public int getTotalNotAppeared() {
        return totalNotAppeared;
    }

    public void setTotalNotAppeared(int totalNotAppeared) {
        this.totalNotAppeared = totalNotAppeared;
    }

    public int getTotalCertified() {
        return totalCertified;
    }

    public void setTotalCertified(int totalCertified) {
        this.totalCertified = totalCertified;
    }

    public Date getBatchAssinmentDate() {
        return batchAssinmentDate;
    }

    public void setBatchAssinmentDate(Date batchAssinmentDate) {
        this.batchAssinmentDate = batchAssinmentDate;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public AssessmentAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(AssessmentAgency agencyId) {
        this.agencyId = agencyId;
    }

    public Assessor getAssesorId() {
        return assesorId;
    }

    public void setAssesorId(Assessor assesorId) {
        this.assesorId = assesorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Agency_id ")
    private  AssessmentAgency agencyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Assesor_id")
    private Assessor assesorId;


}
