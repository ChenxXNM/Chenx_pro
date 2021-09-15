package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class ChenxProServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChenxProServerApplication.class, args);
    }

}
