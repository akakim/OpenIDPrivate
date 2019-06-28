package com.openid.kim.connect.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openid.kim.SessionViewProvider;
import com.openid.kim.connect.service.StatsService;
import com.openid.kim.service.SampleBoardService;

import net.spring4.chap02.UserRepository;

/**
 * API 규칙 /springSample/{chapter제목}/{샘플 제목}
 * 공통 /error 
 * @author dream
 *
 */

@Controller
public class RootController {

	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	public static final String API_URL = "api";
	
	/*@Autowired
	private StatsService statsService;*/
	
	
	@RequestMapping({"","home","index"})
	public String showHomePage(ModelMap m) {
		return "home";
	}
	
	@RequestMapping({"about", "about/"})
	public String showAboutPage(ModelMap m) {
		return "about";
	}

	@RequestMapping({"stats", "stats/"})
	public String showStatsPage(ModelMap m) {
	/*	Map<String, Integer> summary = statsService.getSummaryStats();

		m.put("statsSummary", summary);*/
		return "stats";
	}

	@RequestMapping({"contact", "contact/"})
	public String showContactPage(ModelMap m) {
		return "contact";
	}

//	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("manage/**")
	public String showClientManager(ModelMap m) {
		return "manage";
	}

/*	public StatsService getStatsService() {
		return statsService;
	}

	public void setStatsService(StatsService statsService) {
		this.statsService = statsService;
	}*/

	@ExceptionHandler(RuntimeException.class)
	public String handleExcpetion(HttpServletResponse response) {
		logger.info("handleExcption... ()");
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "/error";
	}
	
	
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
	
	@RequestMapping(value="/redirectMain")
	public String redirect() {
		
		return "redirect:hello";
		
	}
	
	@RequestMapping(value="/getError")
	public ModelAndView getErrorMessage(@RequestParam String code, @RequestParam String message) throws Exception{
		ModelAndView mv = new ModelAndView("error");
		
		//logger.info(" code : " + code + "message : " + message );
		if( code == null || "".equals(code)) {
//			throw new Exception("code is null");
			mv.addObject("code", "is null" );


		}else if (message == null || "".equals(message)) {
			mv.addObject("message","is null");
//			throw new Exception("code is null");
			
		}else {
			mv.addObject("code", code );
			mv.addObject("message",message);
		}
		return mv;
	}
	
	@RequestMapping(value="/getPlayers")
	public ModelAndView getPlayers(@RequestParam String param) {
		
		logger.info( "get Players ");
		
		ModelAndView playerView = new ModelAndView("players");
	
		
		return playerView;
		
	}
	
}
