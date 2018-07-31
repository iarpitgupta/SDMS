package com.scgj.sdms.controller;

import com.scgj.sdms.model.ImportHistory;
import com.scgj.sdms.model.QueryControllerModel;
import com.scgj.sdms.model.User;
import com.scgj.sdms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
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

    @RequestMapping(value = "/www.scgj.sdms.com", method = RequestMethod.GET)
    public ModelAndView homePage(HttpSession session) {
        String sessionRole = session.getAttribute ("loggedInUserRole") != null ? session.getAttribute ("loggedInUserRole").toString () : null;
        ModelAndView mv = null;
        if (sessionRole == null) {
            mv = new ModelAndView ("index");
            mv.addObject ("user", new User ());
            return mv;
        } else{
            User user = userService.findBy (sessionRole);

            if (user.getUserRole ().equals ("admin")) {
                return new ModelAndView ("redirect:/scgj/Dashboard");
            }else if(user.getUserRole ().equals ("AssessmentBody")){
                return new ModelAndView ("redirect:/scgj/AssessmentBody");
            }else if(user.getUserRole ().equals ("TrainingPartner")){
                return new ModelAndView ("redirect:/scgj/TrainingPartner");
            }

        }
        return mv;

//        List<ImportHistory>importHistoryList=importHistoryService.findAll();
//        return new ModelAndView("index");
    }
    @RequestMapping(value = "/logged-in" , method = RequestMethod.POST)
    public ModelAndView RedirectionsModule(@ModelAttribute("user") User user, HttpSession session)
    {
        ModelAndView mv = new ModelAndView ("BatchAssignment");

        ModelAndView mb = new ModelAndView ("Assesment_Body_Page");

        User result= userService.RoleService (user.getUserName (),user.getUserPassword ());
        session.setAttribute("loggedInUser",result.getUserId());
        session.setAttribute ("loggedInUserRole",result.getUserRole());

        if(result.getUserRole().equals ("AssessmentBody")){
            return new ModelAndView ("redirect:/apform") ;
        }else if(result.getUserRole().equals ("TrainingPartner")){
            return new ModelAndView ("redirect:/scgj/TrainingPartner") ;
        }else if(result.getUserRole().equals ("admin")) {
            return new ModelAndView ("redirect:/dashboard") ;
        }
        return mv;
        //return new ModelAndView ("redirect:/Dashboard") ;
        }

    @Autowired
    SignUpService signUpService;
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView sign() {
        ModelAndView modelAndView = new ModelAndView("signUp");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public ModelAndView signin(@ModelAttribute("user") User user) {

        if(user != null)
        {
            signUpService.insert (user);
            return new ModelAndView ("index");
        }
        else{
            return new ModelAndView ("index");
        }
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session)
    {
        session.removeAttribute ("loggedInUser");
        session.invalidate();
        return new ModelAndView ("redirect:/www.scgj.sdms.com");
    }
    }


