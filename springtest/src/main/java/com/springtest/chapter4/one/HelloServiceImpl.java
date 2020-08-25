package com.springtest.chapter4.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

	Logger log=LoggerFactory.getLogger(getClass());
	@Override
	public void sayHello() {
		log.info(">>>>>>>>>hello>>>>>>>>>");
	}
	@Override
	public int caculate(int a, int b) {
		int count=a+b;
		log.info(">>>>>>>>>caculate count is>>>>>>>>>{}",count);
		return count;
	}

}
