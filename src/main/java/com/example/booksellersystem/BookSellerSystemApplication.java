package com.example.booksellersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时器
@SpringBootApplication
@ServletComponentScan//开启拦截器
public class BookSellerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSellerSystemApplication.class, args);
    }

}
