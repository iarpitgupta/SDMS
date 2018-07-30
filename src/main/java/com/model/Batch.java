package com.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Batch")
public class Batch {

    @Column(name = "Batch_end_date")
    private LocalDate batchEndDate;
    @Id
    @Column(name = "Batch_id ")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String batchId;

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    @Column(name = "Batch_name")
    private String batchName;

    @Column(name = "Batch_type")
    private String batchType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Training_partner_id")
    private TrainingPartner trainingPartnerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Centre_id")
    private Centre centreId;

    public LocalDate getBatchEndDate() {
        return batchEndDate;
    }

    public void setBatchEndDate(LocalDate batchEndDate) {
        this.batchEndDate = batchEndDate;
    }

    public Centre getCentreId() {
        return centreId;
    }

    public void setCentreId(Centre centreId)
    {
        this.centreId = centreId;
    }

    public String getResultApproved() {
        return resultApproved;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Trainer_id")
    private Trainer trainerId;

    @Column(name = "Total_candidates_in_batch")
    private int totalCandidatesInBatch;

    @Column(name = "Batch_mode")
    private String batchMode;

    @Column(name = "Batch_start_date")
    private LocalDate batchStartDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobRole jobRole;

    @Column(name = "Level")
    private int level;

    @Column(name = "Max_marks_theory")
    private int maxMarksTheory;

    @Column(name = "Max_marks_practical")
    private int maxMarksPractical;

    @Column(name = "Result_approved")
    private String resultApproved;

    public int getMaxMarksTheory() {
        return maxMarksTheory;
    }

    public void setMaxMarksTheory(int maxMarksTheory) {
        this.maxMarksTheory = maxMarksTheory;
    }

    public int getMaxMarksPractical() {
        return maxMarksPractical;
    }

    public void setMaxMarksPractical(int maxMarksPractical) {
        this.maxMarksPractical = maxMarksPractical;
    }

    @Column(name = "Result_approved_date")
    private LocalDate resultApprovedDate;

    @Column(name = "Total_pass")
    private int totalPass;

    @Column(name = "Total_fail")
    private int totalFail;

    @Column(name = " Total_not_appeared")
    private int totalNotAppeared;

    @Column(name = "Total_certified ")
    private int totalCertified;

    @Column(name = "Batch_assignment_date")
    private LocalDate batchAssinmentDate;

    @Column(name = "Assessment_date")
    private LocalDate assessmentDate;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
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

    public LocalDate getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(LocalDate batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
    }

    public void setTrainingPartnerId(TrainingPartner trainingPartnerId) {
        this.trainingPartnerId = trainingPartnerId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String isResultApproved() {
        return resultApproved;
    }

    public void setResultApproved(String resultApproved) {
        this.resultApproved = resultApproved;
    }

    public LocalDate getResultApprovedDate() {
        return resultApprovedDate;
    }

    public void setResultApprovedDate(LocalDate resultApprovedDate) {
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

    public LocalDate getBatchAssinmentDate() {
        return batchAssinmentDate;
    }

    public void setBatchAssinmentDate(LocalDate batchAssinmentDate) {
        this.batchAssinmentDate = batchAssinmentDate;
    }

    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }




    public AssessmentAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(AssessmentAgency agencyId) {
        this.agencyId = agencyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Agency_id ")
    private AssessmentAgency agencyId;

    public Assessor getAssesorId() {
        return assesorId;
    }

    public void setAssesorId(Assessor assesorId) {
        this.assesorId = assesorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Assesor_id")
    private Assessor assesorId;


    public Batch(String[] argList) {
        //  SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
        jobRole = new JobRole();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.batchId = argList[0];
        this.batchName = argList[1];
        this.batchType = argList[2];
       // this.trainingPartnerId = String.valueOf(argList[3]);
      //  this.centreId = 1;
       // this.trainerId = Integer.parseInt("1");
        this.totalCandidatesInBatch = 30;
        this.batchMode = argList[7];
        this.batchStartDate = LocalDate.parse("22-02-1994", df);
        this.batchEndDate = LocalDate.parse("22-02-1994", df);
        jobRole.setJobRole(argList[10]);
        jobRole.setJobRoleCode(argList[11]);
        this.maxMarksTheory = 35;
        this.maxMarksPractical = 35;
        this.level = 1;
        this.resultApproved = argList[15];
        this.resultApprovedDate = LocalDate.parse("22-02-1994", df);
        this.totalPass = 1;
        this.totalFail = 1;
        this.totalNotAppeared = 1;
        this.totalCertified = 1;
        this.batchAssinmentDate = LocalDate.parse("22-02-1994", df);
        this.assessmentDate = LocalDate.parse("22-02-1994", df);
       // this.agencyId = 1;
       // this.assesorId =1;


    }
}
