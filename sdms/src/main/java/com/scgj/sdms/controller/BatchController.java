package com.scgj.sdms.controller;

import com.scgj.sdms.interfaces.IChartModelRepository;
import com.scgj.sdms.model.ChartDataModel;
import com.scgj.sdms.service.BatchService;
import com.scgj.sdms.service.ChartDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import com.scgj.sdms.model.Candidate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@RestController
public class BatchController {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    BatchService batchService;
    @Autowired
    ChartDataService chartDataService;
    @RequestMapping("/getchartdata")
    public @ResponseBody
    ArrayList<Map<String,Integer>> getChartData(){
        return (ArrayList<Map<String, Integer>>) batchService.getBatchCandidateCount();
    }
}
