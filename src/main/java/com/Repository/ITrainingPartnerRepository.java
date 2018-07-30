package com.Repository;

import com.model.QueryControllerModel;
import com.model.TrainingPartner;
import org.hibernate.annotations.Subselect;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainingPartnerRepository extends CrudRepository<TrainingPartner,Integer> {

    @Query(value = "select count(Training_partner_id) from Training_partner",nativeQuery =true )
    int getTrainingPartner();


  //   public List<QueryControllerModel> getTp(@Param ("status")String status);

}
