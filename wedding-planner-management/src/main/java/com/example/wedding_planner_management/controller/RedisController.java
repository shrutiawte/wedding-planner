package com.example.wedding_planner_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.wedding_planner_management.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    // Store data in Redis
    @PostMapping("/save")
    public String saveData(@RequestParam String key, @RequestParam String value) {
        redisService.saveToRedis(key, value);
        return "Data saved in Redis";
    }

    // Retrieve data from Redis
    @GetMapping("/get")
    public Object getData(@RequestParam String key) {
        return redisService.getFromRedis(key);
    }

    // Delete data from Redis
    @DeleteMapping("/delete")
    public String deleteData(@RequestParam String key) {
        redisService.deleteFromRedis(key);
        return "Data deleted from Redis";
    }
}

