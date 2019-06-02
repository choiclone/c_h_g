package com.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloController {
	public String hello() {
		return "hello world";
	}
}
