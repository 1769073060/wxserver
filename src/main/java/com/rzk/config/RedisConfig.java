package com.rzk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @PackageName : com.rzk.config
 * @FileName : RedisConfig
 * @Description : redis配置类
 * @Author : rzk
 * @CreateTime : 2022/1/15 17:13
 * @Version : 1.0.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //为String类型的key设置序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //为String类型的value设置序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //为hash类型的key设置序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //为hash类型的value设置序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
