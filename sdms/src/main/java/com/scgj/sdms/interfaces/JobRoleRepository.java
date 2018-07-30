package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.JobRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepository extends CrudRepository<JobRole,Long>
{
    JobRole findByJobRoleId(Long id);
    JobRole findByJobRole(String jobRole);
    JobRole findByJobRoleCodeAndJobRole(String jobRoleCode,String jobRole);
    JobRole save(JobRole jobRole);
}
