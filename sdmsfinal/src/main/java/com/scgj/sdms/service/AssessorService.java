package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.*;
import com.scgj.sdms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessorService {
    @Autowired
    AssessorRepository assessorRepository;
    public Assessor findByAssessorId(int assessorId)
    {
        return assessorRepository.findByAssesorId(assessorId);
    }
    public Assessor save(Assessor assessor)
    {
        return  assessorRepository.save(assessor);
    }

    @Autowired
    IApplicationRepository tp_homeAppRepository;
    @Autowired
    IUserRepository tp_homeUserRepository;
    @Autowired
    iBatchRepository iBatchRepository;
    @Autowired
    AssessorRepository assessorRepo;
    @Autowired
    AssessmentAgencyRepository assessorAgencyRepo;


    public List<User> findAllUser(){ return  tp_homeUserRepository.findAll(); }
    public List<Application> findAllId(){ return tp_homeAppRepository.findAll(); }
    public List<Batch> findAllBid()
    {
        return iBatchRepository.findAll();
    }
    public List<Assessor> assessorService1()
    {
        return assessorRepo.findAll();
    }
    public List<AssessmentAgency> assessorAgency1()
    {
        return assessorAgencyRepo.findAll();
    }
}
