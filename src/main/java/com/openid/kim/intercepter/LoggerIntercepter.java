package com.openid.kim.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerIntercepter extends HandlerInterceptorAdapter{

	private static final Log logger = LogFactory.getLog(LoggerIntercepter.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("--- 인터셉터 PreHandler --- ");
		logger.info("start ....");
		
		if( logger.isDebugEnabled() ) {
			logger.debug(" Request URI :: " + request.getRequestURI());
		}

		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("--- 인터셉터 postHandler --- ");
		logger.info("start ....");
		if( logger.isDebugEnabled() ) {
			logger.debug(" Request URI :: " + request.getRequestURI());
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
