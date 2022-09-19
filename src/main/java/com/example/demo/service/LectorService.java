package com.example.demo.service;

import com.example.demo.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {
    @Autowired
    private LectorRepository lectorRepository;

    public List<String> findByPartName(String name) {
        return lectorRepository.findByPartName(name);
    }
}
