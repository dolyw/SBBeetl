package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author Wang926454
 * @date 2018/8/1 17:56
 */
@SpringBootApplication
@EnableCaching
public class SBBeetlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SBBeetlApplication.class, args);
    }

}
