package com.springtest.chapter3.profile;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevelopEenProfileConfig {

	Logger logger=LoggerFactory.getLogger(getClass());
	@Bean(destroyMethod="shutdown")
	public DataSource dataSource() {
		logger.info(">>>>>>>>>>develop create>>>>>>>>>");
//		return new EmbeddedDatabaseBuilder().
//				setType(EmbeddedDatabaseType.H2).build();
		return null;
		
	}
}
