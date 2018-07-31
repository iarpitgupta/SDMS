package com.scgj.sdms.model;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Batch")
public class Batch {
    public Batch() {
    }

    @Column(name = "Batch_end_date")
    private Date batchEndDate;
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

    public Date getBatchEndDate() {
        return batchEndDate;
    }

    public void setBatchEndDate(Date batchEndDate) {
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
    private java.util.Date batchStartDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Job_role_id")
    private JobRole jobRole;

    @Column(name = "Level")
    private int level;

    @Column(name = "Max_marks_theory")
    private int maxMarksTheory;

    @Column(name = "Max_marks_prcatical")
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
    private Date resultApprovedDate;

    @Column(name = "Total_pass")
    private int totalPass;

    @Column(name = "Total_fail")
    private int totalFail;

    @Column(name = " Total_not_appeared")
    private int totalNotAppeared;

    @Column(name = "Total_certified ")
    private int totalCertified;

    @Column(name = "Batch_assignment_date")
    private Date batchAssinmentDate;

    @Column(name = "Assessment")
    private Date assessmentDate;

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

    public Date getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
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
    @JoinColumn(name = "Assessor_id")
    private Assessor assesorId;

    @Column(name="batch_status")
    String batchStatus;

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Batch(String[] argList) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
       // String datePatterns[]={"dd-MM-yyyy","dd/MM/yyyy"};
        this.batchId = argList[0];
        this.batchName = argList[1];
        this.batchType = argList[2];
        System.out.println("arglist"+argList[6]);
        if(!(argList[6].isEmpty())){
            System.out.println("arglist"+argList[6]);
        this.totalCandidatesInBatch = Integer.valueOf(argList[6].trim());}
        this.batchMode = argList[7];
        if(!(argList[8].isEmpty()))
        this.batchStartDate =(df.parse(argList[8].trim()));
        System.out.println("argList[9]"+argList[9]);
        if(!(argList[9].isEmpty())&&(argList[9].length()==10))
        this.batchEndDate = df.parse(argList[9].trim());
        if(!(argList[12].isEmpty()))
        {
        this.maxMarksTheory = Integer.valueOf(argList[12].trim());}
        if(!(argList[13].isEmpty()))
        {
        this.maxMarksPractical = Integer.valueOf(argList[13].trim());}
        if(!(argList[14].isEmpty()))
        {
        this.level = Integer.valueOf(argList[14].trim());}
        this.resultApproved = argList[15];
        if(!(argList[16].isEmpty()))
        this.resultApprovedDate = df.parse(argList[16].trim());
        if(!(argList[17].isEmpty()))
        {
            this.totalPass = Integer.valueOf(argList[17].trim());}
        if(!(argList[18].isEmpty()))
        {
            this.totalFail = Integer.valueOf(argList[18].trim());}
        if(!(argList[19].isEmpty())) {
            this.totalNotAppeared = Integer.valueOf(argList[19].trim());
        }
        if(!(argList[20].isEmpty())) {
            this.totalCertified = Integer.valueOf(argList[20].trim());
        }
        if(!(argList[21].isEmpty()))
        this.batchAssinmentDate = df.parse(argList[21].trim());
        if(!(argList[22].isEmpty()))
        this.assessmentDate = (Date)DateUtils.parseDate(argList[22].trim());

    }
}
