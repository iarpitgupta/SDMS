package com.scgj.sdms.model;

import com.scgj.sdms.model.User;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="Application")
public class Application {
    @Id
    @Column(name="Application_id")
    private Integer applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_Id")
    private User userId;
    private Date dateOfSubmission;

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getGetApplicationComment() {
        return getApplicationComment;
    }

    public void setGetApplicationComment(String getApplicationComment) {
        this.getApplicationComment = getApplicationComment;
    }

    @Column(name = "Application_status")
    private String applicationStatus;

    @Column(name="Application_comment")
    private String getApplicationComment;

}
