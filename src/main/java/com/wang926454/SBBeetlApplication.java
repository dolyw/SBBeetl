package com.wang926454;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SBBeetlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SBBeetlApplication.class, args);
    }

}
