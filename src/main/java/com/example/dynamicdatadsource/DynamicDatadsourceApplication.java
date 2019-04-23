package com.example.dynamicdatadsource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.example.dynamicdatadsource.dao")
public class DynamicDatadsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatadsourceApplication.class, args);
	}

}
