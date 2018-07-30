package com.scgj.sdms.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.scgj.sdms.interfaces.AssessmentAgencyRepository;
import com.scgj.sdms.model.AssessmentAgency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentAgencyService {
    @Autowired
    AssessmentAgencyRepository assessmentAgencyRepository;
    public AssessmentAgency findByAgencyId(int agencyId)
    {
        return assessmentAgencyRepository.findByAgencyId(agencyId);
    }
    public AssessmentAgency save(AssessmentAgency assessmentAgency)
    {
        System.out.println("reached here to save");
        return assessmentAgencyRepository.save(assessmentAgency);
    }
}
