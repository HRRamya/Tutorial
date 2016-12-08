package com.niit.sweetcake.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.sweetcake.dao.BillingDao;
import com.niit.sweetcake.dao.CartDao;
import com.niit.sweetcake.dao.CartItemsDao;
import com.niit.sweetcake.dao.CategoryDao;
import com.niit.sweetcake.dao.CustomerDao;
import com.niit.sweetcake.dao.OrderDao;
import com.niit.sweetcake.dao.ProductDao;
import com.niit.sweetcake.dao.RoleDao;
import com.niit.sweetcake.dao.ShippingDao;
import com.niit.sweetcake.dao.SupplierDao;
import com.niit.sweetcake.dao.UserDao;
import com.niit.sweetcake.daoimpl.BillingDaoImpl;
import com.niit.sweetcake.daoimpl.CartDaoImpl;
import com.niit.sweetcake.daoimpl.CartItemsDaoImpl;
import com.niit.sweetcake.daoimpl.CategoryDaoImpl;
import com.niit.sweetcake.daoimpl.CustomerDaoImpl;
import com.niit.sweetcake.daoimpl.OrderDaoImpl;
import com.niit.sweetcake.daoimpl.ProductDaoImpl;
import com.niit.sweetcake.daoimpl.RoleDaoImpl;
import com.niit.sweetcake.daoimpl.ShippingDaoImpl;
import com.niit.sweetcake.daoimpl.SupplierDaoImpl;
import com.niit.sweetcake.daoimpl.UserDaoImpl;


@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(" jdbc:h2:tcp://localhost/~/cakedb");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("hibernate.connection.pool_size", "10");
		connectionProperties.setProperty("hibernate.hbm2ddl.auto","create_update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect");
		return dataSource;
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.User.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Product.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Category.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Supplier.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Role.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Cart.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.CartItems.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Customer.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Billing.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Shipping.class);
		sessionBuilder.addAnnotatedClass(com.niit.sweetcake.model.Orders.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transcationManager")
	public HibernateTransactionManager getTranscationManager(SessionFactory sessionFactory){
		HibernateTransactionManager transcationManager = new HibernateTransactionManager(sessionFactory);
		return transcationManager;
	}
	@Autowired
	@Bean(name="userDao")
	public UserDao User(SessionFactory sessionFactory){
		return new UserDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDao Category(SessionFactory sessionFactory){
		return new CategoryDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name="supplierDao")
	public SupplierDao Supplier(SessionFactory sessionFactory){
		return new SupplierDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="productDao")
	public ProductDao Product(SessionFactory sessionFactory){
		return new ProductDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="roleDao")
	public RoleDao Role(SessionFactory sessionFactory){
		return new RoleDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="cartDao")
	public CartDao Cart(SessionFactory sessionFactory){
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="cartitemsDao")
	public CartItemsDao CartItems(SessionFactory sessionFactory){
		return new CartItemsDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="customerDao")
	public CustomerDao Customer(SessionFactory sessionFactory){
		return new CustomerDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="billingDao")
	public BillingDao Billing(SessionFactory sessionFactory){
		return new BillingDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="shippingDao")
	public ShippingDao Shipping(SessionFactory sessionFactory){
		return new ShippingDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="orderDao")
	public OrderDao Orders(SessionFactory sessionFactory){
		return new OrderDaoImpl(sessionFactory);
	}
	
}
