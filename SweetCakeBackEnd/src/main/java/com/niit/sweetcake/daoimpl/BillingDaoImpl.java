package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.BillingDao;
import com.niit.sweetcake.model.Billing;

public class BillingDaoImpl implements BillingDao{

	@Autowired
	private SessionFactory sessionFactory;

	public BillingDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public boolean save(Billing billing) {
		System.out.println("yes");
		try {
			
			System.out.println("yes");
			System.out.println(billing.getBilling_Id());
			
			sessionFactory.getCurrentSession().save(billing);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String billing_Id) {
		try {
			Billing obj=new Billing();
		obj.setBilling_Id(billing_Id);
		sessionFactory.getCurrentSession().delete(obj);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	}

	@Transactional
	public Billing get(String billing_Id) {
		String hql="from Billing where billing_Id='" + billing_Id+ "'";
		 Query q=sessionFactory.getCurrentSession().createQuery(hql);
		 List<Billing> l1=(List<Billing>)q.list();
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
	public List<Billing> list() {
		List<Billing> billing = (List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return billing;
	}

	@Transactional
	public boolean update(Billing billing) {
		System.out.println("yes");
		try {

			System.out.println("yes");
			System.out.println(billing.getBilling_Id());
			
			sessionFactory.getCurrentSession().update(billing);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
