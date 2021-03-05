package com.yedam.board.service.impl;

import java.util.List;


import com.yedam.board.service.CommentsVO;

public interface CommentsMapper {
	
	//등록
	public void insertComments(CommentsVO vo); //리턴 값이 없으니까 int or void 아무거나 해도 됨
	
	//수정
	public void updateComments(CommentsVO vo);
	
	//삭제
	public int deleteComments(CommentsVO vo);
	
	//단건조회
	public CommentsVO getComments(CommentsVO vo);
	
	//전체조회
    public List<CommentsVO> getSearchComments(CommentsVO vo);
}
