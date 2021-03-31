package com.gin.springbootmbp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.gin.springbootmbp.mapper"})
public class SpringbootMbpApplication {

	public static void main(String[] args) {SpringApplication.run(SpringbootMbpApplication.class, args);
	}

}
