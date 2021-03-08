package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class UserController {
	@Autowired UserService userService;
	
	  @PostMapping("/insertuser") //등록처리 
	  public ResponseEntity<Object> insertUser(UserVO vo) throws JsonProcessingException {
		  userService.insertUser(vo);
		  UserVO userVO = userService.getSearchUser(vo);
		  if(userVO != null) { //null이 아니면 정상실행 
			  ObjectMapper mapper = new ObjectMapper(); //jackson 라이브러리 json
			  return ResponseEntity.status(200).body(mapper.writeValueAsString(userVO));
		  }else { //null이면 오류
			  return ResponseEntity.status(500).body("insert error");
		  }
			
		}

	  
	  @PostMapping("/updateuser") //수정처리 
	  public UserVO updateUser(UserVO vo) {
		    userService.updateUser(vo);
		    return vo; 
    }
	  
	  @GetMapping(value ="/deleteuser") //삭제 
	  public Map deleteUser(UserVO vo) {
		 int r = userService.deleteUser(vo); 
		 return Collections.singletonMap("cnt", r);
	 }
	  
	  @GetMapping("/getuserlist") //전체
	  public List<UserVO> getUser(UserVO vo) {
	      return userService.getUser(vo);
	 }
	
	  @GetMapping("/getuser") //단건
	  public UserVO getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);	
	}

}
