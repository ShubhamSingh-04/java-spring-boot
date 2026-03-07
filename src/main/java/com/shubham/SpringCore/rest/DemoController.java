package com.shubham.SpringCore.rest;

import com.shubham.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
    private Coach anotherCoach;

    @Autowired
 DemoController(@Qualifier("springCoach") Coach coach, @Qualifier("springCoach") Coach anotherCoach){
        System.out.println("This class is now initialized: " + getClass().getSimpleName());
        System.out.println("DemoController - coach == anotherCoach: " + (coach == anotherCoach)); // false as scope is prototype
     this.coach = coach;
 }

    @GetMapping("/coachInstruction")
    public String getSpringInstruction(){
        return this.coach.getInstruction();
    }
}
