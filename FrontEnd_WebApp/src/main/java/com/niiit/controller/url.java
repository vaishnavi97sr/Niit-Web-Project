package com.niiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class url {
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/hello")
	public ModelAndView showMessage() {
		System.out.println("In controller");
		
		ModelAndView mv = new ModelAndView("helloworld");
		return mv;
	}
}
