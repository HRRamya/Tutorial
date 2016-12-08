package com.niit.sweetcakebackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sweetcake.dao.SupplierDao;
import com.niit.sweetcake.model.Supplier;

public class SupplierTest 
{
 public static void main(String a[])
 {
	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	 context.scan("com.niit.*");
	 context.refresh();
	 
	 SupplierDao supplierDao  =(SupplierDao )context.getBean("supplierDao");
	 Supplier  supplier=(Supplier)context.getBean("supplier");
	   System.out.println(1);
	   
       supplier.setS_Id("hdmk568");
	   supplier.setS_Name("sdjf");
	   supplier.setS_Address("Bangalore");
	   supplier.setS_Phoneno("9857463214");
	   
	   supplierDao.saveorupdate(supplier);
	   System.out.println(2);
	   
	   if(supplierDao.saveorupdate(supplier)==true)
		{
			System.out.println(3);
			System.out.println("saved");
		}
	   else
		{
			System.out.println(4);
			System.out.println("sorry");
		}
	   
//        if(supplierdetailsDao.delete("jfj87")==true)
//        {
//        	System.out.println("done");
//        }
//        else
//        {
//        	System.out.println("sorry");
//        }

     Supplier l1= (Supplier)supplierDao.get("hdmk568");
     if(l1==null)
     {
    	 System.out.println("there is no record found");
     }
     else
     {
    	 System.out.println(l1.getS_Id()+l1.getS_Name()+l1.getS_Address());
     }
     
     List<Supplier> lsupplier=(List<Supplier>) supplierDao.list();
     if(lsupplier==null || lsupplier.isEmpty())
		{
			System.out.println("no data found");
		}
     else
     {
    	 for(Supplier p:lsupplier)
    	 {
    		 System.out.println(p.getS_Id());
    		 System.out.println(p.getS_Name());
    		 System.out.println(p.getS_Phoneno());
    		 System.out.println(p.getS_Address());
    	 }
    		 
     }
 }
}
