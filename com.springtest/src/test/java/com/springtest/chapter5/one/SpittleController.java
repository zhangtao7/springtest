package com.springtest.chapter5.one;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpittleController {

	 private static  final String MAX_LONG_AS_STRING="1";//Long.toString(Long.MAX_VALUE);
	
	
	SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository SpittleRepository) {
		this.spittleRepository=SpittleRepository;
	}


	@RequestMapping("/spittles")
	public List<Spittle> findSpittlePage(@RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING) long max) {
		//model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		//return "spittles";
		
		return spittleRepository.findSpittles(max, 20);
	}
	
	
}
