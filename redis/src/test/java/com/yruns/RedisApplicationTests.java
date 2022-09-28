package com.yruns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testSet() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("age", 23);
    }

    @Test
    void testGet() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object age = valueOperations.get("age");
        System.out.println(age);
    }

    @Test
    void testHset() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info", "index", "aa");
    }

    @Test
    void testHget() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object o = hashOperations.get("info", "index");
        System.out.println(o);
    }

}
