package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.UserVO;


public interface UserService {
	
	 //등록
	public int insertUser(UserVO vo);
	
	//수정
	public int updateUser(UserVO vo);
	
	//삭제
	public int deleteUser(UserVO vo);
	
	//단건조회
	public UserVO getSearchUser(UserVO vo);
	
	//전체조회
	public List<UserVO> getUser(UserVO vo);
	

}
