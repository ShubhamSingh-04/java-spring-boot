package com.shubham.SpringCore.rest;

import com.shubham.util.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    @Autowired
 DemoController(@Qualifier("springCoach") Coach coach){
        System.out.println("This class is now initialized: " + getClass().getSimpleName());
        this.coach = coach;
 }

    @GetMapping("/coachInstruction")
    public String getSpringInstruction(){
        return this.coach.getInstruction();
    }

    @PostConstruct
    public void doStartupStuff(){
        System.out.println("doStartupStuff: " + getClass().getSimpleName());
    }

    // For "prototype" scoped beans, Spring does not call the destroy method. You must manually destroy it
    @PreDestroy
    public void doDestroyStuff(){
        System.out.println("doDestroyStuff(): " + getClass().getSimpleName());
    }
}
