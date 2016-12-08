package com.niit.sweetcakefrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sweetcake.dao.CategoryDao;
import com.niit.sweetcake.model.Category;

@Controller
public class CategoryController {

	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Category category;
	
	@RequestMapping(value="/manageCategory")
	public ModelAndView AddCategory(Model model)
	{
		System.out.println(1);
		List<Category> lcategory=(List<Category>)categoryDao.list();
		ModelAndView obj=new ModelAndView("manageCategory");
		Category cat=new Category();
		obj.addObject("category",category);
		obj.addObject("lcategory",lcategory);
		System.out.println("adding Category is working");
		return obj; 
	}
	
	
	
	@RequestMapping(value="/managecategory")
	public ModelAndView AddCategory(@ModelAttribute("category")Category cate,HttpSession session)
	{
		System.out.println("I am coming");
		ModelAndView obj= new ModelAndView("redirect:"+"/manageCategory");
		 //ModelAndView obj=new ModelAndView("/manageCategory");
			System.out.println("*****************************");
			System.out.println(cate.getC_Name());
			System.out.println(cate.getC_Description());
			System.out.println("****************************");
	
			if(session.getAttribute("cat123")==null)
			{
				System.out.println("sorry");
				if(categoryDao.saveorupdate(cate)==true)
				{ 	
					System.out.println("*****************************");
					System.out.println(cate.getC_Name());
					System.out.println(cate.getC_Description());
					System.out.println("****************************");
				//ModelAndView obj= new ModelAndView("manageCategory");
					System.out.println("save and update is working");
					//ModelAndView obj= new ModelAndView("redirect:"+"/manageCategory");
				    
				}
    			else
	     		{
				System.out.println("sorry");
				return new ModelAndView("manageCategory"); 
		     	}	
				return obj;
			}
		
			else
			{
				Category c=(Category)session.getAttribute("cat123");
				cate.setC_Id(c.getC_Id());
			
			if(categoryDao.saveorupdate(cate)==true)
			{
				System.out.println("Edit is working");
//				session.invalidate();
			 	
			}
			return obj;
			
		 }
	}
	
	
	@RequestMapping("cdelete/{c_Id}")
	public String delete(@PathVariable(value="c_Id") String id) throws Exception {
		System.out.println("Iam going to delete");
		categoryDao.delete(id);
		System.out.println("deleted and redirecting");
		return "redirect:/manageCategory";
	}
		
	
	
	@RequestMapping("/cedit/{c_Id}")
	public String categoryEdit(@PathVariable("c_Id") String id, ModelMap model, HttpSession session) throws Exception {
		category = categoryDao.get(id);
		session.setAttribute("cat123", category);
		model.addAttribute("editCategory", category);
		model.addAttribute("lcategory", this.categoryDao.list());
		return "redirect:/manageCategory";
	}
}
