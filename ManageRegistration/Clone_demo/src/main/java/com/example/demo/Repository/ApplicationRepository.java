package com.example.demo.Repository;

import com.example.demo.Entity.Application;
import org.apache.catalina.LifecycleState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Integer> {

//    List<Application> findByApplicationStatus(String status);
    List<Application> findAll();

    List<Application> findAllByApplicationStatus(String status);

//Application findByApplicationStatus(String status);
//Application findApplicationByApplicationStatus();
    //List<Application> findAll();

}
