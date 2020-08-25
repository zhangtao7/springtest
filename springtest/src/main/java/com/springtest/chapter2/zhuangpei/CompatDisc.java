package com.springtest.chapter2.zhuangpei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("myTest")
public class CompatDisc {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public void play() {
		logger.info(">>>>>play>>>");
	}
}
