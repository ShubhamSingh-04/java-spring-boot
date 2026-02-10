package com.shubham.SpringCore;

import org.springframework.stereotype.Component;

@Component
public class SpringCoach implements Coach {
    @Override
    public String getInstruction(){
        return "Initialize a Spring Boot application from Spring Initializer at https://start.spring.io, and enjoy !!";
    }
}
