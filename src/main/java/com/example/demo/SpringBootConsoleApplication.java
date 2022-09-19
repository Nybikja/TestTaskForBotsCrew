package com.example.demo;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.LectorService;
import com.example.demo.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LectorService lectorService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        new View(departmentService, lectorService).show();
    }
}
