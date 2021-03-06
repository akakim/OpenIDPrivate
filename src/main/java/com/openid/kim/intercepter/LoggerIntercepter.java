package com.openid.kim.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerIntercepter extends HandlerInterceptorAdapter{

	private final Logger logger = LoggerFactory.getLogger(LoggerIntercepter.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
//		System.out.println("--- 인터셉터 PreHandler --- ");
		logger.info("--- 인터셉터 PreHandler ---");
		logger.info(" getHandler type : " + 			handler.getClass().getSimpleName());
		logger.info(" Request URI :: " + request.getRequestURI());
		
		if( logger.isDebugEnabled() ) {
			logger.debug(" Request URI :: " + request.getRequestURI());
		}

		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
//		System.out.println("--- 인터셉터 postHandler --- ");
		logger.info("--- 인터셉터 postHandler --- ");
		logger.info(" getHandler type : " + 			handler.getClass().getSimpleName());
		logger.info(" Request URI :: " + request.getRequestURI());
//		logger.info("modelAndView" + modelAndView.getViewName());
		if( logger.isDebugEnabled() ) {
			logger.debug(" Request URI :: " + request.getRequestURI());
			
			handler.getClass().getSimpleName();
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
