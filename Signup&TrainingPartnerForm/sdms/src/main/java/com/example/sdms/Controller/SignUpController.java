package com.example.sdms.Controller;


import com.example.sdms.Entity.User;
import com.example.sdms.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public ModelAndView sign() {
        ModelAndView modelAndView = new ModelAndView("signUp");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public ModelAndView signin(@ModelAttribute("user") User user) {
        if (signUpService.countByUserName(user.getUserName())==0) {
            signUpService.insert(user);
            return new ModelAndView("hello");
        } else
            return new ModelAndView("signUp").addObject("error","Username Already Exists");
    }

}
