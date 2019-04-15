package com.openid.kim.controller;

import java.util.Map;
import java.util.List;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.openid.kim.SessionViewProvider;
import com.openid.kim.service.SampleBoardService;

import net.spring4.chap01.Project;
import net.spring4.chap02.UserRepository;


@Controller
public class SampleController {

	private static final Logger logger = Logger.getLogger(SampleController.class);
	
	@Autowired
	private SessionViewProvider sp;
	
	@Autowired
	@Qualifier("nier")
	private UserRepository repo;
	
	@Resource(name="defaultSampleBoardService")
	private SampleBoardService sample;
	
	@RequestMapping(value="/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello Spring MVC. I'm Chris <br> My hobby is health training");
		return "hello";
	}
	
	@RequestMapping(value="/sample")
	public String openSampleList(Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("sample");
		
		logger.info(" called /sample/openSamleList.do 호출 " );
		List<Map<String,Object>> list = sample.selectBoardList(commandMap);
		
		mv.addObject("sampleBoard", list);
		return "sample";
	}
	
	// ModelAndView는 어떻게 써야하는거지..? 
	
	
	@RequestMapping(value="/sampleBoard")
	public ModelAndView openSampleBoardList( Map<String,Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sampleBoard");
		
		List<Map<String,Object>> list = sample.selectBoardList(commandMap);
		
		mv.addObject("sampleBoard", list);
		return mv;
	}
	
	/**
	 * 설정 경로를 못읽음 .
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getInnerPath")
	public String getInnerPath( Map<String,Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("hello");
	
/*		설정 경로를 못읽어와서 싶패 
 * 		String configLocation = "classpath:spring-edu-data.xml";
	    
	    AbstractApplicationContext aac = new GenericXmlApplicationContext(configLocation);
	    Project pr = aac.getBean("sampleProject",Project.class);
	    
	    pr.build();*/
	    return "hello";
	}
	
	
	@RequestMapping(value="/getUserInfo")
	public ModelAndView userInfoView() {
		ModelAndView mv = new ModelAndView("userInfo");
		
		repo.loggedUserRepository();
		
		return mv;
	}
	
	@RequestMapping(value="/sessionView")
	public ModelAndView getSessionView() {
		ModelAndView mv = new ModelAndView("sessionView");
		
		logger.info( sp.getClientID() );
		return mv;
	}
		
}		
	
	
	
	
