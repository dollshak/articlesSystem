package com.example.demo2;

import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import com.example.demo2.Server.api.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@EnableJpaRepositories(basePackages = "com.example.demo2.Server.Data")
@SpringBootApplication
public class Demo2Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}

