package com.springtest.chapter5.one;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class HomeControllerTest {

	
	@Test
	public void testHomePage() throws Exception {
		HomeController controller=new HomeController();
		MockMvc mvc=standaloneSetup(controller).build();
		mvc.perform(get("/")).
		andExpect(view().name("home"));
		
		mvc.perform(get("/homepage")).andExpect(view().name("home"));
	}
	
	
	
	
	
	@Test
	public void showRecentSpittles() throws Exception {
		List<Spittle> list=this.createSpittle(20);
		SpittleRepository repository=mock(SpittleRepository.class);
		when(repository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(list);
		
		SpittleController controller=new SpittleController(repository);
		
		MockMvc mvc=standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittle.jsp")).build();
		mvc.perform(get("/spittles")).andExpect(view().name("spittles")).
		andExpect(model().attributeExists("spittleList")).andExpect(model().attribute("spittleList", hasItems(list.toArray())))
		;
	}
	
	private List<Spittle> createSpittle(int count){
		List<Spittle> list=new ArrayList<>(count);
		for(int i=0;i<count;i++) {
			list.add(new Spittle(i,"msg>>"+i,new Date()));
		}
		return list;
	}
}
