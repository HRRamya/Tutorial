package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.OrderDao;
import com.niit.sweetcake.model.Orders;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(Orders orders) {
		System.out.println("yes");
		try {
			
			System.out.println("yes");
			System.out.println(orders.getOrder_Id());
			System.out.println(orders.getP_Id());
			System.out.println(orders.getB_address());
			System.out.println(orders.getUserid());
			System.out.println(orders.getS_address());
			sessionFactory.getCurrentSession().saveOrUpdate(orders);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String userid) {
		try {
			Orders obj=new Orders();
			obj.setUserid(userid);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Orders get(String userid) {
		String hql="from Orders where userid='" + userid+ "'";
		 Query q=sessionFactory.getCurrentSession().createQuery(hql);
		 List<Orders> l1=(List<Orders>)q.list();
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
	public List<Orders> list() {
		List<Orders> orders = (List<Orders>)sessionFactory.getCurrentSession().createCriteria(Orders.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return orders;
	}

}
