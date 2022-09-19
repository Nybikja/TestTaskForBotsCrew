package com.example.demo.repository;

import com.example.demo.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Integer> {
    @Query(value = "SELECT l.name FROM Lector l WHERE l.name LIKE %:name%")
    List<String> findByPartName(@Param("name") String name);
}
