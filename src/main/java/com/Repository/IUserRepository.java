package com.Repository;

import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User,Integer> {

    User findByUserNameAndUserPassword(String name, String password);
    User findByUserRole(String name);



}