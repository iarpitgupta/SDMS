package com.scgj.sdms.service;

import com.scgj.sdms.model.Batch;
import com.scgj.sdms.model.ChartDataModel;
import org.hibernate.annotations.Subselect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.scgj.sdms.interfaces.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BatchService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private iBatchRepository iBatchRepository;
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;
   public String getData(Batch batch){

        iBatchRepository.save(batch);
        return "success";
    }
    public Batch save(Batch batch)
    {
        return iBatchRepository.save(batch);
    }
    public Batch findByBatchId(String batchId)
    {
        return iBatchRepository.findByBatchId(batchId);
    }

    public ArrayList<Map<String , Integer>> getBatchCandidateCount() {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Map<String,Integer>> list=new ArrayList<>();;
        String query = "select count(candidate_id) as numberOfCandidates,batch_type as batchType from candidate,batch where batch.batch_id = candidate.batch_id group by batch_type";
        try {
            PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(query);
            ResultSet count = statement.executeQuery();
            while (count.next()) {
//                map as JSON
                map.put(count.getString("batchType"), count.getInt("numberOfCandidates"));

                list.add(map);

            }

        } catch (Exception e) {

        }
        return list;
    }

}
