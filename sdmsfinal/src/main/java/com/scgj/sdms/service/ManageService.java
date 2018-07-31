package com.scgj.sdms.service;


import com.scgj.sdms.interfaces.AssessmentAgencyRepository;
import com.scgj.sdms.interfaces.IApplicationRepository;
import com.scgj.sdms.interfaces.IUserRepository;
import com.scgj.sdms.interfaces.TrainingPartnerRepository;

import com.scgj.sdms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManageService {
    @Autowired
    IApplicationRepository applicationRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    TrainingPartnerRepository trainingPartnerRepository;
    @Autowired
    AssessmentAgencyRepository assessmentAgencyRepository;
//    @Autowired
//    MyService myService;

  public List<Application> submittedApplicationList()
  {
      List<Application> list= applicationRepository.findAllByApplicationStatus("submitted");
      System.out.println("lalallalalalallala"+list);
      return list;
  }

  public List<Application> approvedApplicationList()
    {
        List<Application> list=applicationRepository.findAllByApplicationStatus("approved");
        return list;
    }
    public List<Application> rejectedApplicationList()
    {
        List<Application> list= applicationRepository.findAllByApplicationStatus("rejected");
        System.out.println("lalallalalalallala"+list);
        return list;
    }

    public List<Application> incompleteApplicationList()
    {
        List<Application> list= applicationRepository.findAllByApplicationStatus("incomplete");
        return list;
    }

    public List<User> userList()
    {
      return userRepository.findAll();
    }

    public List<TrainingPartner> trainingPartnerList()
    {
        return trainingPartnerRepository.findAll();
    }

    public List<AssessmentAgency> assessmentAgencyList()
    {
        return assessmentAgencyRepository.findAll();
    }

    public List<SubmittedForms> submittedFormsList(List<Application> applications, List<User> users, List<TrainingPartner> trainingPartners, List<AssessmentAgency> assessmentAgencies)
    {
        List<SubmittedForms> submittedFormsList=new ArrayList<>();
        for(Application application:applications)
        {
            int app_id = application.getApplicationId();
            Date date=application.getDateOfSubmission();
            String type=null;
            for (User user : users)
            {
                if ((application.getUserId().getUserId())==(user.getUserId()));
                {
                    type = application.getUserId().getUserRole();
                    break;
                }
            }
            String organisation_Name=null;
            if(type.equals("tp"))
            {
                for(TrainingPartner trainingPartner:trainingPartners)
                {
                    int curApplicationId=0;
                    TrainingPartner trainingPartner1=trainingPartner;
                    Application curApplication=trainingPartner1.getApplicationId();
                    if(curApplication!=null)
                        curApplicationId=curApplication.getApplicationId();
                    if(app_id==curApplicationId)
                    {
                        organisation_Name=trainingPartner1.getTrainingPartnerName();
                        break;
                    }
                }
            }
            else
            {
                for(AssessmentAgency assessmentAgency:assessmentAgencies)
                {
                    int curApplicationId=0;
                    AssessmentAgency assessmentAgency1=assessmentAgency;
                    Application curApplication=assessmentAgency1.getApplicationId();
                    if(curApplication!=null)
                        curApplicationId=curApplication.getApplicationId();
                    if(app_id==assessmentAgency1.getApplicationId().getApplicationId())
                    {
                        organisation_Name=assessmentAgency1.getAgencyName();
                    }
                }
            }
            submittedFormsList.add(new SubmittedForms(app_id,organisation_Name,type,date));
        }
        return submittedFormsList;
    }
//    List<Application> list= manageRespository.findAll();
//
//    List<User> list1=userRepository.findAll();
//
    //List<MyService> list2=myService.myServiceList(list,list1);

}
