package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainerRepository extends CrudRepository<Trainer,Long> {
    Trainer findByTrainerId(long trainerId);
    Trainer save(Trainer trainer);
    List<Trainer> findAll();
}
