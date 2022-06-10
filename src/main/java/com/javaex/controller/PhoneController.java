package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.PersonVo;


@Controller
//@RequestMapping(value="/guest")
public class PhoneController {
	
	//필드 
	
	//생성자 
	
	//메소드 
	
	//일반 
	@RequestMapping(value="/write",method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company)
						{ 
		System.out.println("PhoneController>write()");
		
		
		//파라미터꺼내기
		System.out.println(name); 
		System.out.println(hp); 
		System.out.println(company); 
		
		
		//vo로 묶기 
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		
		
		//dao로 저장하기 
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		
		return "WEB-INF/views/writeForm.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//test 메소드 
	//@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST})
	//handler mapping
	//@RequestMapping(value="/test", method={RequestMethod.POST}) --> 경고: Request method 'GET' not supported
	public String test() { 
	
		System.out.println("PhoneController>test()");
		//다오
		return "/WEB-INF/views/index.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			//수정폼메소드 
			//삭제메소드 
			//리스트메소드 
			
	
}
