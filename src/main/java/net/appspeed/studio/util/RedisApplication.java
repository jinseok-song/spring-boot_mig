package net.appspeed.studio.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RedisApplication {

    @Autowired
    RedisTemplate redisTemplate;


    void contextLoads(){

    }


    public void redisConnection(){
        final String key= "a";
        final String data = "1";

        final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, data);

        final String result = valueOperations.get(key);
        log.info("data:" + key);
        log.info("data: "+ data);
        log.info("result: "+ result);

    }


}
