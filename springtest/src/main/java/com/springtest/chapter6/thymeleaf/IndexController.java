package com.springtest.chapter6.thymeleaf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IndexService indexService;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "aaa");
		List<User> list=indexService.queryUser(1);
		logger.info(">>>>>>size>>>{}",list.size());
		return "index";
	}
	
	@RequestMapping("/getException")
	public String getException(Model model) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>enter method>>>>>>>>>>");
		int a=11;
		int b=0;
		//int c=a/b;
		return "home";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@Valid User bean,BindingResult errors) {
		logger.info(">>>>>>>.sssssssssssss>>>>>>>>>{}",bean.toString());
		List<ObjectError> list=errors.getAllErrors();
		for(ObjectError error:list) {
			logger.info(">>>>>>>error msg>>{}",error.getDefaultMessage());
		}
		return "home";
	}
	
	@RequestMapping("/editItem")
	@ResponseBody
	public String editItemsSubmit(Model model, HttpServletRequest request,
			Integer id,	@Validated Items items,
			BindingResult errors)throws Exception {

		// 获取校验错误信息
		if (errors.hasErrors()) {
			List<ObjectError> list=errors.getAllErrors();
			for(ObjectError error:list) {
				logger.info(">>>>>>>error msg>>{}",error.getDefaultMessage());
			}
		}
		
		return null;
	}
}
