package com.Attendance.Spring.Boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@SpringBootApplication
public class Example {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}
