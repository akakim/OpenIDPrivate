package com.openid.kim.connect.web;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openid.kim.connect.service.StatsService;

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
}
