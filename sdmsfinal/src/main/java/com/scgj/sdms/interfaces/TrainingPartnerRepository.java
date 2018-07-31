package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.TrainingPartner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingPartnerRepository extends CrudRepository<TrainingPartner,String> {
    TrainingPartner findByTrainingPartnerId(String id);

    @Query(value = "select count(Training_partner_id) from training_partner",nativeQuery = true)
    int getTrainingPartnerCount();

    TrainingPartner save(TrainingPartner trainingPartner);

    @Query(value = "select count(Training_partner_id) from Training_partner",nativeQuery =true )
    int getTrainingPartner();
    List<TrainingPartner>findAll();


}
