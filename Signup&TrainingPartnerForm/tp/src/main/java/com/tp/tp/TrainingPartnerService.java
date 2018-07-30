package com.tp.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingPartnerService {
    @Autowired
    TpRepository tpRepository;
    public void input(TrainingPartnerForm trainingPartner)
    {
        tpRepository.save(trainingPartner);
    }
}
