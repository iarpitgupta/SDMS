package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.ICandidateRepository;
import com.scgj.sdms.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    ICandidateRepository iCandidateRepository;
    public Candidate findByAadharNo(long aadharNo)
    {
        return iCandidateRepository.findByAadharNo(aadharNo);
    }
    public Candidate save(Candidate candidate)
    {
        return iCandidateRepository.save(candidate);
    }

    public int getCertifiedCandidateService(){
        return iCandidateRepository.getCertifiedCandidate ();
    }

    public int getEnrolledCandidateService(){
        return iCandidateRepository.getEnrolledCandidate();
    }

//    public int getAssesedCandidateService(){
//        return iCandidateRepository.getAssessedCandidate ();
//    }
    public int getTotalCandidateEnrolled()
    {
        return iCandidateRepository.getTotalCandidateEnrolled ();
    }}


