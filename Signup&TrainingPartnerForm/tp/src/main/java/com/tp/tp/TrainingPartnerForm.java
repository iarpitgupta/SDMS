package com.tp.tp;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table
public class TrainingPartnerForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String address;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String yearOfEstablishment;
    @Column
    private String dateOfSubmission;
    @Column
    private String qualificationPack;
    @Column
    private String nameOfCenter;
    @Column
    private String nameOH;
    @Column
    private String designationOH;
    @Column
    private String emailIdOH;
    @Column
    private String educationQualificationOH;
    @Column
    private String experienceOH;
    @Column
    private String nameAC;
    @Column
    private String DesignationAC;
    @Column
    private String emailIdAC;
    @Column
    private String educationQualificationAC;
    @Column
    private String experienceAC;
    @Column
    private String nameSPOC;
    @Column
    private String DesignationSPOC;
    @Column
    private String emailIdSPOC;
    @Column
    private String educationQualificationSPOC;
    @Column
    private String experienceSPOC;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(String yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public String getQualificationPack() {
        return qualificationPack;
    }

    public void setQualificationPack(String qualificationPack) {
        this.qualificationPack = qualificationPack;
    }

    public String getNameOfCenter() {
        return nameOfCenter;
    }

    public void setNameOfCenter(String nameOfCenter) {
        this.nameOfCenter = nameOfCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameOH() {
        return nameOH;
    }

    public void setNameOH(String nameOH) {
        this.nameOH = nameOH;
    }

    public String getDesignationOH() {
        return designationOH;
    }

    public void setDesignationOH(String designationOH) {
        this.designationOH = designationOH;
    }

    public String getEmailIdOH() {
        return emailIdOH;
    }

    public void setEmailIdOH(String emailIdOH) {
        this.emailIdOH = emailIdOH;
    }

    public String getEducationQualificationOH() {
        return educationQualificationOH;
    }

    public void setEducationQualificationOH(String educationQualificationOH) {
        this.educationQualificationOH = educationQualificationOH;
    }

    public String getExperienceOH() {
        return experienceOH;
    }

    public void setExperienceOH(String experienceOH) {
        this.experienceOH = experienceOH;
    }

    public String getNameAC() {
        return nameAC;
    }

    public void setNameAC(String nameAC) {
        this.nameAC = nameAC;
    }

    public String getDesignationAC() {
        return DesignationAC;
    }

    public void setDesignationAC(String designationAC) {
        DesignationAC = designationAC;
    }

    public String getEmailIdAC() {
        return emailIdAC;
    }

    public void setEmailIdAC(String emailIdAC) {
        this.emailIdAC = emailIdAC;
    }

    public String getEducationQualificationAC() {
        return educationQualificationAC;
    }

    public void setEducationQualificationAC(String educationQualificationAC) {
        this.educationQualificationAC = educationQualificationAC;
    }

    public String getExperienceAC() {
        return experienceAC;
    }

    public void setExperienceAC(String experienceAC) {
        this.experienceAC = experienceAC;
    }

    public String getNameSPOC() {
        return nameSPOC;
    }

    public void setNameSPOC(String nameSPOC) {
        this.nameSPOC = nameSPOC;
    }

    public String getDesignationSPOC() {
        return DesignationSPOC;
    }

    public void setDesignationSPOC(String designationSPOC) {
        DesignationSPOC = designationSPOC;
    }

    public String getEmailIdSPOC() {
        return emailIdSPOC;
    }

    public void setEmailIdSPOC(String emailIdSPOC) {
        this.emailIdSPOC = emailIdSPOC;
    }

    public String getEducationQualificationSPOC() {
        return educationQualificationSPOC;
    }

    public void setEducationQualificationSPOC(String educationQualificationSPOC) {
        this.educationQualificationSPOC = educationQualificationSPOC;
    }

    public String getExperienceSPOC() {
        return experienceSPOC;
    }

    public void setExperienceSPOC(String experienceSPOC) {
        this.experienceSPOC = experienceSPOC;
    }

    public String getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(String dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }
}

