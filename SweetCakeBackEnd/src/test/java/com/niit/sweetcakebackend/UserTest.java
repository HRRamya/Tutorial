package com.niit.sweetcakebackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sweetcake.dao.RoleDao;
import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.model.Role;
import com.niit.sweetcake.model.User;

public class UserTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		UserDao userDao =(UserDao)context.getBean("userDao");
		  User  user=(User)context.getBean("user");
		  RoleDao roleDao=(RoleDao)context.getBean("roleDao");  
		  Role  role=(Role)context.getBean("role");
		  
		  System.out.println(1);
		  user.setUserName("dfshkj");
		  user.setAddress("sfbsdakbkj");
		  user.setEmailId("dsf@gmail.com");
		  user.setMobile("123456789");
		  user.setPassword("fbsdah");
		  userDao.saveorupdate(user);
		  
		  
		  if(userDao.saveorupdate(user)==true)
				{
			        
			        role.setUSERNAME(user.getEmailId());
			       // role.setROLE_USER("ROLE_USER");
			       // role.setEnabled("true");
			        if(roleDao.save(role)==true)
			        {	
					System.out.println(3);
					System.out.println("saved");
			        }
				}
			   else
				{
					System.out.println(4);
					System.out.println("sorry");
				}
			  
			  if(userDao.delete("hgf345")==true)
				   {
					   System.out.println("done");
				
				   }
				   else
				   {
					   System.out.println("sorry");
				   }
			  
			  User l1= (User)userDao.get("hgf345");
			     if(l1==null)
			     {
			    	 System.out.println("there is no record found");
			     }
			     else
			     {
			    	 System.out.println("record found");
			     }
			     
			     
			     List<User> luser=(List<User>) userDao.list();
			     if(luser==null || luser.isEmpty())
					{
						System.out.println("no data found");
					}
			     else
			     {
			    	 for(User p:luser)
			    	 {
			    		 System.out.println(p.getUserId());
			    		 System.out.println(p.getUserName());
			    		 System.out.println(p.getEmailId());
			    		 System.out.println(p.getAddress());
			    		 System.out.println(p.getMobile());
			    	     System.out.println("admin");
			    		 System.out.println(p.getPassword());
			    		 System.out.println(p.getRolename());
			    		
			    		 
			    	 }
			     }
			     
			     
			     User l=(User)userDao.isvalidate("dsf@gmail.com", "fbsdah");
			     if(l==null)
			     {
			    	 System.out.println("user is not found");
			     }
			     else
			     {
			    	if(l.getRolename()=="ROLE_ADMIN") System.out.println("welcome Admin");
			    	if(l.getRolename()=="ROLE_USER")System.out.println("welcome User");
			     }
		  }
	}


