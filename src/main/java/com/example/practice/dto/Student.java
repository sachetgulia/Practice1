package com.example.practice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
    @NotNull
    private Long id;
    @NotBlank
    private String f_name;
    private String l_name;
    private String branch;

    public Student(Long id, String fname, String lname, String branch){
        this.id=id;
        this.f_name=fname;
        this.l_name=lname;
        this.branch=branch;
    }

    public Student(Long id, String name) {
        this.f_name=name;
        this.id=id;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


//    public String getName() {
//        this.f_name=null;
//    }
}
