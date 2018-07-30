package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.ILocationRepository;
import com.scgj.sdms.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    ILocationRepository iLocationRepository;
    public Location findByDistrictAndState(String district,String state)
    {
        return iLocationRepository.findByDistrictAndState(district, state);
    }
    public Location save(Location location)
    {
        return iLocationRepository.save(location);
    }
    public Location findByState(String state)
    {
        return iLocationRepository.findByState(state);
    }
}
