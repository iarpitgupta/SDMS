package com.scgj.manage;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component("application")
public class Application {

    private int applicationId;
    private String institueName;
    private String appType;
    private Date submitDate;
    private String location;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getInstitueName() {
        return institueName;
    }

    public void setInstitueName(String institueName) {
        this.institueName = institueName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAppComment() {
        return appComment;
    }

    public void setAppComment(String appComment) {
        this.appComment = appComment;
    }

    public AppStatus getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(AppStatus appStatus) {
        this.appStatus = appStatus;
    }

    private String appComment;

    public enum AppStatus {SUBMIT, REJECTED, APPROVED}

    ;
    private AppStatus appStatus;

}