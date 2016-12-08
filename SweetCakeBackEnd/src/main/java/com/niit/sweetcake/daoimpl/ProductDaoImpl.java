package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.model.Category;
import com.niit.sweetcake.model.Product;

@Repository("productDao")
@EnableTransactionManagement

public class ProductDaoImpl implements ProductDao{

	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
    public boolean saveorupdate(Product product)
    {
    	
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	
		} 
    }
	@Transactional
    public boolean delete(String p_Id)
    
	{
    	try {
			Product obj=new Product();
			obj.setP_Id(p_Id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }
    
   @Transactional
   public Product get(String p_Id)
   {
	   String hql="from Product where P_ID='" +p_Id+ "'";
	   Query q=sessionFactory.getCurrentSession().createQuery(hql);
	   List<Product> l1=(List<Product>)q.list();
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
   public List<Product> list()
   {
	   List<Product> product = (List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return product;
   }
   
   @Transactional
   public void editProduct(Product product) {
   	Session session=sessionFactory.openSession();
   	//update product set ....where isbn=?
   	session.update(product);
   	session.flush();
   	session.close();
   }
}


