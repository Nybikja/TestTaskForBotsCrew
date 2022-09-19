package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public String findHeadByDepartmentName(String departmentName) {
        return "Head of department is: " + departmentRepository.findHeadByDepartmentName(departmentName);
    }

    public String countEmployeesByRoleAndDepartment(String departmentName) {
        String assistans = departmentRepository.countEmployeesByRoleAndDepartment(departmentName, 1);
        String associateProfessors = departmentRepository.countEmployeesByRoleAndDepartment(departmentName, 2);
        String professors = departmentRepository.countEmployeesByRoleAndDepartment(departmentName, 3);

        return "Assistants: " + assistans + "\nAssociate Proffesors: " + associateProfessors +
                "\nProfessors: " + professors;
    }

    public String countEmployeesByDepartment(String departmentName) {
        return departmentRepository.countEmployeesByDepartment(departmentName);
    }

    public int averageSalary(String departmentName) {
        return departmentRepository.averageSalary(departmentName);
    }

}
