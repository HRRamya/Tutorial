package com.niit.sweetcake.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.sweetcake.dao.RoleDao;
import com.niit.sweetcake.model.Product;
import com.niit.sweetcake.model.Role;
@Repository("roleDao")
@EnableTransactionManagement
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public RoleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Role role) {
		System.out.println("yes");
		try {
			System.out.println("yes");
			System.out.println("from role"+role.getENABLED()+" "+role.getROLE_ID()+" "+role.getROLE_USER()+" "+role.getUSERNAME());
			sessionFactory.getCurrentSession().save(role);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	
		} 
	}

	@Transactional
	public boolean delete(String role_Id) {
		try {
			Role obj=new Role();
			obj.setROLE_ID(role_Id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}

	@Transactional
	public Role get(String role_Id) {
		 String hql="from Role where role_ID='" +role_Id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Role> l1=(List<Role>)q.list();
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
	public List<Role> list() {
		 List<Role> role = (List<Role>)sessionFactory.getCurrentSession().createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return role;
	}
	
	

}
