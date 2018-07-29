package com.example.demo.Service;

import com.example.demo.Entity.APAffiliation;
import com.example.demo.Repository.APAffiliationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APAffiliationService {

    @Autowired
    APAffiliationRepository apAffiliationRepository;

    public  void saveAPForm(APAffiliation apform){

        apAffiliationRepository.save(apform);
    }
}
