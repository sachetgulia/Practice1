package com.example.practice.Controller;

import com.example.practice.dto.Student;
import com.example.practice.entity.StudentEntity;
import com.example.practice.entity.StudentMongo;
import com.example.practice.entity.StudentPostgresql;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {


    //The @Autowired annotation is used to automatically inject dependencies of the specified type into the current bean
    @Autowired
    StudentService Stservice;

    //get by id
    @GetMapping(value = "/studentGetId", produces = "application/json")
    public Student getStudent(@RequestParam Long id){
        return Stservice.getStudent(id);
    }

    //get by id and name
    @GetMapping(value = "/studentGetIdName", produces = "application/json")
    public Student getStudent(@RequestParam Long id, @RequestParam String name){
        return Stservice.getStudent(id, name);
    }

    //get all
    @GetMapping(value = "/studentGetAll", produces = "application/json")
    public List<Student> getAllStudent(){
        return Stservice.getAllStudents();
    }


    //post method
    @PostMapping(value = "/studentPost", consumes = "application/json")
    public void addStudent(@RequestBody @Valid Student student,@RequestParam @Valid String type){
        Stservice.addStudent(student,type);
    }

    //put method
    @PutMapping(value = "/studentPut", consumes = "application/json")
    public void putStudent(@RequestBody @Valid Student student,@RequestParam @Valid String type){
        Stservice.update(student,type);
    }

    @DeleteMapping(value = "/studentDelete", consumes = "application/json")
    public void deleteStudent(@RequestBody @Valid Student student,@RequestParam @Valid String type){
        Stservice.delete(student,type);}




}



