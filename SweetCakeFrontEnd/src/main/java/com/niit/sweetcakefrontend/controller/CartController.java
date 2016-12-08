package com.niit.sweetcakefrontend.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sweetcake.dao.CartDao;
import com.niit.sweetcake.dao.CartItemsDao;
import com.niit.sweetcake.dao.CustomerDao;
import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.model.Cart;
import com.niit.sweetcake.model.CartItems;
import com.niit.sweetcake.model.Customer;
import com.niit.sweetcake.model.Product;
import com.niit.sweetcake.model.User;

@Controller
public class CartController {

	@Autowired
	CartDao cartDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	User user; 
	
	@Autowired 
	UserDao userDao;
	
	@Autowired
	Customer customer;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CartItems cartitems;
	
	@Autowired
	CartItemsDao cartitemsDao;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	
	
	@RequestMapping("/addtoCart/{p_Id}")
	public ModelAndView addtoCart(@PathVariable("p_Id")String id, Model m, HttpSession session,Principal principal )
	{
		ModelAndView obj=new ModelAndView("redirect:"+"/singlepage/"+id);
		
		System.out.println("It is working");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			
		    String currentUserName = authentication.getName();
		    System.out.println("currentUserName"+currentUserName);
		   User u=(User) userDao.getByEmailId(currentUserName) ;
//		   System.out.println(u.getUserName());
//		   System.out.println(u.getAddress());
		   
		   if(u==null){
			   System.out.println("Sorry , no cart");
		   }
		   else
		   {
			   System.out.println("Coming");
		   
		   Cart c=(Cart)cartDao.get(u.getUserId());
		   if(c==null)
		   {
			    cart.setUserId(u.getUserId());
			    cartDao.saveorupdate(cart);
			    Product p=(Product)productDao.get(id);
			    cartitems.setP_Id(p.getP_Id());
			    cartitems.setP_Name(p.getP_Name());
			    cartitems.setQuantity(1);
			    cartitems.setCart(cart);
			    cartitems.setUserId(u.getUserId());
			    cartitems.setTotalprice(cartitems.getQuantity()*p.getP_Price());			   			   
			  if(cartitemsDao.save(cartitems)==true)
			  {
                   double g2=0.0;
				   String g=cart.getGrandtotal();
                    if(g==null)
                    {
                    	double t=cartitems.getTotalprice();
    					g2=g2+t;
    					String gt1=String.valueOf(g2);
    					cart.setGrandtotal(gt1);
    					if(cartDao.saveorupdate(cart)==true)
    					{
    					  System.out.println("catr is added and product is added to cartItems");	
    					}
    				   
                    }
			  }
		    }
		   else
		   {      	
                    	Product p1=(Product)productDao.get(id);
                    	CartItems cit= new CartItems();
        			    cit.setP_Id(p1.getP_Id());
        			    cit.setP_Name(p1.getP_Name());
        			    cit.setQuantity(1);
        			    cit.setCart(c);
        			    cit.setUserId(u.getUserId());
        			    cit.setTotalprice(cit.getQuantity()*p1.getP_Price());
        			    if(cartitemsDao.save(cit)==true)
        				  {
        	                   double g2=0.0;
        					   String g=c.getGrandtotal();
        	                    if(g==null)
        	                    {
        	                    	double t=cit.getTotalprice();
        	    					System.out.println(t);
        	    					g2=g2+t;
        	    					System.out.println(g2);
        	    					String gt1=String.valueOf(g2);
        	    					System.out.println(gt1);
        	    					c.setGrandtotal(gt1);
        	    					System.out.println(c.getGrandtotal());
        	                    }
        	                    else
        	                    {
        	                    	g2=Double.parseDouble(g);
        	                    	double t=cit.getTotalprice();
        	    					System.out.println(t);
        	    					g2=g2+t;
        	    					System.out.println(g2);
        	    					String gt1=String.valueOf(g2);
        	    					System.out.println(gt1);
        	    					c.setGrandtotal(gt1);
        	    					System.out.println(c.getGrandtotal());
        	                    }
        	                    cartDao.saveorupdate(c);
        	                    System.out.println("done");
        	                    }
        			    
        			  
		   }
		   }}
		return obj;
		   }
   



	
	@RequestMapping("/checkout")
	public ModelAndView addtoCart( Model m)
	{
		ModelAndView obj=new ModelAndView("checkout");
		
		System.out.println("It is working");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			
		    String currentUserName = authentication.getName();
		    System.out.println("currentUserName"+currentUserName);
		   User u=(User) userDao.getByEmailId(currentUserName) ;
		   if(u==null)
		   {
			   System.out.println("Sorry");
			   
		   }
		   else
		   {
			   System.out.println("I have money");
			   
			   Cart c=(Cart)cartDao.get(u.getUserId());
			   if(c==null)
			   {
				   obj.addObject("msg", "U have no cart items added");
				   
			   }
			   else
			   {
				   obj.addObject("user",c.getCart_Id());
				  List<CartItems> l=(List<CartItems>)cartitemsDao.get(c.getCart_Id());
			   if(l == null || l.isEmpty())
			   {
				   obj.addObject("msg", "U have no cart items added");
			    }
			   else
			   {
				   for(CartItems li : l)
				   {
					   System.out.println(li.getCartitems_Id());
					   System.out.println(li.getUserId());
					   System.out.println(li.getTotalprice());
					  System.out.println(li.getP_Name());
					  System.out.println(li.getP_Id());
				   }
				   Cart c1=(Cart)cartDao.get(u.getUserId());
				   obj.addObject("c1",c1.getGrandtotal());
				   obj.addObject("li", l);
			   }
		   }
      }
		   
	}
		return obj;
  }
	

	
@RequestMapping("/remove/{cartitems_Id}")
	public ModelAndView remove(@PathVariable(value="cartitems_Id")String id, Model model)
	{
	  double g=0.0,h;
	ModelAndView obj= new ModelAndView("redirect:"+"/checkout");	 
	System.out.println("I am coming");
	cartitems=cartitemsDao.getbyCartItems(id);
	g=cartitems.getTotalprice();
	cart=cartDao.get(cartitems.getUserId());
	if(cartitemsDao.prodelete(cartitems)==true)
		{
		  String g1=cart.getGrandtotal();
		  h=Double.parseDouble(g1);
		  h=h-g;
		  String j=String.valueOf(h);
		  cart.setGrandtotal(j);
		  cartDao.saveorupdate(cart);
		   
		}
	return obj;
	 }
@RequestMapping("/remove2/{user}")
public ModelAndView remove2(@PathVariable(value="user")String id, Model model)
{
	ModelAndView obj= new ModelAndView("redirect:"+"/checkout");
	String uid=null;
	List<CartItems> l=(List<CartItems>)cartitemsDao.get(id);
	for(CartItems l2:l)
	{
		uid=cartitems.getUserId();
		cartitems=l2;
		cartitemsDao.delete(cartitems);	
	}
	cart=cartDao.get(uid);
	cart.setGrandtotal("0.0");
	cartDao.saveorupdate(cart);
	obj.addObject("msg", "no cart is added");
	
	return obj;
}
}
	 

	
//	@RequestMapping("/buy/{p_Id}")
//	public ModelAndView Shipping(@PathVariable("p_Id")String p_Id)
//	{    System.out.println(1);
//		ModelAndView obj= new ModelAndView("shippingaddress");
//		Product product= productDao.get(p_Id);
////		product=(Product)productDao.get(p_Id);
//		return obj;
//	}

		   
//		   Cart c=(Cart)cartDao.get(cus.);
//		      if(c==null)
//		      {
//		    	  System.out.println("cart is not there");
//		      }
//		      else
//		      {
//		    	  Product p= (Product)productDao.get(p_Id);
//				   System.out.println(p.getP_Name());
//				   cartitems.setP_Id(p.getP_Id());
//				   cartitems.setQuantity(4);
//				  cartitems.setCart(c);
////				  cartitems.setCustomer_Id("customerF525BE");
//				   cartitems.setTotalprice(cartitems.getQuantity()*p.getP_Price());
//				  // cart.setGrandtotal(cart.getGrandtotal()+cartitems.getTotalprice());
//	
				  
//				if(cartitemsDao.saveorupdate(cartitems)==true)
//				{
//					String g=c.getGrandtotal();
//					double t=cartitems.getTotalprice();
//					
//					double gt=Double.parseDouble(g);
//					gt=gt+t;
//					
//					String gt1=String.valueOf(gt);
//					c.setGrandtotal(gt1);
//					if(cartDao.saveorupdate(c)==true)
//						System.out.println("Cart is updated");
//					System.out.println("Items is added to list");
//				} 
//		      }
//		   
//		   
//		}
//		System.out.println("hiiii");
		   



