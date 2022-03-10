package com.example.practice.repository;

import com.example.practice.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


// creating a singleton db so that one instance is created across the application

// dependency injecting - the way we are creating one object for across applicatoin we dont do it manually we use something else
// to inject this dependency and spring is all about dependency injection
// inversion of control principle

@Repository
public class Studentdb {
    public static ArrayList<Student> getStudentList(){
        ArrayList<Student>list=new ArrayList<>();
        list.add(new Student(1L,"a","d","CSE"));
        list.add(new Student(2L,"b","e","IT"));
        list.add(new Student(3L,"c","f","ECE"));
        return list;
    }

}
