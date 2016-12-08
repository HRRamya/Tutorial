package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.CartItemsDao;
import com.niit.sweetcake.model.Cart;
import com.niit.sweetcake.model.CartItems;

@Repository("cartitemsDao")
@EnableTransactionManagement
public class CartItemsDaoImpl implements CartItemsDao{
	@Autowired
	private SessionFactory sessionFactory;

	public CartItemsDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public boolean save(CartItems cartitems) {
		System.out.println("yes");
		try {
			
			System.out.println("yes");
			System.out.println(cartitems.getCartitems_Id());
//			System.out.println(cartitems.getCart_Id());
//			System.out.println(cartitems.getUserId());
			System.out.println(cartitems.getP_Id());
			System.out.println(cartitems.getQuantity());
			System.out.println(cartitems.getTotalprice());
			
			sessionFactory.getCurrentSession().save(cartitems);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().delete(cartItems);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<CartItems> get(String cart_Id) {
			String hql="from CartItems where cart_Id='" + cart_Id+ "'";
			 Query q=sessionFactory.getCurrentSession().createQuery(hql);
			 List<CartItems> l1=(List<CartItems>)q.list();
			 if(l1==null || l1.isEmpty())
			   {
				   return null;
			   }
			   else
			   {
				   return l1;
			   }
		
	}

	@Transactional
	public List<CartItems> list() {
		 List<CartItems> cartitems = (List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return cartitems;
	}


	@Transactional
	public boolean prodelete(CartItems cartItems) {
		try {

			sessionFactory.getCurrentSession().delete(cartItems);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public CartItems getbyCartItems(String id)
	{
		String hql="from CartItems where cartitems_Id='" + id+ "'";
		 Query q=sessionFactory.getCurrentSession().createQuery(hql);
		List <CartItems> l1=(List<CartItems>)q.list();
		 if(l1==null)
		   {
			   return null;
		   }
		   else
		   {
			   return l1.get(0);
		   }
	}
	
	
}
