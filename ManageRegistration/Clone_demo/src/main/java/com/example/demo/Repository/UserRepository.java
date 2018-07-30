package com.example.demo.Repository;

import com.example.demo.Entity.User;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer>
{
    List<User> findAll();
}
