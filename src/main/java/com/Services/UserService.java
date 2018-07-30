package com.Services;

import com.Repository.IUserRepository;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository iUserRepository;


//    public boolean ServicefindByName(String name, String password) {
//        User user =new User ();
//         user= iUserRepository.findByUserNameAndUserPassword(name,password);
//        //System.out.println (user);
//         if(user!= null)
//         return true;
//         else
//             return false;
//    }

    public User RoleService(String name, String password) {
        return iUserRepository.findByUserNameAndUserPassword(name,password);
        }


    public void addRecord(User user) {
        System.out.println ( "servicce meh agya");
            iUserRepository.save (user);
          }

          public User findBy(String name){
        return iUserRepository.findByUserRole (name);
          }
}