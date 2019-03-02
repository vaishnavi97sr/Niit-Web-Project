package com.niiit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niiit.dao.Productdao;
import com.niiit.model.Product;
@Controller
public class Product_f {
	@Autowired
	Productdao productDao;
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/product")
	public ModelAndView showMessage() {
		System.out.println("In product");
		
		ModelAndView mv = new ModelAndView("Product_form","command",new com.niiit.model.Product());
		return mv;
	}
	
	@RequestMapping(value="/all/getproduct",method = RequestMethod.GET)  
    public ModelAndView getPro(){  
	List<com.niiit.model.Product> prolist=productDao.getAllProduct();
	ModelAndView mv=new ModelAndView("Product_form","products",prolist);
	mv.addObject("command",new com.niiit.model.Product());
	return mv;
	}
	
	@RequestMapping(value="/saveproduct",method = RequestMethod.POST)  
    public String save(@ModelAttribute("pro") com.niiit.model.Product pro,HttpServletRequest request){  

	productDao.addProduct(pro);
	
	//productService.addProduct(product);//in dao session.save(product)
	MultipartFile img=pro.getImage();
	System.out.println(request.getServletContext().getRealPath("/"));
	
	//Defining a path
	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+pro.getId()+".jpg");
	
	//Create a file in the path
	
	try {
		if(img!=null && !img.isEmpty()){
		File file=new File(path.toString());
		img.transferTo(file);
		}
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//return "redirect:/all/getallproducts";

	//ModelAndView mv=new ModelAndView("Category_form","command",new com.niiit.model.Category());
	return "redirect:/product";
	
 }
//	@RequestMapping(value="/Update")
//	public ModelAndView UpdateProduct(){
//		List<com.niiit.model.Product> UpdatePro=productDao.UpdateProduct();
//		ModelAndView mv=new ModelAndView("Product_form","Up_pro",UpdatePro);
//		return mv;
//	}
//	
	@RequestMapping(value="/DeletePro-{id}")
	public String DeleteProduct(@PathVariable("id") int id){
		productDao.deleteProduct(id);
		
		return "redirect:/all/getproduct";
	}
	
	@RequestMapping(value="/admin/updateproductform")
	public String getUpdateProductForm(@RequestParam int id,Model model){
		Product product=productDao.getProduct(id);
		model.addAttribute("product",product);
//		List<Category> categories=productService.getAllCategories();
//		model.addAttribute("categories",categories);
		return "Update_product";
	}

	@RequestMapping(value="/admin/updateproduct")
	public String updateProduct( @ModelAttribute Product product,BindingResult result,Model model,HttpServletRequest request){
//		if(result.hasErrors()){
//			List<Category> categories=productService.getAllCategories();
//			model.addAttribute("categories",categories);
//			return "updateproductform";
//		}
		productDao.updateProduct(product);
		MultipartFile img=product.getImage();
		System.out.println(request.getServletContext().getRealPath("/"));
		//Defining a path
		Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".jpg");
		//Create a file in the path
		try {
			if(img!=null && !img.isEmpty()){
			File file=new File(path.toString());
			img.transferTo(file);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all/getproduct";
	}
}
