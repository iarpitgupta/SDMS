package com;

import com.Services.UserService;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/scgj")
public class TrainingPartnerController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/TrainingPartner", method = RequestMethod.GET)
    public ModelAndView homePage(@ModelAttribute("user")User user, HttpSession session) {
        // String session1 = session.getAttribute ("loggedInUser") != null ? session.getAttribute ("loggedInUser").toString () : null;
        String sessionRole = session.getAttribute ("loggedInUserRole") != null ? session.getAttribute ("loggedInUserRole").toString () : null;
        if (sessionRole == null) {
            ModelAndView mv = new ModelAndView ("indexFinal");
            mv.addObject ("user", new User ());
            return mv;
        } else
            return new ModelAndView ("hello");

    }


}


