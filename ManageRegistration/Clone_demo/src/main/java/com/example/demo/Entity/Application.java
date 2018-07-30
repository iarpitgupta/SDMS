package com.example.demo.Entity;

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
    private User user;

    @Column(name = "Application_status")
    private String applicationStatus;

    @Column(name="Application_comment")
    private String getApplicationComment;

    @Column(name="Submission_date")
    private Date  submissionDate;

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
