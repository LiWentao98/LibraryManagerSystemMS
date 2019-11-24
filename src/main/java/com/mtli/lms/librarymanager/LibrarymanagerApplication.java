package com.mtli.lms.librarymanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mtli.lms.librarymanager.mapper")//批量扫描mapper
@SpringBootApplication
public class LibrarymanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarymanagerApplication.class, args);
    }

}
