package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/test")
	public String HellogSpring() {
		System.out.println("��");
		return "Hello Spring";
	}
}
