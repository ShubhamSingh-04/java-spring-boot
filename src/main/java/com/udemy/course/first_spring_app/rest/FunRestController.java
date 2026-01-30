package com.udemy.course.first_spring_app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {

    @Value("${coder.name}")
    private String name;

    @Value("${coder.email}")
    private String email;


    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World4121!!";
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "hi";
    }

//    Fetching custom properties
    @GetMapping("/coder-info")
    public String getCoderInfo(){
        return "Name:" + name + ", email: " + email;
    }
}
