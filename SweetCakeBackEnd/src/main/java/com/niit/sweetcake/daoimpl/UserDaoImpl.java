package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.model.User;

@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{

@Autowired
private SessionFactory sessionFactory;
 
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(User user)
	{
		try
		{
			System.out.println("yes");
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
			System.out.println(user.getAddress());
			System.out.println(user.getEmailId());
			System.out.println(user.getMobile());
			System.out.println(user.getPassword());
			
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String userId) {
		// TODO Auto-generated method stub
		try
		{ 
			User obj=new User();
			obj.setUserId(userId);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		}
		
		catch(HibernateException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	 @Transactional
	    public User get(String userId)
	    {
	    	String hql="from User where USERID='" +userId+ "'";
	    	 Query q=sessionFactory.getCurrentSession().createQuery(hql);
	    	 List<User> l1=(List<User>)q.list();
	    	 if(l1==null || l1.isEmpty())
	    	   {
	    		   return null;
	    	   }
	    	   else
	    	   {
	    		   return l1.get(0);
	    	   }
	    }
	    
	    @Transactional
	    public List<User> list()
	    {
	    	List<User> user = (List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	 	   return user;
	    }
	    
	    @Transactional
	    public User isvalidate(String emailId,String password)
	    {
	    	String hql="from User where EMAILID='" +emailId + "' and password='" +password+ "'";
	    	Query q=sessionFactory.getCurrentSession().createQuery(hql);
	    	 List<User> l1=(List<User>)q.list();
	    	 if(l1==null || l1.isEmpty())
	  	   {
	  		   return null;
	  	   }
	  	   else
	  	   {
	  		   return l1.get(0);
	  	   }
	    }

		@Transactional
		public User getByEmailId(String emailId) {
			String hql="from User where emailId='" +emailId+ "'";
	    	 Query q=sessionFactory.getCurrentSession().createQuery(hql);
	    	 List<User> l1=(List<User>)q.list();
	    	 if(l1==null || l1.isEmpty())
	    	   {
	    		   return null;
	    	   }
	    	   else
	    	   {
	    		   return l1.get(0);
	    	   }
		}

}


