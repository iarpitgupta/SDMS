package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.CentreRepository;
import com.scgj.sdms.model.Centre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentreService {
    @Autowired
    CentreRepository centreRepository;
    public Centre findCentreById(long centreId)
    {
        return centreRepository.findByCentreId(centreId);
    }
    public Centre save(Centre centre)
    {
        return centreRepository.save(centre);
    }

    public  int getTraingCentreService()
    {
        return centreRepository.getTrainingCentre ();
    }

}
