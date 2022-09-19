package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "department_lector")
@IdClass(LectorDepartmentId.class)
public class LectorDepartment {
    @Id
    @ManyToOne
    @JoinColumn(name = "lector_id", referencedColumnName = "id")
    private Lector lector;

    @Id
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @Column(name = "salary")
    private int salary;
}
