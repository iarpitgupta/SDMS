package com.tp.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagementPeopleService {
    @Autowired
    ManagementPeopleRepository managementPeopleRepository;

    public void insert(ManagementPeople managementPeople)
    {
        managementPeopleRepository.save(managementPeople);
    }
    public void delete(Integer id)
    {
        managementPeopleRepository.deleteById(id);
    }
    public ManagementPeople findByEmailId(String email)
    {
        return managementPeopleRepository.findByEmailId(email);
    }
}
