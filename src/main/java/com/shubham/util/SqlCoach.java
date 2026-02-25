package com.shubham.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SqlCoach implements Coach{
    @Override
    public String getInstruction(){
        return "Practice MySQL queries atleast 2 hours a day";
    }
}
