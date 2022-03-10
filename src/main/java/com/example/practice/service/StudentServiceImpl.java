package com.example.practice.service;

import com.example.practice.Config.StudentMongoRepository;
import com.example.practice.dto.Student;
import com.example.practice.entity.StudentEntity;
import com.example.practice.entity.StudentMongo;
import com.example.practice.entity.StudentPostgresql;
import com.example.practice.repository.StudentPostDb;
//import com.example.practice.repository.StudentRedisDb;
import com.example.practice.repository.StudentRepository;
import com.example.practice.repository.Studentdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {



    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Autowired
    StudentPostDb studentPs;

    @Override
    public Student getStudent(Long id) {
        Optional<StudentMongo>optionalUser1=studentMongoRepository.findById(id);
        Optional<StudentPostgresql>optionalUser2=studentPs.findById(id);
            if (optionalUser1.isPresent()){
                return new Student(optionalUser1.get().getId(),optionalUser1.get().getName());
            }
            else if(optionalUser2.isPresent()){
                return new Student(optionalUser2.get().getId(),optionalUser2.get().getName());
            }

        return null;
    }

    @Override
    public List<Student> getAllStudents(){
        Iterable<StudentMongo> studentEntityList = studentMongoRepository.findAll();
        List<Student> studentResponseList = new ArrayList<>();
        for(StudentMongo studentMongo : studentEntityList){
            studentResponseList.add(new Student(studentMongo.getId(),studentMongo.getName()));
        }
        Iterable<StudentPostgresql> studentPostgresqls = studentPs.findAll();
        for(StudentPostgresql studentPostgresql : studentPostgresqls){
            studentResponseList.add(new Student(studentPostgresql.getId(),studentPostgresql.getName()));
        }
        return studentResponseList;
    }


    @Override
    public Student getStudent(Long id, String name) {

        for(StudentMongo st:studentMongoRepository.findAll()){
            if(st.getId()==id&&st.getName().equals(name)){
                return new Student(st.getId(),st.getName());
            }
        }
        for(StudentPostgresql stp:studentPs.findAll()){
            if(stp.getId()==id&&stp.getName().equals(name)){
                return new Student(stp.getId(),stp.getName());
            }
        }

        return null;
    }

    @Override
    public void addStudent(Student student,String type) {
        if(type.equals("mongo")){
            studentMongoRepository.save(new StudentMongo(student.getId(), student.getF_name()));
        }
        else if(type.equals("postgresql")){

            studentPs.save(new StudentPostgresql(student.getId(),student.getF_name()));
        }

    }

    @Override
    public void update(Student student,String type) {
        if(type.equals("mongo")){
            studentMongoRepository.save(new StudentMongo(student.getId(), student.getF_name()));
        }
        else if(type.equals("postgresql")){
            studentPs.save(new StudentPostgresql(student.getId(),student.getF_name()));
        }
        else if(type.equals("redis")){

        }
    }

    @Override
    public void delete(Student student,String type) {
        if(type.equals("mongo")) {
            studentMongoRepository.deleteById(student.getId());
        }
        else if(type.equals("postgres")){
            studentPs.deleteById(student.getId());
        }
        else if(type.equals("redis")){

        }
    }
}

