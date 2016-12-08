package com.niit.sweetcakefrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.sweetcake.dao.CartDao;
import com.niit.sweetcake.dao.CartItemsDao;
import com.niit.sweetcake.dao.OrderDao;
import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.model.Cart;
import com.niit.sweetcake.model.CartItems;
import com.niit.sweetcake.model.Orders;
import com.niit.sweetcake.model.Product;
import com.niit.sweetcake.model.User;

@Controller
public class OrderController {

	@Autowired
	CartDao cartDao;
	@Autowired
	Cart cart;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	Orders orders;
	
	@Autowired 
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Product product;
	
	@Autowired
	User user;
	
	@Autowired 
	UserDao userDao;
	
	@RequestMapping("/buy")
	public String Buyall( Model model, HttpSession session)throws Exception
	{
		
			return "shippingaddress";
			
	}
	
	@RequestMapping("/buy/{p_Id}")
	public String Buy(@PathVariable("p_Id")String p_Id, Model model, HttpSession session)throws Exception
	{
		System.out.println(1+" "+p_Id);
		System.out.println(p_Id);
		product=(Product)productDao.get(p_Id);
		if(product==null)
		{
			System.out.println("sorry");
		}
		else
		{
			System.out.println("product="+product.getP_Name()+" "+product.getP_Price()+" "+product.getP_Quantity()+" "+product.getP_Description()+" "+product.getCategory()+" "+product.getSupplier()+" "+product.getImg());
		}
		session.setAttribute("pro", product);
//		model.addAttribute("buy", product);
//		model.addAttribute("pro1", this.productDao.list());
		return "shippingaddress";

//		return "index";
	}
	
//	@RequestMapping("/shipping/{p_Id}")
//	public ModelAndView Shipping(@PathVariable("p_Id")String p_Id)
//	{    System.out.println(1);
//		ModelAndView obj= new ModelAndView("shippingaddress");
//		Product product= productDao.get(p_Id);
////		product=(Product)productDao.get(p_Id);
//		return obj;
//	}
	
	@RequestMapping("/BillingAddress")
	public ModelAndView Billing(@RequestParam("ShippingAddress")String sa)
	{
		ModelAndView obj= new ModelAndView("billingaddress");
		orders.setS_address(sa);
		return obj;
	}
	
	@RequestMapping("/payment")
	public ModelAndView Payment(@RequestParam("BillingAddress")String sa)
	{
		ModelAndView obj= new ModelAndView("payment");
		orders.setB_address(sa);
		return obj;
	}
	
	@RequestMapping("/confirmorder")
	public ModelAndView ConfirmOrder(@RequestParam("optradio")String sa, HttpSession s)
	{
		ModelAndView obj= new ModelAndView("checkout1");
        
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currentUserName= authentication.getName();
			user=(User)userDao.getByEmailId(currentUserName);
			
			if(s.getAttribute("pro")==null)
			{
				
				cart=cartDao.get(user.getUserId());
				List<CartItems> lis=cartItemsDao.get(cart.getCart_Id());
				for(CartItems l:lis)
				{
					Orders o=new Orders();
				  	o.setPayment(sa);
					o.setUserid(user.getUserId());
					o.setTotalprice(l.getTotalprice());
					o.setP_Id(l.getP_Id());
					o.setB_address(orders.getB_address());
					o.setS_address(orders.getS_address());
					System.out.println(o.getP_Id());
					orderDao.saveorupdate(o);
					CartItems caI=l;
					cartItemsDao.delete(caI);
					
				}
				cart.setGrandtotal("0.0");
				cartDao.saveorupdate(cart);
				obj.addObject("l",lis);
				
			}
			else
			{
				orders.setPayment(sa);
				orders.setUserid(user.getUserId());
				orders.setP_Id(product.getP_Id());
				orders.setTotalprice(product.getP_Price());
				orders.setOrder_Id(orders.getOrder_Id());
				orders.setB_address(orders.getB_address());
				orders.setS_address(orders.getS_address());
				
				if(orderDao.saveorupdate(orders)==true)
				{ 
//					orders.setP_Id(product.getP_Id());
//					orderDao.saveorupdate(orders);
					obj.addObject("l",orders);
					System.out.println("Web flow is completed");
					return obj;
				}
			}
//		s.invalidate();	
		}
		if(user==null)
		{
			System.out.println("Sorry i am not coming");
		}
		return obj;
		
	}
	
	
	@RequestMapping("/cancel")
	public ModelAndView cancel()
	{
		ModelAndView obj= new ModelAndView("redirect:"+"/");
		return obj;
	}
	
	
}
