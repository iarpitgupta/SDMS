package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Job_role")
public class JobRole {

    @Id
    @Column(name = "Job_role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobRoleId;

    @Column(name = "Job_role")
    private String jobRole;

    public Integer getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(Integer jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobRoleCode() {
        return jobRoleCode;
    }

    public void setJobRoleCode(String jobRoleCode) {
        this.jobRoleCode = jobRoleCode;
    }

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

    @Column(name="Job_role_code")
    private String jobRoleCode;

    @Column(name = "Max_marks_theory")
    private int maxMarksTheory;

    @Column(name = "Max_marks_practical")
    private int maxMarksPractical;
}
