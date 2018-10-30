package com.springtest.chapter4.one;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectBean {

	Logger log=LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(** com.springtest.chapter4.one.HelloServiceImpl.*(..))")
	public void pointcut() {}
	
	
	@Pointcut("execution(int com.springtest.chapter4.one.HelloServiceImpl.*(..))")
	public void pointcut2() {
		
	}
	@Before("pointcut()")
	public void before() {
		log.info(">>>>>before point before>>>>>>>>>>");
	}
	
	@After("pointcut2()")
	public void after() {
		log.info(">>>after pointcut2>>>>>");
	}
}