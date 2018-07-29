package com.example.demo.Service;

import com.example.demo.Entity.AssessmentAgency;
import com.example.demo.Entity.Batch;
import com.example.demo.Repository.BatchAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchAssignService {

    @Autowired
    public BatchAssignRepository batchAssignRepository;

    public List<Batch> getBatches(){

        List<Batch> batchList = new ArrayList<>();

        batchAssignRepository.findAll().forEach(e->batchList.add(e));
        return batchList;
    }


}
