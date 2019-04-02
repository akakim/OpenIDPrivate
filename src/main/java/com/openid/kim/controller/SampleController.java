package com.openid.kim.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

	private static final Logger logger = Logger.getLogger(SampleController.class);
	
	@RequestMapping(value="/sample.do")
	public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("");
		
		logger.info(" called /sample/openSamleList.do 호출 " );
		
		return mv;
	}
}
