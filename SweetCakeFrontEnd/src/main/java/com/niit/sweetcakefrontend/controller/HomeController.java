package com.niit.sweetcakefrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.model.Product;

@Controller
public class HomeController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Product product;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "index";
	}

	@RequestMapping(value="/products")
	public ModelAndView products(Model model)
	{
		List<Product> pro=(List<Product>)productDao.list();
		System.out.println(1);
		ModelAndView obj=new ModelAndView("products");
		Product prod=new Product();
		obj.addObject("pro", pro);
		return obj;
	} 
	
	@RequestMapping("/singlepage/{p_Id}")
	public String singelpage(@PathVariable(value="p_Id")String id, Model m)
	{
		 product=productDao.get(id);
		 m.addAttribute("pro",product);
		return "singlepage";
	} 
	
	@RequestMapping("/Admin")
	public String admin()
	{
		return "Admin";
	} 
	
	/*@RequestMapping("/login")
	public String login()
	{
		return "login";
	}*/
	
	/*@RequestMapping("/register")
	public String register()
	{
		return "register";
	}*/
	
	/*@RequestMapping("/gallery")
	public String gallery()
	{
		return "gallery";
	}*/
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
//	@RequestMapping("/checkout")
//	public String checkout()
//	{
//		return "checkout";
//	} 
	
}
