package com.example.sdms.Service;

import com.example.sdms.Entity.User;
import com.example.sdms.Repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;

    public void insert(User user)

    {
        signUpRepository.save(user);
    }

    public int countByUserName(String uName) {
        return signUpRepository.countByUserName(uName);
    }
}
