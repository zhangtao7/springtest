package com.springtest.chapter6.thymeleaf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(value="com.springtest.chapter6.thymeleaf")
public class ExceptionAdvice {

	Logger logger=LoggerFactory.getLogger(getClass());
	
//	@InitBinder
//	public void initBinid() {
//		
//	}
	
	
	@ExceptionHandler
	@ResponseBody
	public String  handlerException(HttpServletRequest request,HttpServletResponse response,Exception ex) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>exception>>>>>>>>>>{}",ex.getMessage());
		
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/json");
			out.print(ex.getMessage());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
