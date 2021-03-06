package com.niit.skillmapper.config;

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

import com.niit.skillmapper.model.*;

@Configuration
@ComponentScan(basePackages = "com.niit.skillmapper")
@EnableTransactionManagement
public class HibernateConfiguration {

	/*
	 * 
	 * Select H2 Generic Server in H2 data base than you'll get the your Driver
	 * class will available in H2 console
	 * 
	 * 
	 */
	private final static String h2_URL = "jdbc:h2:~/skillmapper";
	//private final static String h2_URL = "jdbc:h2:~/skillmapperDB";
	private final static String h2_DRIVER_CLASS = "org.h2.Driver";
	private final static String h2_userName = "sa";
	private final static String h2_password = "";
	private final static String h2_dailect = "org.hibernate.dialect.H2Dialect";

	/*
	 * it'll retrun the sessionFactory Object
	 */

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(hibernateProperties());
		builder.scanPackages("com.niit.skillmapper");
		builder.addAnnotatedClass(Employee.class);
		builder.addAnnotatedClass(Role.class);
		builder.addAnnotatedClass(Skill.class);
		builder.addAnnotatedClass(Certification.class);

		//
		return builder.buildSessionFactory();
	}

	/*
	 * it'll give the DataSource object to SessionFactory
	 */

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(h2_DRIVER_CLASS);
		dataSource.setUrl(h2_URL);
		dataSource.setUsername(h2_userName);
		dataSource.setPassword(h2_password);
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.lazy", "false");
		return properties;
	}

	/*
	 * it's responsible to manage all type of transactions
	 */

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		System.out.println("Transaction");
		return txManager;
	}
}
