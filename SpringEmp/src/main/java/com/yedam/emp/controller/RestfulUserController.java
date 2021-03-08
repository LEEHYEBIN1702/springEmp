package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

//@RestController
public class RestfulUserController {
	@Autowired UserService userService;
	
	  @PostMapping("/user") //등록처리 
	  public UserVO insertUserProc(@RequestBody UserVO vo) {
		  userService.insertUser(vo);
			if(vo.getId().equals("0")) {
				return vo;
			} else {
			return userService.getSearchUser(vo);
		    }
		}

	  
	  @PutMapping("/user") //수정처리 
	  public UserVO updateUserProc(@RequestBody UserVO vo) {
		    userService.updateUser(vo);
			System.out.println("수정===="+ vo); // @RequestBody 달아서 제이슨 타입을 자바 타입으로 바꿔 넘겨야 인식이 됨
			return vo;
    }
	  
	  @DeleteMapping("/user/{id}") //삭제 //get post 뭐 적어야 할지 헷갈리면 RequestMapping
	  public Map deleteUserProc(UserVO vo
			                   ,@PathVariable String id) {
			 vo.setId(id);
		 int r = userService.deleteUser(vo); 
		 return Collections.singletonMap("cnt", r);
	 }
	  
	  @GetMapping("/user") //전체
	  public List<UserVO> getUser(UserVO vo) {
	      return userService.getUser(vo);
	 }
	
	  @GetMapping("/user/{id}") //단건
	  public UserVO getSearchUser(UserVO vo
			                     ,@PathVariable String id) {
			vo.setId(id);
		return userService.getSearchUser(vo);	
	}

}
