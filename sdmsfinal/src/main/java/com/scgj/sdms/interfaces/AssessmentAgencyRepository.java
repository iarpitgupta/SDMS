package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.AssessmentAgency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentAgencyRepository extends CrudRepository<AssessmentAgency,Integer> {
    public AssessmentAgency findByAgencyId(int agencyId);
    public AssessmentAgency save(AssessmentAgency assessmentAgency);
    List<AssessmentAgency>findAll();
}
