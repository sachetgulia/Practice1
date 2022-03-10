package com.example.practice.repository;

import com.example.practice.entity.StudentPostgresql;
import org.springframework.data.repository.CrudRepository;

public interface StudentPostDb extends CrudRepository<StudentPostgresql,Long> {

}
