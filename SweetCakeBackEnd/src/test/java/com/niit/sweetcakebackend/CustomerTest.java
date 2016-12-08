package com.niit.sweetcakebackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sweetcake.dao.CartDao;
import com.niit.sweetcake.dao.CustomerDao;
import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.model.Cart;
import com.niit.sweetcake.model.Customer;
import com.niit.sweetcake.model.User;

public class CustomerTest {
	

	public static void main(String a[])
	   {
	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("com.niit.*");
	   context.refresh();
	   System.out.println(1);
	   CustomerDao customerDao =(CustomerDao)context.getBean("customerDao");
	   Customer customer=(Customer)context.getBean("customer");
	   UserDao userDao=(UserDao)context.getBean("userDao");
	   User user=(User)context.getBean("user");
	   CartDao cartDao=(CartDao)context.getBean("cartDao");
	   Cart cart=(Cart)context.getBean("cart");
	   
	   Customer c=(Customer)customerDao.get("user57e7e5");
	    
	   if(c==null)
	   {
		   User u=(User)userDao.get("user57e7e5");
		   System.out.println("doesnot");
		   customer.setCustomer_Name(u.getUserName());
		   customer.setCustomer_mobile(u.getMobile());
		   customer.setCustomer_Emailid(u.getEmailId());
		   //customer.setCart();
		   customer.setUserId(u.getUserId());
		   if(customerDao.save(customer)==true)
		   {
			  System.out.println("u r a new c"); 
		   }
		  
		   else
		   {
			   System.out.println("yes");
		   }
		   
	   }
		   Cart c1= (Cart)cartDao.get(c.getCustomer_Id());
		   if(c1==null)
		   {
			   System.out.println("u dont have a cart");
//			   cart.se
			   cart.setGrandtotal("0");
			   
			   if(cartDao.saveorupdate(cart)==true)
			   {
				   c.setCart(cart);
				   if(customerDao.update(c)==true)
				   {
					   System.out.println("Update is done");
				   }
				   System.out.println("new cart is created");
				   
			   }
		  }
		   else
		   {
			   System.out.println("u hv  a cart");
		   }
		  }
	   }


