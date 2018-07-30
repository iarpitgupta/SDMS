package com.Services;

import com.Repository.ICentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCentreService {

    @Autowired
    ICentreRepository iCentreRepository;

    public  int getTraingCentreService()
    {
        return iCentreRepository.getTrainingCentre ();
    }
}
