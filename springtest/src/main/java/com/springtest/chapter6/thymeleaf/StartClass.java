package com.springtest.chapter6.thymeleaf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StartClass extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ThymeleafConfig.class,CacheConfig.class,JdbcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
	}

	
	
	@Override
	protected String getServletName() {
		// TODO Auto-generated method stub
		return super.getServletName();
	}

	/**
	 * add filter
	 */
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return super.getServletFilters();
	}

	/**
	 * 注册servlet or filter
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	
	
}
