package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.JobRoleRepository;
import com.scgj.sdms.model.JobRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRoleService {
    @Autowired
    JobRoleRepository jobRoleRepository;
    public JobRole findByJobRoleCodeAndJobRole(String jobRoleCode,String jobRole)
    {
        return jobRoleRepository.findByJobRoleCodeAndJobRole(jobRoleCode,jobRole);
    }
    public JobRole save(JobRole jobRole)
    {
        return jobRoleRepository.save(jobRole);
    }
    public JobRole findByJobRole(String jobRole)
    {
        return jobRoleRepository.findByJobRole(jobRole);
    }
}
