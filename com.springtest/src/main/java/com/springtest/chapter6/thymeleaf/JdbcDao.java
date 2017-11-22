package com.springtest.chapter6.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDao {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<User> queryUser(int type){
		logger.info(">>>>>>>enter dao>>>>>>>>");
		final List<User> list=new ArrayList<>();
		final String sql="select * from test";
		jdbcTemplate.query(sql, new Object[] {}, (rs)->{
			User user=new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("uname"));
			
			list.add(user);
		});
		return list;
	}
}
