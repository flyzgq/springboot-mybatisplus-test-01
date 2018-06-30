package com.fly.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.fly.springboot.mapper")
public class SpringbootMybatisplusTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusTest01Application.class, args);
    }
}
