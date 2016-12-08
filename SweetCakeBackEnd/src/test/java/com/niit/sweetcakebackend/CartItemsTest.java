//package com.niit.sweetcakebackend;
//
//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.sweetcake.dao.CartItemsDao;
//import com.niit.sweetcake.model.CartItems;
//
//public class CartItemsTest {
//
//	public static void main(String a[])
//	   {
//		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//		   context.scan("com.niit.*");
//		   context.refresh();
//		   
//		   CartItemsDao cartitemsDao =(CartItemsDao)context.getBean("cartitemsDao");
//		   CartItems cartitems=(CartItems)context.getBean("cartItems");
//		   System.out.println(1);
//		   
////		   categorydetails.setCategory_id("hu5685");
//		   cartitems.setCartitems_Id("dfjkh34");
////		   cartitems.setCart_Id("dfs23");
//		   cartitems.setP_Id("productA3A6D7");
////		   cartitems.setUserId("user5b25d2");
//		   cartitems.setQuantity(23);
//		   cartitems.setTotalprice(4354);
//		   System.out.println(2);
//		   
//		   if(cartitemsDao.saveorupdate(cartitems)==true)
//			{
//				System.out.println(3);
//				System.out.println("saved");
//			}
//		   else
//			{
//				System.out.println(4);
//				System.out.println("sorry");
//			}
//		   
////		   if(categoryDao.delete("hu5685")==true)
////		   {
////			   System.out.println("done");
//	//	
////		   }
////		   else
////		   {
////			   System.out.println("sorry");
////		   }
//		   
//		   CartItems l1= (CartItems)cartitemsDao.get("dfjkh34");
//		     if(l1==null)
//		     {
//		    	 System.out.println("there is no record found");
//		     }
//		     else
//		     {
//		    	 System.out.println(l1.getCartitems_Id()+l1.getCart_Id()+l1.getP_Id()+l1.getUserId()+l1.getQuantity()+l1.getTotalprice());
//		     }
//		 
//
//		     List<CartItems> lcartitems=(List<CartItems>) cartitemsDao.list();
//		     if(lcartitems==null || lcartitems.isEmpty())
//				{
//					System.out.println("no data found");
//				}
//		     else
//		     {
//		    	for(CartItems p:lcartitems)
//		    	 {
//		    		 System.out.println(p.getCartitems_Id());
//		    		 System.out.println(p.getCart_Id());
//		    		 System.out.println(p.getP_Id());
//		    		 System.out.println(p.getUserId());
//		    		 System.out.println(p.getQuantity());
//		    		 System.out.println(p.getTotalprice());
//		    	 }
//		     }
//	  }
//}
