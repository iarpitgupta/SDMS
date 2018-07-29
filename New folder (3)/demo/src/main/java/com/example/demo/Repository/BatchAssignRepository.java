package com.example.demo.Repository;

import com.example.demo.Entity.Batch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatchAssignRepository extends CrudRepository<Batch,Integer> {

}

