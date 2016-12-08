//package com.niit.sweetcakebackend;
//
//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.sweetcake.dao.RoleDao;
//import com.niit.sweetcake.model.Role;
//
//
//public class RoleTest {
//
//	
//	public static void main(String a[])
//	   {
//		   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//			context.scan("com.niit.*");
//			context.refresh();
//			
//			RoleDao roleDao=(RoleDao)context.getBean("roleDao");
//			Role role=(Role)context.getBean("role");
//			System.out.println(1);
//		
//			
//			role.setRole_Id("dsjkfhnsd");
//			role.setRole_Name("jfdb");
//			role.setUserName("sdfbh");
//			
//			System.out.println(2);
//			
//			if(roleDao.saveorupdate(role)==true)
//			{
//				System.out.println(3);
//				System.out.println("saved");
//			}
//			else
//			{
//				System.out.println(4);
//				System.out.println("sorry");
//			}
//			
////			if(roleDao.delete("hdhhh1022")==true)
////			{
////				System.out.println("done");
////			}
////			else
////			{
////				System.out.println("sorry");
////			}
//			
//			
//			
//			
////			
////			Role l1 = (Role)roleDao.get("hdhhh1022");
////			if(l1==null)
////			{
////				System.out.println("there is no record found");
////			}
////			else
////			{
////				System.out.println(l1.getRole_Id()+l1.getRole_Name()+l1.getUserName());
////			}
////			
//			
//			List<Role> lrole=(List<Role>) roleDao.list();
//			if(lrole==null || lrole.isEmpty())
//			{
//				System.out.println("no data found");
//			}
//			else
//			{
//				for(Role p:lrole)
//				{
//					System.out.println(p.getRole_Id());
//					System.out.println(p.getRole_Name());
//					System.out.println(p.getUserName());
//								
//				}
//			}
//	   }
//		
//
//}
