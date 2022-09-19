package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity(name="Lector")
@Table(name="lector")
@Data
@NoArgsConstructor
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="degree_id", nullable = false)
    private Degree degree;

    @OneToMany(mappedBy = "lector")
    @JsonIgnore
    private List<LectorDepartment> departments;
}
