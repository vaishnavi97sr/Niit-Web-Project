package com.niiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niiit.dao.Categorydao;
@Controller
public class Category_f {
	
	@Autowired
	Categorydao categoryDao;
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/category")
	public ModelAndView showMessage() {
		System.out.println("In category");
		
		ModelAndView mv = new ModelAndView("Category_form","command",new com.niiit.model.Category());
		return mv;
	}
	
	 @RequestMapping(value="/savecategory",method = RequestMethod.POST)  
	    public String save(@ModelAttribute("cat") com.niiit.model.Category cat){  
		categoryDao.addCategory(cat);
		//ModelAndView mv=new ModelAndView("Category_form","command",new com.niiit.model.Category());
		return "redirect:/category";
	 }
	 
	 @RequestMapping(value="/getcategory",method = RequestMethod.GET)  
	    public ModelAndView getCate(){  
		List<com.niiit.model.Category> catlist=categoryDao.getAllCategory();
		ModelAndView mv=new ModelAndView("Category_form","categories",catlist);
		mv.addObject("command",new com.niiit.model.Category());
		return mv;
		}
	 
	 @RequestMapping(value="/DeleteCat-{cid}")
		public String DeleteCategory(@PathVariable("cid") int cid){
			categoryDao.deleteCategory(cid);
			
			return "redirect:/getcategory";
		}
}
