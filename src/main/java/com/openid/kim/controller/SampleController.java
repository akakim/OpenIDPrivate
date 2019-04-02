package com.openid.kim.controller;

import java.util.Map;
import java.util.List;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openid.kim.service.SampleBoardService;

@Controller
public class SampleController {

	private static final Logger logger = Logger.getLogger(SampleController.class);
	
	@Resource(name="defaultSampleBoardService")
	private SampleBoardService sample;
	
	@RequestMapping(value="/sample.do")
	public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("");
		
		logger.info(" called /sample/openSamleList.do 호출 " );
		
		return mv;
	}
	
	
	@RequestMapping(value="/sampleBorad.do")
	public ModelAndView openSampleBoardList( Map<String,Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sampleBorad.do");
		
		List<Map<String,Object>> list = sample.selectBoardList(commandMap);
		
		mv.addObject("sampleBoard", list);
		return mv;
	}
}
