package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.QueryControllerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface IQueryControlModelRepository extends CrudRepository <QueryControllerModel,String>{
    @Query(nativeQuery = true,value ="select * from(select tp.training_partner_id,training_partner_name, count(c.candidate_id) as cnt from training_partner  tp join candidate c join batch b on tp.training_partner_id =b.training_partner_id and c.batch_id=b.batch_id where c.placement_status='placed'  group by tp.training_partner_id order by  cnt desc)tab limit 5")
    List<QueryControllerModel> findAll();
}
