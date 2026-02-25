package com.shubham.util;

import org.springframework.stereotype.Component;

@Component
public class SqlCoach implements Coach{
    @Override
    public String getInstruction(){
        return "Practice MySQL queries atleast 2 hours a day";
    }
}
