package com.example.demo.Service;

import com.example.demo.Entity.AssessmentAgency;
import com.example.demo.Repository.AssessmentAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentAgencyService {

    @Autowired
    public AssessmentAgencyRepository assessmentAgencyRepository;

    public List<AssessmentAgency> getAgencies(){
        List<AssessmentAgency> assessmentAgencies = new ArrayList<>();

        assessmentAgencyRepository.findAll().forEach(e->assessmentAgencies.add(e));
        return assessmentAgencies;
    }

    public void assesmentAgencySave(AssessmentAgency assessmentAgency){
        assessmentAgencyRepository.save(assessmentAgency);
    }
}
