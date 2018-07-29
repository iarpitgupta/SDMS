package com.example.demo.Repository;

import com.example.demo.Entity.AssessmentAgency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentAgencyRepository extends CrudRepository<AssessmentAgency,Integer> {
}
