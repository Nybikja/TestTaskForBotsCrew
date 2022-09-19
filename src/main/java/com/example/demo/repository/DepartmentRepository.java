package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = "select distinct l.name from department_lector " +
            "join Lector l on department_lector.lector_id = l.id " +
            "join Department d on department_lector.department_id = d.id " +
            "join Degree de on l.degree_id = de.id " +
            "where de.id = 4 and d.name= :departmentName", nativeQuery = true)
    String findHeadByDepartmentName(@Param("departmentName") String departmentName);

    @Query(value = "select Count(l.id) from department_lector " +
            "join Lector l on department_lector.lector_id = l.id " +
            "join Department d on department_lector.department_id = d.id " +
            "join Degree de on l.degree_id = de.id " +
            "where de.id = :roleId and d.name= :departmentName", nativeQuery = true)
    String countEmployeesByRoleAndDepartment(@Param("departmentName") String departmentName, @Param("roleId") int roleId);

    @Query(value = "select Count(l.id) from department_lector " +
            "join Lector l on department_lector.lector_id = l.id " +
            "join Department d on department_lector.department_id = d.id " +
            "join Degree de on l.degree_id = de.id " +
            "where d.name= :departmentName", nativeQuery = true)
    String countEmployeesByDepartment(@Param("departmentName") String departmentName);


    @Query(value = "select avg(department_lector.salary) from department_lector " +
            "join Lector l on department_lector.lector_id = l.id " +
            "join Department d on department_lector.department_id = d.id " +
            "where d.name= :departmentName", nativeQuery = true)
    int averageSalary(@Param("departmentName") String departentName);
}
