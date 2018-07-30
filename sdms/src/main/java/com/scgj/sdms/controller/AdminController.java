package com.scgj.sdms.controller;

import com.scgj.sdms.interfaces.IAppContsants;
import com.scgj.sdms.model.ImportHistory;
import com.scgj.sdms.model.QueryControllerModel;
import com.scgj.sdms.model.User;
import com.scgj.sdms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ImportHistoryService importHistoryService;
    @Autowired
    private UserService userService;
    @Autowired
    TrainingPartnerService trainingPartnerService;
    @Autowired
    CentreService centreService;
    @Autowired
    CandidateService candidateService;

    @RequestMapping("/import-data")
    public ModelAndView importData(HttpSession session)
    {
        String sessionRole = session.getAttribute ("loggedInUserRole") != null ? session.getAttribute ("loggedInUserRole").toString () : null;
        if (sessionRole == null) {
            ModelAndView mv = new ModelAndView ("index");
            return mv;
        }
        ModelAndView modelAndView=new ModelAndView("importdata");
        List<ImportHistory>list=importHistoryService.findAll();
        modelAndView.addObject ("historydata",list);
        modelAndView.addObject("uploadpath",IAppContsants.UPLOADFOLDER);
        return modelAndView;
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView homePage(@ModelAttribute("user")User user, HttpSession session) {
        // String session1 = session.getAttribute ("loggedInUser") != null ? session.getAttribute ("loggedInUser").toString () : null;
        String sessionRole = session.getAttribute ("loggedInUserRole") != null ? session.getAttribute ("loggedInUserRole").toString () : null;
        if (sessionRole == null) {
            ModelAndView mv = new ModelAndView ("index");
            mv.addObject ("user", new User ());
            return mv;
        } else
        {
            ModelAndView ma = new ModelAndView ("newDashboard");

        int NoOfTrainingPartner = trainingPartnerService.getTrainingPartnerCount();
        int NoOfTrainingCentre = centreService.getTraingCentreService ();
        int NoOfCertfiedCandidate = candidateService.getCertifiedCandidateService ();
        int NoOfCandidateEnrolled = candidateService.getEnrolledCandidateService ();
        // int NoOfCandidateAssessed = candidateService.getAssesedCandidateService ();
        List<QueryControllerModel> tp = trainingPartnerService.gettopTrainingPartner ();

        ma.addObject ("NoOfTrainingPartner",NoOfTrainingPartner);
        ma.addObject ("NoOfTrainingCentre",NoOfTrainingCentre);
        ma.addObject ("NoOfCertfiedCandidate",NoOfCertfiedCandidate);
        ma.addObject ("NoOfCandidateEnrolled",NoOfCandidateEnrolled);
        //ma.addObject ("NoOfCandidateAssessed",NoOfCandidateAssessed);
        ma.addObject ("tp",tp);
            return ma;
    }

}}
