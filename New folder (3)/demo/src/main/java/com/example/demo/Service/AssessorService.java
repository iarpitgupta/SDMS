package com.example.demo.Service;

import com.example.demo.Entity.Assessor;
import com.example.demo.Repository.AssessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessorService {

    @Autowired
    AssessorRepository assessorRepository;

    public void saveAssessorForm(Assessor assessor){

        assessorRepository.save(assessor);
    }
}
