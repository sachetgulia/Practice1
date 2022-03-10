package com.example.practice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Entity
@Table(name = "studentPostgres")
public class StudentPostgresql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Student cant be empty")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public StudentPostgresql(){}

    public StudentPostgresql(Long id, @NotBlank(message = "Student cant be empty") String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Optional<StudentPostgresql> findById(Long id) {
//
//    }
//
//    public Iterable<StudentPostgresql> findAll() {

//    }
}