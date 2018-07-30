package com.Services;

import com.Repository.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private ICandidateRepository iCandidateRepository;


   public int getCertifiedCandidateService(){
     return iCandidateRepository.getCertifiedCandidate ();
   }

    public int getEnrolledCandidateService(){
        return iCandidateRepository.getEnrolledCandidate();
    }

    public int getAssesedCandidateService(){
        return iCandidateRepository.getAssessedCandidate ();
    }

//    public List<Integer> getNoOfCandidates() {
//        ArrayList<Integer> list = new ArrayList<> ();
//        String query = "SELECT count(candidate_id) as Enrolled,(select count (candidate_id) from candidate_id where batch_id in (select batch_id from batch) as assessed ,(SELECT count(candidate_id) where certified='yes') as certified from candidate)";
//        try {
//            PreparedStatement statement = jdbcTemplate.getDataSource ().getConnection ().prepareStatement (query);
//            ResultSet rs = statement.executeQuery ();
//
//            while (rs.next ()) {
//                list.add (rs.getInt (1));
//            }
//        } catch (SQLException e1) {
//            e1.printStackTrace ();
//        }
//        return list;
//    }  }

    public int getTotalCandidateEnrolled()
    {
        return iCandidateRepository.getTotalCandidateEnrolled ();
    }}