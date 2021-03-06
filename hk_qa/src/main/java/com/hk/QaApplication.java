package com.hk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class);
    }
}
