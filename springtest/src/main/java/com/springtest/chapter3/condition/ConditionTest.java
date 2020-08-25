package com.springtest.chapter3.condition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MagicBeanConfig.class)
public class ConditionTest {

	
	@Test
	public void testCreateBeanByCondition() {
		//System.setProperty("env", "123");
	}
}
