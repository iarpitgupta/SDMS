package com.scgj.sdms.controller;

import com.scgj.sdms.model.*;
import com.scgj.sdms.service.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AssessorController {
    @Autowired
    AssessorService assessorService;



    @RequestMapping(value = "AB_HomePage", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView ABHomepage(@RequestParam int userid){
        System.out.println("user id is " + userid);
        User response = new User();
        response.setUserId(userid);
        List<Application> list = assessorService.findAllId();
        List<Batch> list1 = assessorService.findAllBid();
        List<AssessmentAgency> list3 = assessorService.assessorAgency1();
        List<Assessor> list2 = assessorService.assessorService1();
        ArrayList<AssessorAttributes> al = new ArrayList<>();
        AssessorAttributes assessorAttributes =new AssessorAttributes();
        List<User> listuser = assessorService.findAllUser();
        for (Application a : list) {
            // AssessorAttributes assessorAttributes=new AssessorAttributes();
            if (a.getUserId().getUserId()==(userid)&& a.getUserId().getUserRole().equals("ab")) {
                assessorAttributes.setAid(a.getApplicationId());
                assessorAttributes.setStatus(a.getApplicationStatus());
                assessorAttributes.setDate(a.getDateOfSubmission());
                assessorAttributes.setComments(a.getGetApplicationComment());
                assessorAttributes.setUsername(listuser.stream().filter(user -> user.getUserId() == a.getUserId().getUserId()).findFirst().orElse(new User()).getUserName());
                al.add(assessorAttributes);
            }
        }
        Date d=new java.sql.Date(System.currentTimeMillis());

        List<Batch> approvedBatch = list1.stream().filter(batch -> batch.getAgencyId().getApplicationId().getUserId().getUserId()==(userid)
                && batch.getAgencyId().getApplicationId().getApplicationStatus().equals("approved")).collect(Collectors.toList());
        List<Batch> filter1=approvedBatch.stream().filter(l->(l.getBatchEndDate().before(d)&&l.getBatchStartDate().before(d))).collect(Collectors.toList());

        for (Batch batch : filter1)
        {

            // AssessorAttributes assessorAttributes=new AssessorAttributes();
            assessorAttributes.setBid(batch.getBatchId());
            //System.out.println("nishtha:"+batch.getBatchId());
            assessorAttributes.setAssessDate(batch.getAssessmentDate());
            for (AssessmentAgency assessmentAgency: list3) {
                if (batch.getAgencyId().getAgencyId() == assessmentAgency.getAgencyId()) {
                    assessorAttributes.setTpname(assessmentAgency.getAgencyName());
                }
            }
            assessorAttributes.setStrength(batch.getTotalCandidatesInBatch());
            assessorAttributes.setDistrict(batch.getCentreId().getLocationId().getDistrict());

            al.add(assessorAttributes);
        }
        ModelAndView modelAndView= new ModelAndView("AB_HomePage");
        modelAndView.addObject("shivangi",al);
        return modelAndView;
    }




}
