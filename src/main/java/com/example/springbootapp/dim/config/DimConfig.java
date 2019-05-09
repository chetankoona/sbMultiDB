package com.example.springbootapp.dim.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "dimEntityManagerFactory", transactionManagerRef = "dimTransactionManager", basePackages = {
		"com.example.springbootapp.dim.repository" })
public class DimConfig {

	@Bean(name = "dimDataSource")
	@ConfigurationProperties(prefix = "spring.second.datasource")
	public DataSource dimDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "dimEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean dimEntityManagerFactory(@Qualifier("dimDataSource") DataSource dimDataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dimDataSource).packages("com.example.springbootapp.dim.entity").persistenceUnit("dim")
				.build();
	}

	@Bean(name = "dimTransactionManager")
	public PlatformTransactionManager dimTransactionManager(
			@Qualifier("dimEntityManagerFactory") EntityManagerFactory dimEntityManagerFactory) {
		return new JpaTransactionManager(dimEntityManagerFactory);
	}

}
