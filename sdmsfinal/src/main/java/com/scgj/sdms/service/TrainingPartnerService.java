package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.*;
import com.scgj.sdms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingPartnerService {
    @Autowired
    IApplicationRepository iApplicationRepository;
    @Autowired
    TrainingPartnerRepository trainingPartnerRepository;
    @Autowired
    IQueryControlModelRepository iQueryControlModelRepository;
    @Autowired
    iBatchRepository ibatchRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    ITrainerRepository trainerRepository;
    public TrainingPartner findByTainingPartnerId(String id)
    {
        TrainingPartner trainingPartner=trainingPartnerRepository.findByTrainingPartnerId(id);
        return trainingPartner;
    }
    public TrainingPartner save(TrainingPartner trainingPartner)
    {
        return  trainingPartnerRepository.save(trainingPartner);
    }

    public int getTrainingPartnerCount()
    {
        return trainingPartnerRepository.getTrainingPartnerCount();
    }

    public List<QueryControllerModel> gettopTrainingPartner(){
        System.out.print (new QueryControllerModel ().getParams ());
        return iQueryControlModelRepository.findAll ();}



    public List<User> findAllUser(){
        return  iUserRepository.findAll();
    }
    public List<Application> findAllId(){
        return iApplicationRepository.findAll();
    }
    public List<Batch> findAllBid(){ return ibatchRepository.findAll(); }
    public List<Trainer> findAllTrainer(){ return  trainerRepository.findAll();}
    public List<TrainingPartner> findAllTrainingPartner(){return trainingPartnerRepository.findAll();}


}
