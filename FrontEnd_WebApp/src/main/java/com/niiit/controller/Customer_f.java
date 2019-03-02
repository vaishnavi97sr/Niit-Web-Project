package com.niiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niiit.dao.Customerdao;
import com.niiit.model.Customer;
//import com.niiit.services.CustomerService;

@Controller
public class Customer_f {
	@Autowired
  private Customerdao customerdao;
	
	
	@RequestMapping(value="/all/getregistrationform")
	public String getRegistrationForm(Model model){
	Customer customer	=new Customer();
	model.addAttribute("customer",customer);	
	return "registrationform";	
	}
	@RequestMapping(value="/all/registercustomer")
	public String registerCustomer(@ModelAttribute Customer customer,Model model){
		String email=customer.getUser().getEmail();
		if(!customerdao.isEmailUnique(email)){//Email is duplicate, Not Unique
			model.addAttribute("errorMessage","Email already exists.. please choose different email id");
			return "registrationform";
		}
		customerdao.registerCustomer(customer);
		
		return "login";
	}
}
