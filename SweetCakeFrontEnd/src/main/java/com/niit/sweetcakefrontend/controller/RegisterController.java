package com.niit.sweetcakefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sweetcake.dao.RoleDao;
import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.model.Role;
import com.niit.sweetcake.model.User;



@Controller
public class RegisterController {

		@Autowired
		UserDao userDao;
		
		@Autowired
		User user;
		
		@Autowired
		Role role;
		
		@Autowired 
		RoleDao roleDao;
		
		@RequestMapping(value="/register" )
		public ModelAndView Register(Model model)
		{
			System.out.println(1);
			ModelAndView obj=new ModelAndView("register");
			obj.addObject("user",user);
			System.out.println("register is working");
			return obj; 
		}
		
		
		@RequestMapping(value="/Submit",method =RequestMethod.POST)
		public ModelAndView register(@ModelAttribute("user")User user, @RequestParam("ConfirmPassword")String a)
		{
			System.out.println("I am coming");
			//System.out.println(100);
			//return null;
			if(user.getPassword().equals(a))
			{
				//user.setUserName(p);
				//u.setUser_dob(q);
				ModelAndView obj=new ModelAndView("index");
				System.out.println("*****************************");
				System.out.println(user.getUserName());
				System.out.println(user.getAddress());
				System.out.println(user.getEmailId());
				System.out.println(user.getPassword());
//				System.out.println(q);
//				System.out.println(d);
				System.out.println(user.getMobile());
				
				System.out.println("****************************");
				
				if(userDao.saveorupdate(user)==true)
					{ 
						role.setUSERNAME(user.getEmailId());
						if(roleDao.save(role)==true)
				        {	
						System.out.println(3);
						System.out.println("saved");
				        }
						System.out.println("save and update is working");
					    return obj; 
					   
					}
				else
				{
					System.out.println("sorry");
					return new ModelAndView("register"); 
				}
			 }
				else
				{
					ModelAndView obj=new ModelAndView("register");
					System.out.println(200);
					obj.addObject("password", "password is wrong");
					return obj;		
					
				}
	   }
		}


