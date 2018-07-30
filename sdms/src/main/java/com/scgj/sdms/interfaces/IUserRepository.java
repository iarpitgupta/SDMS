package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

@Repository
public interface IUserRepository extends CrudRepository<User,Long> {

    //@Query("select user from user_info user where user_name=:name and user_password=:upass")
    User findByUserNameAndUserPassword(@Param("name") String userName,@Param("upass") String userPassword);
    User findByUserName(String userName);
    User save(User user);
    List<User> findAll();
    User findByUserId(Long userId);

    User findByUserRole(String name);
}
