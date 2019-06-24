package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.model.Employee;

@Configuration
@EnableTransactionManagement
@PropertySource("application.properties")
@ComponentScan("com.app")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		ds.setMaxTotal(10);
		ds.setMinIdle(5);
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(dsObj());
		sf.setAnnotatedClasses(Employee.class);
		sf.setHibernateProperties(props());
		return sf;
	}

	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql", env.getProperty("showsql"));
		p.put("hibernate.format_sql", env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return p;
	}

	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}

	@Bean
	public HibernateTransactionManager htm()
	{
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sf().getObject());
		return htm;
	}

}
