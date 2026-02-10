package com.shubham.SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private SpringCoach coach;

    @Autowired
    DemoController(SpringCoach coach){
        this.coach = coach;
    }

    @GetMapping("/coachInstruction")
    public String getSpringInstruction(){
        return this.coach.getInstruction();
    }
}
