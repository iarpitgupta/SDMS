package com.Repository;

import com.model.Centre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICentreRepository extends CrudRepository<Centre,Integer> {

    @Query(value = "select count(Centre_id) from Centre",nativeQuery =true )
    int getTrainingCentre();

}
