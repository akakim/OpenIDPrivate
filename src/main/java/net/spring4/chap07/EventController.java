package net.spring4.chap07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {
	
	@Autowired
	EventRepository eventRepo;
	
	@RequestMapping(value="/event")
	public ModelAndView getEventList() {
		ModelAndView mv = new ModelAndView("/event");
		
		
		
		return mv;
	}
}
