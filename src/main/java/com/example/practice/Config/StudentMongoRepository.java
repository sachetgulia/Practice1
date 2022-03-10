package com.example.practice.Config;

import com.example.practice.entity.StudentMongo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMongoRepository extends CrudRepository<StudentMongo,Long> {



}
