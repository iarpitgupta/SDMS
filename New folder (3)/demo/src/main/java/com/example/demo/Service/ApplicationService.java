package com.example.demo.Service;

import com.example.demo.Entity.APAffiliation;
import com.example.demo.Entity.Application;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ApplicationRepository;
import com.example.demo.Repository.ManageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    ManageRespository manageRespository;

    @Autowired
    ApplicationRepository applicationRepository;

    public Application ApplicationService(String status)
    {
        Application applications= manageRespository.findByApplicationStatus(status);
        System.out.println(applications.getApplicationStatus());
        if(applications != null)
            return  applications;
        else
            return  null;
    }

    public void applicationSave(Application application){
        applicationRepository.save(application);
    }


    public List<Application> getApplicationId(User userId){
        return applicationRepository.findByUserId(userId);
    }
}
