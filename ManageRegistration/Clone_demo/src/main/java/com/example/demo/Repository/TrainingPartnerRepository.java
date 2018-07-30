package com.example.demo.Repository;

import com.example.demo.Entity.TrainingPartner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainingPartnerRepository extends CrudRepository<TrainingPartner,Integer>
{
        List<TrainingPartner> findAll();
//    List<TrainingPartnerRepository> findAllByApplication_ApplicationId(int application_id);
}
