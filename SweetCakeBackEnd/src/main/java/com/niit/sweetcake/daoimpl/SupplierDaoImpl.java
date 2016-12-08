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

import com.niit.sweetcake.dao.SupplierDao;

import com.niit.sweetcake.model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
public class SupplierDaoImpl implements SupplierDao{
    @Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(Supplier supplier)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			System.out.println(supplier.getS_Id());
			System.out.println(supplier.getS_Name());
			System.out.println(supplier.getS_Phoneno());
			System.out.println(supplier.getS_Address());
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	@Transactional
	public boolean delete(String s_Id)
	{
		try {
			Supplier obj=new Supplier();
			obj.setS_Id(s_Id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public Supplier get(String s_Id)
	{
		   String hql="from Supplier where S_ID='" +s_Id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Supplier> l1=(List<Supplier>)q.list();
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
	public List<Supplier> list()
	{
		   List<Supplier> supplier = (List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return supplier;
	}
	
	@Transactional
	public void editSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
		//update product set ....where isbn=?
		session.update(supplier);
		session.flush();
		session.close();
	}

	@Transactional
	public void edit(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		//update product set ....where isbn=?
		session.update(supplier);
		session.flush();
		//	session.getTransaction().commit();
		session.close();
	}
}

