package com.scgj.sdms.service;
import com.scgj.sdms.interfaces.IUserRepository;
import com.scgj.sdms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.lang.UsesUnsafeJava;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository iUserRepository;

    public boolean ServicefindByName(String name, String password) {
        User user =new User ();
        user= iUserRepository.findByUserNameAndUserPassword(name,password);
//System.out.println (user);
        if(user!= null)
            return true;
        else
            return false;
    }

    public User RoleService(String name, String password) {
        return iUserRepository.findByUserNameAndUserPassword(name,password);
    }
    public User findByUserName(String userName)
    {
        return iUserRepository.findByUserName(userName);
    }

    public void save(User user) {
        System.out.println ( "servicce meh agya");
        iUserRepository.save (user);
    }
    public User findBy(String name){
        return iUserRepository.findByUserRole (name);
    }


    public User getUserId(long i) {
        return iUserRepository.findByUserId(i);
    }
}


