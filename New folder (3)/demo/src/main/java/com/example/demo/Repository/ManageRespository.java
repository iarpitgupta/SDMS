package com.example.demo.Repository;

import com.example.demo.Entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ManageRespository extends CrudRepository<Application, Integer> {

Application findByApplicationId(int id);
Application findByApplicationStatus(String status);
//Application findApplicationByApplicationStatus();

}
