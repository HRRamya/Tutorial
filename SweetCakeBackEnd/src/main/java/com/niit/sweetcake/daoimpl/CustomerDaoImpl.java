package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.CustomerDao;
import com.niit.sweetcake.model.Cart;
import com.niit.sweetcake.model.Customer;

@Repository("customerDao")
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CustomerDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Customer customer) {
		System.out.println("yes");
		try {

			System.out.println("yes");
			System.out.println(customer.getCustomer_Id());
			System.out.println(customer.getCustomer_Name());
			sessionFactory.getCurrentSession().save(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String customer_Id)
	{
		try {
			Customer obj=new Customer();
		obj.setCustomer_Id(customer_Id);
		sessionFactory.getCurrentSession().delete(obj);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}

	@Transactional
	public Customer get(String userId) {
		String hql="from Customer where userId='" + userId+ "'";
		 Query q=sessionFactory.getCurrentSession().createQuery(hql);
		 List<Customer> l1=(List<Customer>)q.list();
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
	public List<Customer> list() {
		List<Customer> customer = (List<Customer>)sessionFactory.getCurrentSession().createCriteria(Customer.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return customer;
	}

	@Transactional
	public boolean update(Customer customer) {
		System.out.println("yes");
		try {

			System.out.println("yes");
			System.out.println(customer.getCustomer_Id());
			System.out.println(customer.getCustomer_Name());
			sessionFactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

