package com.springtest.chapter4.one;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AspectConfig.class})
public class AspectTest {

	@Autowired
	private HelloService helloService;
	
	@Test
	public void testAspect() {
		helloService.sayHello();
		
		helloService.caculate(4, 5);
	}
}
