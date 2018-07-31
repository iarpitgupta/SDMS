package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Application;
import com.scgj.sdms.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApplicationRepository extends CrudRepository<Application,Integer> {
    public Application findByApplicationId(int applicationId);
    public Application save(Application application);
    public List<Application> findAll();
    List<Application> findAllByApplicationStatus(String status);
    public List<Application> findByUserId(User userId);
}
