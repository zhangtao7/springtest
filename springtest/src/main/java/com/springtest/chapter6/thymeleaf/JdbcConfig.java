package com.springtest.chapter6.thymeleaf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class JdbcConfig {

	
	@Bean
	public JndiObjectFactoryBean dataSource() {
		JndiObjectFactoryBean jndi=new JndiObjectFactoryBean();
		jndi.setJndiName("jdbc/test");
		jndi.setProxyInterface(javax.sql.DataSource.class);
		jndi.setResourceRef(true);
		return jndi;
	}
	
	@Bean
	public JdbcTemplate tmplate(DataSource dataSource) {
		JdbcTemplate jdbc=new JdbcTemplate();
		jdbc.setDataSource(dataSource);
		return jdbc;
	}
}
