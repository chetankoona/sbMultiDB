package com.example.springbootapp.fact.config;

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
@EnableJpaRepositories(entityManagerFactoryRef = "factEntityManagerFactory", transactionManagerRef = "factTransactionManager", basePackages = {
		"com.example.springbootapp.fact.repository" })
public class FactConfig {

	@Primary
	@Bean(name = "factDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource factDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "factEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean factEntityManagerFactory(@Qualifier("factDataSource") DataSource factDataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(factDataSource).packages("com.example.springbootapp.fact.entity").persistenceUnit("fact")
				.build();
	}

	@Primary
	@Bean(name = "factTransactionManager")
	public PlatformTransactionManager factTransactionManager(
			@Qualifier("factEntityManagerFactory") EntityManagerFactory factEntityManagerFactory) {
		return new JpaTransactionManager(factEntityManagerFactory);
	}

}
