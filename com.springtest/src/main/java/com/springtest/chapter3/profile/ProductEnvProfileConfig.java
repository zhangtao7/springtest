package com.springtest.chapter3.profile;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("pro")
public class ProductEnvProfileConfig {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Bean
	public DataSource jndiDataSource() {
		logger.info(">>>>>>>>>product crate>>>>>>>>>>>>");
		return null;
	}
}
