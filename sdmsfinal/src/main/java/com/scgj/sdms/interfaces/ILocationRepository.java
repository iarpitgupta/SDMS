package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends CrudRepository<Location,Long> {
    Location findByDistrictAndState(String district,String state);
    Location save(Location location);

    Location findByState(String state);
}
