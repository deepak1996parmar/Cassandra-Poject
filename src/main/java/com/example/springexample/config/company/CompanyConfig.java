package com.example.springexample.config.company;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
 entityManagerFactoryRef="entityManagerFactory2",
 basePackages=("com.example.springexample.companyRepo"),
 transactionManagerRef="bookTransactionManager")
public class CompanyConfig {

	@Bean(name="companydetails")
	@ConfigurationProperties(prefix="spring.book.datasource")
	public DataSource datasource(){
	return DataSourceBuilder.create().build();
	}


	@Bean(name="entityManagerFactory2")
	public LocalContainerEntityManagerFactoryBean localContainerEntityFactoryBean(
		EntityManagerFactoryBuilder builder,@Qualifier("companydetails")DataSource dataSource){
	
	Map<String,Object> properties=new HashMap<>();
	properties.put("hibernate.hbm2ddl.auto","update");
	properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
	
	return builder.dataSource(dataSource).properties(properties).
				packages("com.example.springexample.model.company").persistenceUnit("Company").build(); 
 	}
	
	@Bean(name="bookTransactionManager")
	public PlatformTransactionManager transctionManager(
			@Qualifier("entityManagerFactory2")EntityManagerFactory entityManagerFactory){
	
	return new JpaTransactionManager(entityManagerFactory);
	}
}