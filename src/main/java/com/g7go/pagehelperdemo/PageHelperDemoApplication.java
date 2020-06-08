package com.g7go.pagehelperdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.g7go.pagehelperdemo.demo.dao")
public class PageHelperDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageHelperDemoApplication.class, args);
    }

}
