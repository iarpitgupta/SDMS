package com.example.sdms.Repository;

import com.example.sdms.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends CrudRepository<User,Integer> {
   int countByUserName(String uName);
}
