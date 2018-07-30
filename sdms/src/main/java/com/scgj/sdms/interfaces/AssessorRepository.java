package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.AssessmentAgency;
import com.scgj.sdms.model.Assessor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssessorRepository extends CrudRepository<Assessor,Integer> {
    public Assessor findByAssesorId(int assessorId);
    public Assessor save(Assessor assessor);
    List<Assessor> findAll();
}