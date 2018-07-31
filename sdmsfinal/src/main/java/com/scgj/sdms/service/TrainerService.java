package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.TrainerRepository;
import com.scgj.sdms.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;
    public Trainer findByTrainerId(Long trainerId)
    {
        Trainer trainer=trainerRepository.findByTrainerId(trainerId);
        return trainer;
    }
    public Trainer save(Trainer trainer)
    {
        return trainerRepository.save(trainer);
    }
}
