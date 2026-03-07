package com.shubham.util.config;

import com.shubham.util.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimCoachConfig {
//    @Bean
    @Bean("swimmer")
    public SwimCoach swimCoach(){
        return new SwimCoach();
    }
}
