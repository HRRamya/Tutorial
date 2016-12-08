package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.ShippingDao;

import com.niit.sweetcake.model.Shipping;

@Repository("shippingDao")
@EnableTransactionManagement
public class ShippingDaoImpl implements ShippingDao{

	@Autowired
	private SessionFactory sessionFactory;

	public ShippingDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Shipping shipping) {
		System.out.println("yes");
		try {
			
			System.out.println("yes");
			System.out.println(shipping.getShipping_Id());
			
			sessionFactory.getCurrentSession().save(shipping);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String shipping_Id) {
		try {
			 Shipping obj=new Shipping();
		obj.setShipping_Id(shipping_Id);
		sessionFactory.getCurrentSession().delete(obj);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	}

	@Transactional
	public Shipping get(String shipping_Id) {
		String hql="from Shipping where shipping_Id='" + shipping_Id+ "'";
		 Query q=sessionFactory.getCurrentSession().createQuery(hql);
		 List<Shipping> l1=(List<Shipping>)q.list();
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
	public List<Shipping> list() {
		List<Shipping> shipping = (List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return shipping;
	}

	@Transactional
	public boolean update(Shipping shipping){
			System.out.println("yes");
			try {

				System.out.println("yes");
				System.out.println(shipping.getShipping_Id());
				
				sessionFactory.getCurrentSession().update(shipping);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

}
