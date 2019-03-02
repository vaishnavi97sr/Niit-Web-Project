package com.niiit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niiit.model.Customer;

@Controller
public class HomeController {
public HomeController(){
	System.out.println("homeController bean is created");
}
@RequestMapping(value="/home")
public String getHomePage(){
	return "home";
}

@RequestMapping(value="/signup")
public ModelAndView getSignupPage(Model m){
	ModelAndView mv = new ModelAndView("registrationform","customer",new Customer());
	return mv;
	
}

@RequestMapping("/login")
public String login(){
	return "login";
}
@RequestMapping("/loginerror")
public String loginError(Model model){
	model.addAttribute("loginError","Invalid email/password");
	return "login";
}
@RequestMapping(value="/logout")
public String logout(Model model){
	model.addAttribute("message","Loggedout successfully..");
	return "login";
}

}

