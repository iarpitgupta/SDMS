package com.scgj.sdms.model;
import java.util.Date;

public class AssessorAttributes {
    private int aid;
    private Date date;
    private String username;
    private String status;
    private String bid;
    private String tpname;
    private Date assessDate;
    private String district;
    private int strength;
    private String comments;

    public AssessorAttributes() {
    }

    public AssessorAttributes(int aid, Date date, String username, String status, String bid, String tpname, Date assessDate, String district, int strength, String comments) {
        this.aid = aid;
        this.date = date;
        this.username = username;
        this.status = status;
        this.bid = bid;
        this.tpname = tpname;
        this.assessDate = assessDate;
        this.district = district;
        this.strength = strength;
        this.comments=comments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String  getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTpname() {
        return tpname;
    }

    public void setTpname(String tpname) {
        this.tpname = tpname;
    }

    public Date getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

