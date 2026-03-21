package com.shubham.jpa_hibernate.dao;

import com.shubham.jpa_hibernate.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
