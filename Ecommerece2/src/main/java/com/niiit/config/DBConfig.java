package com.niiit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niiit.model.Authorities;
import com.niiit.model.BillingAddress;
import com.niiit.model.Category;
import com.niiit.model.Customer;
import com.niiit.model.Product;
import com.niiit.model.ShippingAddress;
import com.niiit.model.Supplier;
import com.niiit.model.User;

@Configuration
@ComponentScan("com.niiit")
@EnableTransactionManagement
	
	public class DBConfig {
		@Bean(name = "dataSource")
		public DataSource getDataSource() {
		    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.h2.Driver");
		    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		    dataSource.setUsername("vaish");
		    dataSource.setPassword("");
		 
		    return dataSource;
		}
		
		private Properties getHibernateProperties() {
		    Properties properties = new Properties();
		    properties.put("hibernate.show_sql", "true");
		    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		    properties.put("hibernate.hbm2ddl.auto","update");
		    return properties;
		}
		
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
		 
		    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		    sessionBuilder.addProperties(getHibernateProperties());
		    sessionBuilder.scanPackages("com.niiit");
		    sessionBuilder.addAnnotatedClasses(Category.class);
		    sessionBuilder.addAnnotatedClasses(Customer.class);
		    sessionBuilder.addAnnotatedClasses(Product.class);
		    sessionBuilder.addAnnotatedClasses(Supplier.class);
		    sessionBuilder.addAnnotatedClasses(Authorities.class);
		    sessionBuilder.addAnnotatedClasses(BillingAddress.class);
		    sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
		    sessionBuilder.addAnnotatedClasses(User.class);
		    return sessionBuilder.buildSessionFactory();
		}
		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
		        SessionFactory sessionFactory) {
		    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
		            sessionFactory);
		 
		    return transactionManager;
		}
		
}
