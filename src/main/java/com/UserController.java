package com;

import com.Services.*;
import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public  TrainingPartnerService trainingPartnerService;

    @Autowired
    public TrainingCentreService trainingCentreService;

    @Autowired
    public CandidateService candidateService;



    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView homePage(HttpSession session) {
        String sessionRole = session.getAttribute ("loggedInUserRole") != null ? session.getAttribute ("loggedInUserRole").toString () : null;
        ModelAndView mv = null;
        if (sessionRole == null) {
            mv = new ModelAndView ("indexFinal");
            mv.addObject ("user", new User ());
            return mv;
        } else{
            User user = userService.findBy (sessionRole);

            if (user.getUserRole ().equals ("admin")) {
            return new ModelAndView ("redirect:/Dashboard");
            }else if(user.getUserRole ().equals ("AssessmentBody")){
                return new ModelAndView ("redirect:/AssessmentBody");
            }else if(user.getUserRole ().equals ("TrainingPartner")){
                return new ModelAndView ("redirect:/TrainingPartner");
            }

        }
        return mv;
    }


//    @RequestMapping(value = "/nishtha" , method = RequestMethod.POST)
//    public ModelAndView loginModule(@ModelAttribute("user") User user)
//    {
//        System.out.println (user.getuName ()+ user.getuPassword ());
//        ModelAndView mv = new ModelAndView ("BatchAssignment");
//        boolean result= userService.ServicefindByName(user.getuName (),user.getuPassword ());
//         if(result==true){
//              return mv ;
//         }else{
//             System.out.println ("tumhra kat gya");
//             }
//        return new ModelAndView ();
//    }

    @RequestMapping(value = "/logged-in" , method = RequestMethod.POST)
    public ModelAndView RedirectionsModule(@ModelAttribute("user") User user, HttpSession session)
    {
        ModelAndView mv = new ModelAndView ("BatchAssignment");

        ModelAndView mb = new ModelAndView ("Assesment_Body_Page");

        ModelAndView ma = new ModelAndView ("newDashboard(1)");

        int NoOfTrainingPartner = trainingPartnerService.getTrainingPartners ();
        int NoOfTrainingCentre = trainingCentreService.getTraingCentreService ();
        int NoOfCertfiedCandidate = candidateService.getCertifiedCandidateService ();
        int NoOfCandidateEnrolled = candidateService.getEnrolledCandidateService ();
        int NoOfCandidateAssessed = candidateService.getAssesedCandidateService ();
        List<QueryControllerModel> tp = trainingPartnerService.gettopTrainingPartner ();

        ma.addObject ("NoOfTrainingPartner",NoOfTrainingPartner);
        ma.addObject ("NoOfTrainingCentre",NoOfTrainingCentre);
        ma.addObject ("NoOfCertfiedCandidate",NoOfCertfiedCandidate);
        ma.addObject ("NoOfCandidateEnrolled",NoOfCandidateEnrolled);
        ma.addObject ("NoOfCandidateAssessed",NoOfCandidateAssessed);
        ma.addObject ("tp",tp);

        User result= userService.RoleService (user.getUserName (),user.getUserPassword ());
        session.setAttribute ("loggedInUserRole",result.getUserRole());

        if(result.getUserRole().equals ("AssessmentBody")){
            return new ModelAndView ("redirect:/AssessmentBody") ;
            }else if(result.getUserRole().equals ("TrainingPartner")){
            return new ModelAndView ("redirect:/TrainingPartner") ;
        }else if(result.getUserRole().equals ("admin")) {
            return new ModelAndView ("redirect:/Dashboard") ;
        }
        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session)
    {
        session.removeAttribute ("loggedInUser");
        session.invalidate();
        return new ModelAndView ("redirect:/index");
    }

//    @RequestMapping("/FAQ")
//    public ModelAndView faq(@ModelAttribute("searchOptions") SearchOptions searchOptions)
//    {
//       // List<Integer> NoOfCandidates = candidateService.getNoOfCandidates ();
//        int EnrolledCandidates = candidateService.getEnrolledCandidateService ();
//        ModelAndView mv = new ModelAndView ("FAQ");
//       // mv.addObject ("Faq",NoOfCandidates);
//        mv.addObject ("getTotalCandidateEnrolled",EnrolledCandidates);
//        return mv;
//    }

//    @RequestMapping(value = "/search}", method = RequestMethod.GET)
//    public ModelAndView save(@ModelAttribute("searchOptions") SearchOptions searchOptions, Model model) {
//        // select menu can then be accessed in the searchOptions form object
//        String option = searchOptions.getOption();
//        if(option=="Enrolled")
//        {
//            int EnrolledCandidates = candidateService.getEnrolledCandidateService ();
//            ModelAndView mv = new ModelAndView ("FAQ");
//            mv.addObject ("getTotalCandidateEnrolled",EnrolledCandidates);
//            return mv;
//        }
//        else{
//            return new ModelAndView ();
//        }
//    }

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
            return new ModelAndView ("indexFinal");
        }
        else{
            return new ModelAndView ("hello");
        }
    }
//        if (signUpService.countUser (user.getUserName())==0) {
//            signUpService.insert(user);
//            return new ModelAndView("hello");
//        } else
//            return new ModelAndView("signUp").addObject("error","Username Already Exists");
//    }


}
