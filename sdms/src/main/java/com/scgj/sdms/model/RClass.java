package com.scgj.sdms.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigInteger;
import java.util.Date;

public class RClass {

    private Integer application_id;
    private String username;
    private String status;
    private String comments;
    private String batchid;
    private Integer tid;

    private Date date;
    private Date assessDate;
    private int batchstrength;
    private String tpname;
    // default constructor
    public RClass() {
    }
// parameterized constructor



    public RClass(Integer application_id, String username, String status, String comments, String batchid, Integer tid, Date date, Date assessDate, int batchstrength, String tpname) {
        this.application_id = application_id;
        this.username = username;
        this.status = status;
        this.comments = comments;
        this.batchid = batchid;
        this.tid = tid;
        this.date = date;
        this.assessDate = assessDate;
        this.batchstrength = batchstrength;
        this.tpname = tpname;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
    }

    public int getBatchstrength() {
        return batchstrength;
    }

    public void setBatchstrength(int batchstrength) {
        this.batchstrength = batchstrength;
    }

    public String getTpname() {
        return tpname;
    }

    public void setTpname(String tpname) {
        this.tpname = tpname;
    }

    public Integer getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Integer application_id) {
        this.application_id = application_id;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }


    @Override
    public String toString() {
        return "Rclass{" +
                "application_id=" + application_id +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", batchid=" + batchid +
                ", tid=" + tid +
                ", date=" + date +
                ", assessDate=" + assessDate +
                ", batchstrength=" + batchstrength +
                ", tpname='" + tpname + '\'' +
                '}';
    }
}

