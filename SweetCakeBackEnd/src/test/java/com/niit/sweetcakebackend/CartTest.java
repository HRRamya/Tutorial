package com.niit.sweetcakebackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

public class CartTest {

	public static void main(String a[])
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		   context.scan("com.niit.*");
		   context.refresh();
		   
		   CartDao cartDao =(CartDao)context.getBean("cartDao");
		   Cart cart=(Cart)context.getBean("cart");
		   CartItemsDao cartitemsDao =(CartItemsDao)context.getBean("cartitemsDao");
		   CartItems cartitems =(CartItems)context.getBean("cartItems");
		   ProductDao productDao =(ProductDao)context.getBean("productDao");
		   Product product =(Product)context.getBean("product");
		   CustomerDao customerDao =(CustomerDao)context.getBean("customerDao");
		   Customer customer =(Customer)context.getBean("customer");
		   
		   
		   System.out.println(1);
		   
		   Cart c=(Cart)cartDao.get("customerF525BE");
		      if(c==null)
		      {
		    	  System.out.println("cart is not there");
		      }
		      else
		      {
		    	  Product p= (Product)productDao.get("productA3A6D7");
				   System.out.println(p.getP_Name());
				   cartitems.setP_Id(p.getP_Id());
				   cartitems.setQuantity(4);
				  cartitems.setCart(c);
				  cartitems.setCartitems_Id("fdds3e23");
				   cartitems.setTotalprice(cartitems.getQuantity()*p.getP_Price());
				  // cart.setGrandtotal(cart.getGrandtotal()+cartitems.getTotalprice());
	
				  
				if(cartitemsDao.save(cartitems)==true)
				{
					String g=c.getGrandtotal();
					double t=cartitems.getTotalprice();
					
					double gt=Double.parseDouble(g);
					gt=gt+t;
					
					String gt1=String.valueOf(gt);
					c.setGrandtotal(gt1);
					if(cartDao.saveorupdate(c)==true)
						System.out.println("Cart is updated");
					System.out.println("Items is added to list");
				} 
		      }
		   
		   
		   
		
//		List<CartItems> list=(List<CartItems>)cartitemsDao.get("snfk346");// i hv to pass existing cartid
//		for(CartItems list1: list)
//		{
//			System.out.println(list1.getCart_Id());
//			System.out.println(list1.getCartitems_Id());
//			System.out.println(list1.getP_Id());
//			System.out.println(list1.getUserId());
//			System.out.println(list1.getQuantity());
//			System.out.println(list1.getTotalprice());
//		}
	   }
}
