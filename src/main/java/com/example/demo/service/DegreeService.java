package com.example.demo.service;

import com.example.demo.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService {
    @Autowired
    private DegreeRepository degreeRepository;

    public String getHeadOfDepartment(String department) {
//        return degreeRepository.getHeadOfDepartment();
        return null;
    }
}
