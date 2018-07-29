package com.example.demo.Repository;

import com.example.demo.Entity.Application;
import com.example.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    public List<Application> findByUserId(User userId);
}
