package com.shubham.jpa_hibernate.dao;

import com.shubham.jpa_hibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFname(String fName);

    void update(Student student);

    int updateEmailNull();
}
