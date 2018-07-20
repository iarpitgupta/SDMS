package com.scgj.manage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
public class ApplicationController {
    @RequestMapping("/manage-registration")
    public ModelAndView getManageRegistration()
    {
        ModelAndView modelAndView=new ModelAndView("ManageRegistration");
        System.out.println(new ApplicationService().getApplicationList());
        return modelAndView;
    }
}
