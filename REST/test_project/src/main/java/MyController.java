package com.parker.app.restapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.parker.app.restapi.MyRestApplication;

@RestController
public class MyController{
	
	@GetMapping("/hello")
	public String sayHello(){
		return "Hello Cindy, from Java!";
	}
}
