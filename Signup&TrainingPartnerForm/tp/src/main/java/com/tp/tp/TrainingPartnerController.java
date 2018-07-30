package com.tp.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TrainingPartnerController {
    ArrayList<ManagementPeople> managementPeopleList;
    ArrayList<StaffPeople> staffPeopleList;
    @Autowired
    TrainingPartnerService trainingPartnerService;
    @Autowired
    ManagementPeopleService managementPeopleService;
    @Autowired
    StaffPeopleService staffPeopleService;
    @RequestMapping(value = "/tp",method = RequestMethod.GET)
    public ModelAndView tp()
    {
        ModelAndView modelAndView=new ModelAndView("Training_Partner_Page");
        modelAndView.addObject("trainingPartner",new TrainingPartnerForm());
        return modelAndView;
    }
    @RequestMapping(value = "/tp",method = RequestMethod.POST)
    public ModelAndView postTrainingPartner(@ModelAttribute("trainingPartner") TrainingPartnerForm trainingPartner)
    {
        Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        trainingPartner.setDateOfSubmission(formatter.format(currentDate));
        ModelAndView modelAndView=new ModelAndView("Header");
        trainingPartnerService.input(trainingPartner);
        for(int i=0;i<managementPeopleList.size();i++)
        {
            managementPeopleService.insert(managementPeopleList.get(i));
        }
        for(int i=0;i<staffPeopleList.size();i++)
        {
            staffPeopleService.insert(staffPeopleList.get(i));
        }
        //managementPeopleService.insert(managementPeople);
        return modelAndView;
    }
    @RequestMapping(value = "/add/{name}/{designation}/{contact}/{email}/{educational}/{experience}",method = RequestMethod.GET)
    public ModelAndView add(@PathVariable String name,@PathVariable String designation,@PathVariable String contact,@PathVariable String email,@PathVariable String educational,@PathVariable String experience)
    {
        ModelAndView modelAndView = new ModelAndView("Header");
        ManagementPeople managementPeople=new ManagementPeople();
        managementPeople.setName(name);
        managementPeople.setContactNumber(contact);
        managementPeople.setDesignation(designation);
        managementPeople.setEducationalQualification(educational);
        managementPeople.setEmailId(email);
        managementPeople.setExperience(experience) ;
        managementPeopleList=new ArrayList<>();
        managementPeopleList.add(managementPeople);
        return  modelAndView ;
    }
    @RequestMapping(value = "/remove/{name}/{designation}/{contact}/{email}/{educational}/{experience}",method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable String name,@PathVariable String designation,@PathVariable String contact,@PathVariable String email,@PathVariable String educational,@PathVariable String experience)
    {
        ModelAndView modelAndView = new ModelAndView("Header");
        ManagementPeople managementPeople=new ManagementPeople();
        ManagementPeople managementPeople1=managementPeopleService.findByEmailId(email);
        if(managementPeople1!=null)
        managementPeopleService.delete(managementPeople1.getId());
        return  modelAndView;
    }
    @RequestMapping(value = "/addstaff/{name}/{designation}/{contact}/{email}/{educational}/{experience}/{regularVisiting}",method = RequestMethod.GET)
    public ModelAndView addStaff(@PathVariable String name,@PathVariable String designation,@PathVariable String contact,@PathVariable String email,@PathVariable String educational,@PathVariable String experience,@PathVariable String regularVisiting)
    {
        ModelAndView modelAndView = new ModelAndView("Header");
        StaffPeople staffPeople=new StaffPeople();
        staffPeople.setName(name);
        staffPeople.setContactNumber(contact);
        staffPeople.setDesignation(designation);
        staffPeople.setEducationalQualification(educational);
        staffPeople.setEmailId(email);
        staffPeople.setExperience(experience) ;
        staffPeople.setRegularVisiting(regularVisiting);
        staffPeopleList=new ArrayList<>();
        staffPeopleList.add(staffPeople);
        return  modelAndView ;
    }
    @RequestMapping(value = "/removestaff/{name}/{designation}/{contact}/{email}/{educational}/{experience}",method = RequestMethod.GET)
    public ModelAndView removeStaff(@PathVariable String name,@PathVariable String designation,@PathVariable String contact,@PathVariable String email,@PathVariable String educational,@PathVariable String experience)
    {
        ModelAndView modelAndView = new ModelAndView("Header");
        StaffPeople staffPeople=new StaffPeople();
        StaffPeople staffPeople1=staffPeopleService.findByEmailId(email);
        if(staffPeople1!=null)
            staffPeopleService.delete(staffPeople1.getId());
        return  modelAndView;
    }
}
