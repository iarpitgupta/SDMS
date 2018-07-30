package com.scgj.sdms.controller;

import com.scgj.sdms.model.*;
import com.scgj.sdms.service.ManageService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class ManageController {
    @Autowired
    ManageService manageService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/get-started")
    public ModelAndView show() {
        ModelAndView m =new ModelAndView("ManageRegistration");

        List<User> users=manageService.userList();
        List<TrainingPartner> trainingPartners=manageService.trainingPartnerList();
        List<AssessmentAgency> assessmentAgencies=manageService.assessmentAgencyList();

        List<Application> submittedApplicationList=manageService.submittedApplicationList();
        List<SubmittedForms> submittedFormsList=manageService.submittedFormsList(submittedApplicationList,users,trainingPartners,assessmentAgencies);
        //Map<Integer,String> list=myService.myServiceList(applications,users);
        m.addObject("abc", submittedFormsList);
        System.out.println("chal ja"+submittedFormsList);

        List<Application> approvedApplicationList=manageService.approvedApplicationList();
        List<SubmittedForms> approvedFormsList=manageService.submittedFormsList(approvedApplicationList,users,trainingPartners,assessmentAgencies);
        m.addObject("approvedDetails",approvedFormsList);

        List<Application> rejectedApplicationList=manageService.rejectedApplicationList();
        List<SubmittedForms> rejectedFormList=manageService.submittedFormsList(rejectedApplicationList,users,trainingPartners,assessmentAgencies);
        m.addObject("rejectedDetails",rejectedFormList);

        List<Application> incompleteApplicationList=manageService.incompleteApplicationList();
        List<SubmittedForms> incompleteFormsList=manageService.submittedFormsList(approvedApplicationList,users,trainingPartners,assessmentAgencies);
        m.addObject("incompleteDetails",incompleteFormsList);

        return m;
    }
    @RequestMapping("/getApprove/{id}/{comment}")
    public ModelAndView updateForApproved(@PathVariable int id,@PathVariable String comment)
    {
        System.out.println("Ajax working: "+id);
        System.out.println("Comment is :"+comment);
        String query="UPDATE Application SET application_status='approved',application_comment=? WHERE application_id=?";
        try
        {
            PreparedStatement preparedStatement=jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            preparedStatement.setString(1,comment);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return new ModelAndView("ManageRegistration");
    }
    @RequestMapping("/getReject/{appId}/{comment}")
    public ModelAndView updateForRejected(@PathVariable int appId,@PathVariable String comment)
    {
        System.out.println("Ajax working: "+appId);
        System.out.println("Comment is:"+comment);
        String query="UPDATE Application SET application_status='rejected',application_comment=? WHERE application_id=?";
        try
        {
            PreparedStatement preparedStatement=jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            preparedStatement.setString(1,comment);
            preparedStatement.setInt(2,appId);
            preparedStatement.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return new ModelAndView("ManageRegistration");
    }
    @RequestMapping("/getIncomplete/{appId}/{comment}")
    public ModelAndView updateForIncomplete(@PathVariable int appId,@PathVariable String comment)
    {
        System.out.println("Ajax working: "+appId);
        System.out.println("Comment is:"+comment );
        String query="UPDATE Application SET application_status='incomplete',application_comment=? WHERE application_id=?";
        try
        {
            PreparedStatement preparedStatement=jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            preparedStatement.setString(1,comment);
            preparedStatement.setInt(2,appId);
            preparedStatement.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return new ModelAndView("ManageRegistration");
    }
}
