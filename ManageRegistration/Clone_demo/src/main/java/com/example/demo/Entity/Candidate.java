package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="Candidate")
public class Candidate {
   @Id
   @Column(name="Candidate_id ")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer candidateId;

   @Column(name="Candidate_name")
   private String candidateName;

   @Column(name="Enrollment_no")
   private long enrollmentNo;

   @Column(name="gender")
   private String gender;

   @Column(name="Dob")
   private Date dob;

   @Column(name="Name_father_husband")
    private  String nameOfFatherOrHusband;

   @Column(name="Aadhar_no")
     private BigInteger aadharNo;

   @Column(name="Mobile_no")
   private BigInteger mobileNo;

   @Column(name="Email")
   private String email;

   @Column(name="Education")
   private String education;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Trainer_id")
   private Trainer trainerId;

    @Column(name="Marks_obtained_theory")
    private int marksObtainerTheory;

    @Column(name="Marks_obtained_practical")
    private  int marksObtainedPractical;

    @Column(name = "Result")
    private String  result;

    public String getTraineeAddress() {
        return traineeAddress;
    }

    public void setTraineeAddress(String traineeAddress) {
        this.traineeAddress = traineeAddress;
    }

    public int getTraineePinCode() {
        return traineePinCode;
    }

    public void setTraineePinCode(int traineePinCode) {
        this.traineePinCode = traineePinCode;
    }

    @Column(name="Trainee_address")
    private String traineeAddress;

    @Column(name="Trainee_pin_code")
    private int traineePinCode;

    @Column(name="Certified")
    private String certified;

    @Column(name="Placement_status")
    private String placementStatus;

    @Column(name="Date_of_joining")
    private Date dateOfJoining;

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public long getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(long enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNameOfFatherOrHusband() {
        return nameOfFatherOrHusband;
    }

    public void setNameOfFatherOrHusband(String nameOfFatherOrHusband) {
        this.nameOfFatherOrHusband = nameOfFatherOrHusband;
    }

    public BigInteger getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(BigInteger aadharNo) {
        this.aadharNo = aadharNo;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Trainer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Trainer trainerId) {
        this.trainerId = trainerId;
    }

    public int getMarksObtainerTheory() {
        return marksObtainerTheory;
    }

    public void setMarksObtainerTheory(int marksObtainerTheory) {
        this.marksObtainerTheory = marksObtainerTheory;
    }

    public int getMarksObtainedPractical() {
        return marksObtainedPractical;
    }

    public void setMarksObtainedPractical(int marksObtainedPractical) {
        this.marksObtainedPractical = marksObtainedPractical;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
    }

    public String getPlacementStatus() {
        return placementStatus;
    }

    public void setPlacementStatus(String placementStatus) {
        this.placementStatus = placementStatus;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    @Column(name="Employee_type")
    private String employmentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Batch_id")
    private Batch batchId;
}
