package com.example.demo.Repository;

import com.example.demo.Entity.Assessor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessorRepository  extends CrudRepository<Assessor,Integer> {
}
