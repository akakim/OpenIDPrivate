package com.openid.kim.connect.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.openid.kim.controller")
public class CommonExceptionHandler {

	
	private final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntime() {
		
		logger.info( "handle Exception" );
		return "/error";
	}
}
