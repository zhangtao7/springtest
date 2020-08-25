package com.springtest.chapter4.one;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfig {

	@Bean
	public AspectBean getBean() {
		
		return new AspectBean();
	}
}
