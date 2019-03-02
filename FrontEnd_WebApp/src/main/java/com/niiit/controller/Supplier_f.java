package com.niiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niiit.dao.Supplierdao;

@Controller
public class Supplier_f {
	
	@Autowired
	Supplierdao supplierDao;
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/supplier")
	public ModelAndView showMessage() {
		System.out.println("In supplier");
		
		ModelAndView mv = new ModelAndView("Supplier_form","command",new com.niiit.model.Supplier());
		return mv;
	}
	
	@RequestMapping(value="/savesupplier",method = RequestMethod.POST)  
    public String save(@ModelAttribute("sup") com.niiit.model.Supplier sup){  
	 
	supplierDao.addSupplier(sup);
	//ModelAndView mv=new ModelAndView("Category_form","command",new com.niiit.model.Category());
	return "redirect:/supplier";
 }
	
	@RequestMapping(value="/getsupplier",method = RequestMethod.GET)  
    public ModelAndView getSupp(){  
	List<com.niiit.model.Supplier> suplist=supplierDao.getAllSupplier();
	ModelAndView mv=new ModelAndView("Supplier_form","suppliers",suplist);
	mv.addObject("command",new com.niiit.model.Supplier());
	return mv;
	}
	
	@RequestMapping(value="/DeleteSup-{sup_id}")
	public String DeleteSupplier(@PathVariable("sup_id") int sup_id){
		supplierDao.deleteSupplier(sup_id);
		
		return "redirect:/getsupplier";
	}
	
}
