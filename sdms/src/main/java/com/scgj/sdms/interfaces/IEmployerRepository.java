package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployerRepository extends CrudRepository<Employer,Long> {
    public Employer findByEmployerId(long employerId);
    public Employer save(Employer employer);
}
