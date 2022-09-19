package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table(name="degree")
@Data
@NoArgsConstructor
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false)
    private String name;

//    public Lector(String name, String description, int price, String imageUrl, ProductType productType,
//                   HairType hairType, ProductLine productLine) {
//        this.name = name;
//
//    }
}
