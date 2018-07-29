package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Controller
public class APFormController {

    @Autowired
    APAffiliationService apAffiliationService;

    @Autowired
    AssessorService assessorService;

    @Autowired
    AssessmentAgencyService assessmentAgencyService;

    @Autowired
    APAffiliationPOJO apAffiliationPOJO;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;



    @RequestMapping(value = "/apform", method = RequestMethod.GET)
    public ModelAndView getForm(){
        ModelAndView form = new ModelAndView("Assesment_Body_Page");
        form.addObject("apAffiliationPOJO",new APAffiliationPOJO());
        return form;
    }

    @RequestMapping(value ="/apform", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute APAffiliationPOJO apAffiliationPOJO ){
        APAffiliation apAffiliation = new APAffiliation();
        Assessor assessor = new Assessor();
        AssessmentAgency assessmentAgency = new AssessmentAgency();
        Application application = new Application();

        User user= userService.getUserId(1);

        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
        application.setApplicationStatus("submitted");
        application.setUserId(user);
        java.sql.Date submissonDate = java.sql.Date.valueOf(LocalDate.now());
        application.setSubmissionDate(submissonDate);
        //save application
        applicationService.applicationSave(application);
        System.out.println(apAffiliationPOJO.getAssesmentAgencyName());
        assessmentAgency.setAgencyName(apAffiliationPOJO.getAssesmentAgencyName());

        List<Application> applicationId=applicationService.getApplicationId(user);
        System.out.println("nishtha"+applicationId);
        //System.out.println(applicationId.getApplicationId());
        for(Application application1:applicationId)
        assessmentAgency.setApplicationId(application1);
        //save assesment agency
        assessmentAgencyService.assesmentAgencySave(assessmentAgency);
        assessor.setAssesorName(apAffiliationPOJO.getAssesorName());
        assessor.setAgencyId(assessmentAgency);
        assessor.setLocation(apAffiliationPOJO.getState());
        assessor.setContactNumber(apAffiliationPOJO.getContactNumber());
        assessor.setDesignation(apAffiliationPOJO.getDesignation());
        assessor.setExperience(apAffiliationPOJO.getExperience());
        assessor.setQualification(apAffiliationPOJO.getQualification());
        assessor.setEmail(apAffiliationPOJO.getEmail());
        //save assesor
        assessorService.saveAssessorForm(assessor);
        ModelAndView form = new ModelAndView("Assesment_Body_Page");
        form.addObject("apAffiliationPOJO",new APAffiliationPOJO());
        return form;
    }


}
