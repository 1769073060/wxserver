package com.rzk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
@MapperScan("com.rzk.mapper")
@SpringBootConfiguration
public class WxserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxserverApplication.class, args);
    }

}
