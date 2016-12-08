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

import com.niit.sweetcake.dao.SupplierDao;
import com.niit.sweetcake.model.Category;
import com.niit.sweetcake.model.Product;
import com.niit.sweetcake.model.Supplier;

@Controller
public class SupplierController {

	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	Supplier supplier;
	
	@RequestMapping(value="/manageSupplier" )
	public ModelAndView AddSupplier(Model model)
	{
		System.out.println(1);
		List<Supplier> lsupplier=(List<Supplier>) supplierDao.list();
		ModelAndView obj=new ModelAndView("manageSupplier");
		Supplier sup=new Supplier();
		obj.addObject("supplier",supplier);
		obj.addObject("lsupplier",lsupplier);
		System.out.println("adding Supplier is working");
		return obj; 
	}
	
	
	@RequestMapping(value="/managesupplier",method =RequestMethod.POST)
	public ModelAndView AddSupplier(@ModelAttribute("supplier")Supplier supplier,HttpSession session)
	{
		System.out.println("I am coming");
		ModelAndView obj1= new ModelAndView("redirect:"+"/manageSupplier");
			//ModelAndView obj=new ModelAndView("manageSupplier");
			System.out.println("*****************************");
			System.out.println(supplier.getS_Name());
			System.out.println(supplier.getS_Address());
			System.out.println(supplier.getS_Phoneno());
			
			System.out.println("****************************");
			if(session.getAttribute("sup1")==null)
			{
				System.out.println("sorry");
			
			if(supplierDao.saveorupdate(supplier)==true)
				{ 
						System.out.println("*****************************");
						System.out.println(supplier.getS_Name());
						System.out.println(supplier.getS_Address());
						System.out.println("****************************");
						
					System.out.println("save and update is working");
//					ModelAndView obj= new ModelAndView("redirect:"+"/manageSupplier");
				    
				}
			else
			{
				System.out.println("sorry");
				return new ModelAndView("manageSupplier"); 
			}
			return obj1;
			}
			else
			{
				Supplier  s=(Supplier)session.getAttribute("sup1");
				supplier.setS_Id(s.getS_Id());
			
			if(supplierDao.saveorupdate(supplier)==true)
			{
				System.out.println("Edit is working");
//				session.invalidate();
			 	
			}
			return obj1;
			
		 }
		 }
	
	@RequestMapping("sdelete/{s_Id}")
	public String delete(@PathVariable(value="s_Id") String id) throws Exception {
		System.out.println("Iam going to delete");
		supplierDao.delete(id);
		System.out.println("deleted and redirecting");
		return "redirect:/manageSupplier";
	}
		
	
	@RequestMapping("/sedit/{s_Id}")
	public String supplierEdit(@PathVariable(value="s_Id") String id, ModelMap model, HttpSession session) throws Exception {
		supplier=supplierDao.get(id);
		session.setAttribute("sup1",supplier);
		model.addAttribute("editSupplier", supplier);
		model.addAttribute("lsupplier", this.supplierDao.list());
	  return "redirect:/manageSupplier";
    }
	

			
}
