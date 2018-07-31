//package com.scgj.sdms.controller;
//
//
//import com.fasterxml.jackson.databind.node.BigIntegerNode;
//import com.scgj.sdms.model.*;
//import com.scgj.sdms.service.TrainingPartnerService;
//import com.scgj.sdms.service.UserService;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//public class TpHomeController {
//    @Autowired
//    private TrainingPartnerService tp_homeService;
//    @Autowired
//    UserService userService;
//    int aid;
//    String username;
//    String status;
//    Date date;
//    String comments;
//    int bid;
//    int tid;
//    Date assDate;
//    int strength;
//    @RequestMapping(value = "TP_HomePage", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView TPHomepage(HttpSession session)
//    {
//        long userid=0;
//        String userName= (String) session.getAttribute("loggedInUser");
//        User curUser=userService.findByUserName(userName);
//        if(curUser!=null)
//            userid=curUser.getUserId();
//        System.out.println("user id is " + userid);
//        User response = new User();
//        response.setUserId(userid);
//        List<Application> list = tp_homeService.findAllId();
//        List<Batch> list1 = tp_homeService.findAllBid();
//        List<Trainer> list2 = tp_homeService.findAllTrainer();
//        List<TrainingPartner> list3 = tp_homeService.findAllTrainingPartner();
//        ArrayList<RClass> approvedList = new ArrayList<>();
//        //ArrayList<anotherclass> al2 = new ArrayList<anotherclass>();
//        RClass rclass = new RClass();
//
//        List<User> listuser = tp_homeService.findAllUser();
//        for (Application a : list)
//        {
//            long curUserId=0;
//            User curUser1=a.getUserId();
//            if(curUser1!=null)
//            {
//                curUserId=curUser.getUserId();
//            }
//            if ((curUserId==userid) && curUser.getUserRole().equals("tp") ) {
//               // if(a.getUserId().equals("tp")){
//                //System.out.println(" me do bar chalunga");
//                long uid=userid;
//                rclass.setApplication_id(a.getApplicationId());
//                rclass.setStatus(a.getApplicationStatus());
//                rclass.setDate(a.getDateOfSubmission());
//                rclass.setComments(a.getGetApplicationComment());
//                rclass.setUsername(listuser.stream().filter(user -> user.getUserId() == a.getUserId().getUserId()).findFirst().orElse(new User()).getUserName());
//                approvedList.add(rclass);
//
//        }
//        }
//
//        approvedList.add(rclass);
//
//
//        Date d=new java.sql.Date(System.currentTimeMillis());
//
//        //List<Batch> approvedBatch = list1.stream().filter(batch -> batch.getTrainingPartnerId().getApplicationId().getUserId().getUserId()==(uid)
//               //
//        // && batch.getTrainingPartnerId().getApplicationId().getApplicationStatus().equals("approved")).collect(Collectors.toList());
//        List<Batch>approvedBatch;
//        for(Batch b:list1)
//        {
//            String curTpId=null;
//            TrainingPartner curTp=b.getTrainingPartnerId();
//            if(curTp!=null)
//                curTpId=curTp.getTrainingPartnerId();
//
//        }
//        List<Batch> filter1=approvedBatch.stream().filter(l->(l.getBatchEndDate().before(d)&&l.getBatchStartDate().before(d))).collect(Collectors.toList());
//
//        for (Batch batch : filter1) {
//            rclass.setBatchid(batch.getBatchId());
//            rclass.setAssessDate(batch.getAssessmentDate());
//            for (TrainingPartner trainingPartner : list3) {
//                if (batch.getTrainingPartnerId().getTrainingPartnerId() == trainingPartner.getTrainingPartnerId()) {
//                    rclass.setTpname(trainingPartner.getTrainingPartnerName());
//                }
//            }
//            rclass.setBatchstrength(batch.getTotalCandidatesInBatch());
//        }
//        System.out.println("me do bar chalunga2222222222222");
//
//        approvedList.add(rclass);
//
//
//ModelAndView modelAndView= new ModelAndView("TP_HomePage");
//        System.out.println("nishtha :"+approvedList);
//        modelAndView.addObject("shivangi",approvedList);
//        return modelAndView;
//    }
//
//}
