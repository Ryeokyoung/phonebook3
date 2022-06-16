package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;


@Controller
//@RequestMapping(value="/guest")
public class PhoneController {
	
	//필드 
	
	//생성자 
	
	//메소드 
	
	//일반 
	
	//delete 삭제 
	@RequestMapping(value="/delete/{no}/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("no") int num, @PathVariable("id") String id) { 
		System.out.println("PhoneController>delete()");
		
		//주소에서 값꺼내기 
		System.out.println(num);
		
		
		
		//Dao로 처리하기(삭제) 
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personDelete(num);
		System.out.println(count);
		
		return "redirect:/list";
		
		
	}
	
	//delete 삭제 
	@RequestMapping(value="/delete/4", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete4(@RequestParam("no") int no) { 
		System.out.println("PhoneController>delete()");
		
		System.out.println(no);
		
		//4번글 삭제 
		
		//Dao로 처리하기(삭제) 
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personDelete(no);
		System.out.println(count);
		
		return "redirect:/list";
		
	}
	
	//전화번호 리스트 
	@RequestMapping(value="/list", method = { RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { 
		System.out.println("PhoneController>list()");
		
		//Dao를 통해서 personList(주소)를 가져온다 
		PhoneDao phoneDao = new PhoneDao(); 
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		//ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("personList",personList);
				
		return "/WEB-INF/views/list.jsp"; //포워드 
		
	
	}
	
	
	//등록
	@RequestMapping(value="/write",method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo, @RequestParam("age") int age,
														   @RequestParam("name") String name ) { 
		System.out.println("PhoneController>write()");
		
		
		//파라미ㅓ꺼내기 + vo로 묶기를 dispatcherservlet 해서 메소드의 파라미터로 보내준다 
		
		
		//파라미터꺼내기
		/*
		System.out.println(name); 
		System.out.println(hp); 
		System.out.println(company); 
		*/
		
		//vo로 묶기 
		//PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		
		
		//dao로 저장하기 
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		//error: 드라이버 로딩 실패 jdbc 관련 
		
		
		//리다이렉트
		//리스트로 리다이렉트 시킬 예정 
		
		return "redirect:/phonebook3/list"; 
	}
	
	@RequestMapping(value="/write2",method= {RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company)
						{ 
		System.out.println("PhoneController>write()");
		
		
		//파라미터꺼내기
		/*
		System.out.println(name); 
		System.out.println(hp); 
		System.out.println(company); 
		*/
		
		//vo로 묶기 
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		
		
		//dao로 저장하기 
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		//error: 드라이버 로딩 실패 jdbc 관련 
		
		
		//리다이렉트
		//리스트로 리다이렉트 시킬 예정 
		
		return "redirect:/phonebook3/list"; 
	}
	
	//등록폼 
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
