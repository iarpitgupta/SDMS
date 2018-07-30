package com.scgj.sdms.service;

import com.scgj.sdms.interfaces.IEmployerRepository;
import com.scgj.sdms.model.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    @Autowired
    IEmployerRepository iEmployerRepository;
    public Employer findByEmployerId(long employerId)
    {
        return iEmployerRepository.findByEmployerId(employerId);
    }
    public  Employer save(Employer employer)
    {
        return iEmployerRepository.save(employer);
    }
}
