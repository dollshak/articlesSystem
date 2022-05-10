package com.example.demo2;

import com.example.demo2.Server.Business.Controllers.ArticleController;
import com.example.demo2.Server.FacadeObjects.FacadeUser;
import com.example.demo2.Server.api.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
//		FacadeUser user = new FacadeUser();
//		user.setName("ofek");
//		user.setPassword("ofek1212");
//		String json = user.toJson();
//		System.out.println(json);
	}
}

