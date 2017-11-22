package com.springtest.chapter3.profile;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class ProfileConfig {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	
	@Bean
	@Profile("dev")
	public DataSource getDataSourceDev() {
		logger.info(">>>>>>>>create Dev>>>>>>>>");
		return null;
	}
	
	@Bean
	@Profile("pro")
	public DataSource getDataSourcePro() {
		logger.info(">>>>>>>>create Pro>>>>>>>>");
		return null;
	}
}
