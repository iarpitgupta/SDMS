package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Centre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends CrudRepository<Centre,Long> {
    public Centre findByCentreId(long centreId);
    public Centre save(Centre centre);

    @Query(value = "select count(Centre_id) from Centre",nativeQuery =true )
    int getTrainingCentre();
}