package com.xxx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 
@SpringBootApplication
@MapperScan("com.xxx.springboot.dao")
public class SpringBootStarter extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}
}
