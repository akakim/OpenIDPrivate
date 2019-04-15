package com.openid.kim.connect.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dream.model.BoardEntitiy;

import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/" + BoardAPIs.URL)
public class BoardAPIs {

	public static final String URL = RootController.API_URL + "/boards";
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String apiGetAllBoards(Model model)	{
		
		return "boards";
	}
	
	// Command 방식의 요청 
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String registBoard(BoardEntitiy entity) {
		
		//BoardEntity는 
		// get과 set을 구현해야한다. 커맨드 객체로 사용될 클래스는 제한 없음 .
		// 커맨드 객체는 Jsp상에서 다음과 같이 변환된다. 
		
		// ${boardEntity.id} 이런식으로 . 
		//  CheckBox로 노티를 준다고 하면 
		// <label> 
		// <input type="checkbox" name="checkNoti[필드명임]" value="true"/>
		// 이메일을 수신합ㄴ디ㅏ. 
		// </label>
		// 이러면 boolean 타입으로 변환해준다. 
		
		// 만약 에러가 난다면 에러처리 
		 // return "redirect:/error" 뭐 이런식으로? 
		return "boards";
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE )
	public ModelAndView apiGetAllWritten(@PathVariable String id) {
		// query id skip 
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("userName", "test User");
		
		
		//만약 글을 등록한다면 Validation이 추가가 되어야 할것이다. 
		// 예제는 다음과 주소를 참고하자ㅏ. 
		
		// https://github.com/madvirus/spring4/blob/master/mvnprj/spring4-chap07/src/main/java/net/madvirus/spring4/chap07/member/MemberRegistValidator.java
		// ValidationUtils.rejectIfEmptyOrWhiteSpace 이런 유틸이 있다. 
		
		
		return view;
	}
	
	@RequestMapping(value="/{id}/title/{hash_tag}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE )
	public ModelAndView apiSpecificTAG(@PathVariable String id,@PathVariable String hashTag) {
		// query id skip 
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("userName", "test User");
		return view;
	}
	
	// 이런식으로 정규 표현식을 줄 수 있다. 하지만 실제로는 잘 안스인다. 
	// 업무영역에서 종종 응용한다. 
	@RequestMapping(value="/files/{field:[a-zA-Z]\\d\\d\\d}")
	public String fileInfo(@PathVariable String hashTag) {
	
		
		
		return "files" ;
	}
	
	
	
	

}
