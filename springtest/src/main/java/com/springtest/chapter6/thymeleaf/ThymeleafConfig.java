package com.springtest.chapter6.thymeleaf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan("com.springtest.chapter6.thymeleaf")
@EnableWebMvc
//@ImportResource("classpath:bean.xml")
public class ThymeleafConfig implements WebMvcConfigurer,ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setCache(false);
		return viewResolver;
	}
	
	
	
	
	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine=new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(false);
		return templateResolver;
	}




	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}



	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}



	/**
	 * add interceptors
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(interceptor)
	}
	




	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean val=new LocalValidatorFactoryBean();
		val.setProviderClass(org.hibernate.validator.HibernateValidator.class);
		val.setValidationMessageSource(messageSource());
		return val;
	}




	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    //messageSource.setBasename("CustomValidationMessage");
	    messageSource.setBasenames("CustomValidationMessage");
	    messageSource.setUseCodeAsDefaultMessage(false);
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(5);
	    return messageSource;
	}
	
}
