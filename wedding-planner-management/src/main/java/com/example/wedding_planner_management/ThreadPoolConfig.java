package com.example.wedding_planner_management;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public Executor customTaskExecutor() {
        return Executors.newFixedThreadPool(10);  
    }
}
