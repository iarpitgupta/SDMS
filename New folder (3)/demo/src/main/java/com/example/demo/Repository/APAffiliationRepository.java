package com.example.demo.Repository;

import com.example.demo.Entity.APAffiliation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APAffiliationRepository extends CrudRepository<APAffiliation,Integer> {
}
