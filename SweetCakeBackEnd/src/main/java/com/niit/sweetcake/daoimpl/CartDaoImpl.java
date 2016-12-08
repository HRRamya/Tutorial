package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.CartDao;
import com.niit.sweetcake.model.Cart;
import com.niit.sweetcake.model.CartItems;

@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(Cart cart) {
		System.out.println("yes");
		try {
			
			System.out.println("yes");
			System.out.println(cart.getCart_Id());
			System.out.println(cart.getUserId());
			System.out.println(cart.getGrandtotal());
			
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String cart_Id) {
		try {
			Cart obj=new Cart();
			obj.setCart_Id(cart_Id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart get(String userId) {
		String hql="from Cart where userId='" + userId+ "'";
		 Query q=sessionFactory.getCurrentSession().createQuery(hql);
		 List<Cart> l1=(List<Cart>)q.list();
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
	public List<Cart> list() {
		  List<Cart> cart = (List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return cart;
	}
	
	
}
