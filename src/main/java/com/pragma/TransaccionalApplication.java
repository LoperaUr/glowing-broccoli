package com.pragma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransaccionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransaccionalApplication.class, args);
    }

}
