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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sweetcake.dao.CategoryDao;
import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.dao.SupplierDao;
import com.niit.sweetcake.model.Category;
import com.niit.sweetcake.model.Product;
import com.niit.sweetcake.model.Supplier;
import com.niit.sweetcakefrontend.fileinput.FileInput;

@Controller
public class ProductController {

	@Autowired 
	SupplierDao supplierDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Category category;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Product product;
	
	String path="D:\\EclipseProjectWorkspace1\\SweetCakeFrontEnd\\src\\main\\webapp\\WEB-INF\\resources\\img\\";
	
	@RequestMapping(value="/manageProduct" )
	public ModelAndView AddProduct(Model model)
	{
		List<Category> lcategory=(List<Category>) categoryDao.list();
		List<Supplier> lsupplier=(List<Supplier>) supplierDao.list();
		List<Product> lproduct=(List<Product>) productDao.list();
		
		System.out.println(1);
		ModelAndView obj=new ModelAndView("manageProduct");
		Category cat=new Category();
		product.setCategory(cat);
		Supplier sup=new Supplier();
		product.setSupplier(sup);
		Product prod=new Product();
		obj.addObject("product",product);
		obj.addObject("lcategory",lcategory);
		obj.addObject("lsupplier",lsupplier);
		obj.addObject("lproduct",lproduct);
		
		System.out.println("adding Product is working");
		return obj; 
	}
	
	
	
	@RequestMapping(value="/manageProduct",method =RequestMethod.POST)
	public ModelAndView AddProduct(@ModelAttribute("product")Product product,@RequestParam("cat")String id1, @RequestParam("sup")String id2 ,HttpSession session)
	{
		System.out.println("I am coming");
		ModelAndView obj1= new ModelAndView("redirect:"+"/manageProduct");
		 
			System.out.println(id1+ " "+ id2+ " ");
			//ModelAndView obj=new ModelAndView("index");
			Category category=(Category)categoryDao.get(id1);
			product.setCategory(category);
			Supplier supplier=(Supplier)supplierDao.get(id2);
			product.setSupplier(supplier);
			System.out.println("*****************************");
			System.out.println(product.getP_Name());
			System.out.println(product.getP_Description());
			System.out.println(product.getP_Price());
			System.out.println(product.getP_Quantity());
			System.out.println(product.getCategory());
			System.out.println(product.getSupplier());
			System.out.println("****************************");
		

			if(session.getAttribute("prod1")==null)
			{
				System.out.println("sorry");
			
			if(productDao.saveorupdate(product)==true)
				{ 	
					System.out.println(product.getP_Name());
					System.out.println(product.getP_Description());
					FileInput.upload(path, product.getImg(), product.getP_Id()+".jpg");
					product.setImage(product.getP_Id()+".jpg");
					productDao.saveorupdate(product);
					System.out.println("save and update is working");
//					ModelAndView obj= new ModelAndView("redirect:"+"/manageProduct");
//				    return obj;
				   
				}
			else
			{
				System.out.println("sorry");
				return new ModelAndView("manageProduct"); 
			}
		return obj1;
		 }
			else
			{
				Product p=(Product)session.getAttribute("prod1");
				product.setP_Id(p.getP_Id());
			
			if(productDao.saveorupdate(product)==true)
			{
				System.out.println("Edit is working");
//				session.invalidate();
			 	
			}
			return obj1;
		}
				
	}
	
	@RequestMapping("pdelete/{p_Id}")
	public String delete(@PathVariable(value="p_Id") String id) throws Exception {
		System.out.println("Iam going to delete");
		productDao.delete(id);
		System.out.println("deleted and redirecting");
		return "redirect:/manageProduct";
	}
		
	
	@RequestMapping("/pedit/{p_Id}")
	public String getEdit(@PathVariable(value="p_Id") String id, ModelMap model, HttpSession session) throws Exception {
		product=productDao.get(id);
		session.setAttribute("prod1", product);
		model.addAttribute("editProduct", product);
		model.addAttribute("lproduct", this.productDao.list());
		return "redirect:/manageProduct";
	
	}
	
}



