package com.shubham.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SpringCoach implements Coach {

    SpringCoach(){
        System.out.println("This class is now initialized: " + getClass().getSimpleName());
    }
    @Override
    public String getInstruction(){
        return "Initialize a Spring Boot application from Spring Initializer at https://start.spring.io, and enjoy !!!";
    }
}
