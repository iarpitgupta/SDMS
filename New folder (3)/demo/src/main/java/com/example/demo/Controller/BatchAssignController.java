package com.example.demo.Controller;

import com.example.demo.Entity.AssessmentAgency;
import com.example.demo.Entity.Batch;
import com.example.demo.Service.AssessmentAgencyService;
import com.example.demo.Service.AssessorService;
import com.example.demo.Service.BatchAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BatchAssignController {

    @Autowired
    public AssessorService assessorService;

    @Autowired
    public BatchAssignService batchAssignService;

    @Autowired
    public AssessmentAgencyService assessmentAgencyService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/proposed/{id}", method = RequestMethod.GET)
    public ModelAndView proposed(@PathVariable String id){
        int batchId = Integer.parseInt(id);
        System.out.println(batchId);

        String query = "UPDATE batch SET batch_status='notassigned' WHERE batch_id = ?";
        try{
            PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            statement.setInt(1,batchId);
            statement.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }

        ModelAndView modelAndView = new ModelAndView("BatchAssignment");
        return modelAndView;
    }

    @RequestMapping(value = "/assign/{id}/{ab}")
    public  ModelAndView assignAB(@PathVariable String id,@PathVariable String ab){
        int batchId = Integer.parseInt(id);
        System.out.println(batchId);
        System.out.println(ab);
        int abid = Integer.parseInt(ab);
        System.out.println(abid);

        String query = "UPDATE batch SET batch_status='proposed', agency_id=? WHERE batch_id = ?";

        try{
            PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            statement.setInt(1,abid);
            statement.setInt(2,batchId);
            statement.executeUpdate();


        }catch(Exception e){

        }

        ModelAndView modelAndView = new ModelAndView("BatchAssignment");
        return modelAndView;
    }

    @RequestMapping("/searchBatch/{batchId}")
    public ModelAndView search(@PathVariable String batchId){
        ModelAndView modelAndView = new ModelAndView("BatchAssignment");
        List<Batch> list = batchAssignService.getBatches();
        for (Batch i : list){
            if (i.getBatchId() == Integer.parseInt(batchId)) {

                modelAndView.addObject("searchresult",i);
                break;
            }
        }
        return modelAndView;
    }

    @RequestMapping("/batch")
    @ResponseBody
    public ModelAndView batchAssignView(){
        ModelAndView batchView = new ModelAndView("BatchAssignment");
        List<Batch> batchList = batchAssignService.getBatches();
        List<Batch> notAssigned;
        List<Batch> proposed;
        List<Batch> approved;
        List<Batch> rejected;
        List<AssessmentAgency> agencies= assessmentAgencyService.getAgencies();
//        batchList.forEach(x->{
//            if(x.getAssessmentDate()==null)
//                notAssigned.add(x);
//        } );
       notAssigned = batchList.stream().filter(x->x.getBatchStatus().equals("notassigned")).collect(Collectors.toList());
       proposed = batchList.stream().filter(x->x.getBatchStatus().equals("proposed")).collect(Collectors.toList());
       approved = batchList.stream().filter(x->x.getBatchStatus().equals("approved")).collect(Collectors.toList());
       rejected = batchList.stream().filter(x->x.getBatchStatus().equals("rejected")).collect(Collectors.toList());


//        List<String> location = new ArrayList<>();
        batchView.addObject("batch",batchList);
        batchView.addObject("notassigned",notAssigned);
        batchView.addObject("agencies", agencies);
        batchView.addObject("proposed", proposed);
        batchView.addObject("approved", approved);
        batchView.addObject("rejected", rejected);
//        location.forEach(x-> System.out.println(x));
        return batchView;
    }


}
