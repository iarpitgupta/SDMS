package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.IApplicationRepository;
import com.scgj.sdms.model.Application;
import com.scgj.sdms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    IApplicationRepository iApplicationRepository;
    public Application save(Application application)
    {
        return iApplicationRepository.save(application);
    }
    public Application findByApplicationId(int applicationId)
    {
        return iApplicationRepository.findByApplicationId(applicationId);
    }
    public List<Application> findByUserId(User user){
        return iApplicationRepository.findByUserId(user);
    }

}
