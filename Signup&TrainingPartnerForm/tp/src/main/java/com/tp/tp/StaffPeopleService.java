package com.tp.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffPeopleService {
    @Autowired
    StaffPeopleRepository staffPeopleRepository;

    public void insert(StaffPeople staffPeople)
    {
        staffPeopleRepository.save(staffPeople);
    }
    public void delete(Integer id)
    {
        staffPeopleRepository.deleteById(id);
    }
    public StaffPeople findByEmailId(String email)
    {
        return staffPeopleRepository.findByEmailId(email);
    }
}
