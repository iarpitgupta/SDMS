package com.Services;

import com.Repository.IQueryControlModelRepository;
import com.Repository.ITrainingPartnerRepository;
import com.model.QueryControllerModel;
import com.model.TrainingPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingPartnerService {
    @Autowired
    ITrainingPartnerRepository iTraining_partner_repository;

    @Autowired
    IQueryControlModelRepository iQueryControlModelRepository;

    public  int getTrainingPartners()
    {
        return iTraining_partner_repository.getTrainingPartner ();
    }

    public List<QueryControllerModel> gettopTrainingPartner(){
        System.out.print (new QueryControllerModel ().getParams ());
        return iQueryControlModelRepository.findAll ();}




}


