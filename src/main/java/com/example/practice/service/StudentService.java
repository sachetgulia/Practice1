package com.example.practice.service;

import com.example.practice.dto.Student;
import com.example.practice.entity.StudentMongo;
import com.example.practice.entity.StudentPostgresql;

import java.util.List;
public interface StudentService {
    Student getStudent(Long id);
    Student getStudent(Long id, String name);

    void addStudent(Student student,String type);
    void update(Student student,String type);
    void delete(Student student,String type);

    List<Student> getAllStudents();

//    StudentPostgresql getStudentSql(Long id);
}

