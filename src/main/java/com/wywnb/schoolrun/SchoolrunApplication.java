package com.wywnb.schoolrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication()
public class SchoolrunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolrunApplication.class, args);
    }

}
