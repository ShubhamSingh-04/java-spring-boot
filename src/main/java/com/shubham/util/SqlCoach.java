package com.shubham.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Lazy
public class SqlCoach implements Coach{
    SqlCoach(){
        System.out.println("This class is now initialized: " + getClass().getSimpleName());
    }
    @Override
    public String getInstruction(){
        return "Practice MySQL queries atleast 2 hours a day";
    }
}
