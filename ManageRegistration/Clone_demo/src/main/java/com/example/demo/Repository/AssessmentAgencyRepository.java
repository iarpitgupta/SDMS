package com.example.demo.Repository;

import com.example.demo.Entity.AssessmentAgency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssessmentAgencyRepository extends CrudRepository<AssessmentAgency,Integer>
{
    List<AssessmentAgency> findAll();
}
