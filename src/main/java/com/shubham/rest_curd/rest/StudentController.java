package com.shubham.rest_curd.rest;

import com.shubham.rest_curd.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<Student>();

        theStudents.add(new Student("Singh", "Shubham"));
        theStudents.add(new Student("S", "Harshita"));
        theStudents.add(new Student("P", "Deepak"));

        return theStudents;
    }
}
