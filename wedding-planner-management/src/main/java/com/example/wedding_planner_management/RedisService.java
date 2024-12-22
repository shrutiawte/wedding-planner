package com.example.wedding_planner_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Save key-value pair in Redis
    public void saveToRedis(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Retrieve value from Redis by key
    public Object getFromRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Delete a key-value pair from Redis
    public void deleteFromRedis(String key) {
        redisTemplate.delete(key);
    }
}

