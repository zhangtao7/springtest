package com.springtest.chapter3.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {DevelopEenProfileConfig.class,ProductEnvProfileConfig.class,ProfileConfig.class})
@ActiveProfiles("pro")
public class ProfileTest {

	@Test
	public void  createDataSource() {
		
	}
}
