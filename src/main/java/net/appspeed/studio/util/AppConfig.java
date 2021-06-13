package net.appspeed.studio.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Log4j2
@Configuration
public class AppConfig {
    @Value("${redis.port}")
    public int port;

    @Value("${redis.host}")
    public String host;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        log.info("host:"+ host);
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        log.info("host:"+ host);
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
}