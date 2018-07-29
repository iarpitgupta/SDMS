package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name="Application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Application_id")
    private Integer applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_Id")
    private User userId;

    @Column(name = "Application_status")
    private String applicationStatus;

    @Column(name="Application_comment")
    private String getApplicationComment;


    @Column(name = "submission_date")
    private java.sql.Date submissionDate;

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(java.sql.Date submissionDate) {
        this.submissionDate = submissionDate;
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


}
