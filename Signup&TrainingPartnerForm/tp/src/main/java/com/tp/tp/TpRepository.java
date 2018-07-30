package com.tp.tp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TpRepository extends CrudRepository<TrainingPartnerForm,Integer> {
}
