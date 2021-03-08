package com.yedam.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;


@Controller
public class LoginController { 
	@Resource UserService userService; // == @Autowired
	
	
	@GetMapping("/login")    //로그인페이지 이동
	public String login() {
		return "user/login";
	}
    @PostMapping("/login")    //로그인처리
    public String loginproc(UserVO vo, HttpSession session) { 
    	if (userService.logCheck(vo)) { //로그인 된 경우
    		//세션에 저장
    		session.setAttribute("loginid", vo.getId());
    		return "redirect:/";    		
    	} else {
    		return "user/login";
    	}
    }
    @GetMapping("/logout")    //로그아웃 처리
    public String logout(HttpSession session) {
    	session.invalidate(); //세션 무효화
    	return "redirect:/";
    }
    @GetMapping("/changePw") //패스워드 변경 페이지
    public String changePw() {
    	return "user/changePw";
    }
    @PostMapping("/changePw") //패스워드 변경 처리
    public String changePwProc(UserVO vo, HttpSession session) {
    	//validation 일치여부 확인
    	//패스워드변경서비스
    	String id = (String) session.getAttribute("loginid"); //오브젝트타입으로 넘어오기 때문에 string id에 못 담음 그래서 캐스팅
    	vo.setId(id);
    	userService.updatePw(vo);
    	return "user/changePw";
    }
}
