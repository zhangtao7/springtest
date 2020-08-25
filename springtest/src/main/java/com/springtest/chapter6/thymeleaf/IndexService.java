package com.springtest.chapter6.thymeleaf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
	Logger logger=LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcDao jdbcDao;
	
	@Cacheable(value="test")
	public List<User> queryUser(int type){
		logger.info(">>>>>>>enter service>>>>>>>>");
		List<User> list=jdbcDao.queryUser(type);
		return list;
	}
}
