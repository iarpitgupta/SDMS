package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer,Long> {
    public Trainer findByTrainerId(Long trainingPartnerId);
    Trainer save(Trainer trainer);
}
