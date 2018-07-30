package com.example.demo.Service;

import com.example.demo.Controller.SubmittedForms;
import com.example.demo.Entity.Application;
import com.example.demo.Entity.AssessmentAgency;
import com.example.demo.Entity.TrainingPartner;
import com.example.demo.Entity.User;
import com.example.demo.Repository.AssessmentAgencyRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.ApplicationRepository;
import com.example.demo.Repository.TrainingPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManageService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    UserRepository userRepository;
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
        System.out.println("lalallalalalallala"+list);
        return list;
    }

    public List<User> userList()
    {
        System.out.println("lalalallalalalalla"+ userRepository.findAll());
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
            Date date=application.getSubmissionDate();
            String type=null;
            for (User user : users)
            {
                if ((application.getUser().getUserId())==(user.getUserId()));
                {
                    type = application.getUser().getUserRole();
                    break;
                }
            }
            String organisation_Name=null;
            if(type.equals("tp"))
            {
                for(TrainingPartner trainingPartner:trainingPartners)
                {
                    TrainingPartner trainingPartner1=trainingPartner;
                    if(app_id==(trainingPartner1.getApplication().getApplicationId()))
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
                    AssessmentAgency assessmentAgency1=assessmentAgency;
                    if(app_id==assessmentAgency1.getApplication().getApplicationId())
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
