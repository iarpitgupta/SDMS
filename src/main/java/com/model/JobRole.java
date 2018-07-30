package com.model;

import javax.persistence.*;

@Entity
@Table(name = "Job_role")
public class JobRole {

    @Id
    @Column(name = "Job_role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobRoleId;

    @Column(name = "Job_role")
    private String jobRole;

    public long getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(long jobRoleId) {
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

    @Column(name="Job_role_code")
    private String jobRoleCode;


}
