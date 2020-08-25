package com.springtest.chapter5.one;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springtest.chapter6.thymeleaf.CacheConfig;
import com.springtest.chapter6.thymeleaf.IndexController;
import com.springtest.chapter6.thymeleaf.JdbcConfig;
import com.springtest.chapter6.thymeleaf.ThymeleafConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ImportResource("src/test/resources/context.xml")
@ContextConfiguration(classes= {ThymeleafConfig.class,CacheConfig.class,JdbcConfig.class}) 
public class IndexControllerTest {
	
	@Test
	public void indexTest() throws Exception {
		IndexController index=new IndexController();
		MockMvc mock=MockMvcBuilders.standaloneSetup(index).build();
		mock.perform(get("/")).andExpect(view().name("index"));
		
	}
}
