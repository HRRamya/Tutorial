package com.niit.sweetcakebackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.model.Category;
import com.niit.sweetcake.model.Product;
import com.niit.sweetcake.model.Supplier;

public class ProductTest {
	
	public static void main(String a[])
	   {
		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			
			ProductDao productDao=(ProductDao)context.getBean("productDao");
			Product product=(Product)context.getBean("product");
			System.out.println(1);
			
			Category obj= new Category();
			obj.setC_Id("1");
			
			Supplier obj1= new Supplier();
			obj1.setS_Id("1");
			
			product.setP_Id("hjy54");
			product.setP_Name("jack");
			product.setP_Price(35871);
			product.setP_Quantity(3);
			product.setP_Description("welcome");
			product.setCategory(obj);
			product.setSupplier(obj1);
			System.out.println(2);
			
			if(productDao.saveorupdate(product)==true)
			{
				System.out.println(3);
				System.out.println("saved");
			}
			else
			{
				System.out.println(4);
				System.out.println("sorry");
			}
			
//			if(productDao.delete("hdhhh1022")==true)
//			{
//				System.out.println("done");
//			}
//			else
//			{
//				System.out.println("sorry");
//			}
			
			
			
			
//			
//			Product l1 = (Product)productDao.get("hdhhh1022");
//			if(l1==null)
//			{
//				System.out.println("there is no record found");
//			}
//			else
//			{
//				System.out.println(l1.getCategory_id()+l1.getProduct_id()+l1.getSupplier_id()+l1.getProduct_name());
//			}
//			
			
			List<Product> lproduct=(List<Product>) productDao.list();
			if(lproduct==null || lproduct.isEmpty())
			{
				System.out.println("no data found");
			}
			else
			{
				for(Product p:lproduct)
				{
					System.out.println(p.getP_Id());
					System.out.println(p.getP_Name());
					System.out.println(p.getP_Price());
					System.out.println(p.getP_Description());
					System.out.println(p.getP_Quantity());
//					System.out.println(p.getSupplier_id());
//					System.out.println(p.getCategory_id());
					
					
				}
			}
	   }
		


}
