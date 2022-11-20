package com.example.db_lab4;

import com.example.db_lab4.config.AppConfig;
import com.example.db_lab4.dao.ScientistDAO;
import com.example.db_lab4.entities.Scientist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DbLab4Application {

    public static void main(String[] args) {
        SpringApplication.run(DbLab4Application.class, args);
    }

}
