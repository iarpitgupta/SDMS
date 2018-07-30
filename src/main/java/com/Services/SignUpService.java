package com.Services;

import com.Repository.ISingUpRepository;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    ISingUpRepository iSingUpRepository;

    public void  insert(User user)
    {
        iSingUpRepository.save (user);
    }

    public int countUser(String name)
    {
        return  iSingUpRepository.countByUserName (name);
    }
}
