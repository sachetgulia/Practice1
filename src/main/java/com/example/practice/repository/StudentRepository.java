package com.example.practice.repository;


import com.example.practice.entity.StudentEntity;
import com.example.practice.entity.StudentMongo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentMongo,Long> {


}
