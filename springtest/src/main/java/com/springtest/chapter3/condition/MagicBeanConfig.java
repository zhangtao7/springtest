package com.springtest.chapter3.condition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")
public class MagicBeanConfig {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	
	@Bean
	@Conditional(value=MagicExistCondition.class)
	public MagicBean createMagicBean(@Value("#{T(java.lang.Math).PI}")String msg) {
		logger.info(">>>>>>>>create bean by condition>>>>>>>>>{}",msg);
		return null;
	}
}
