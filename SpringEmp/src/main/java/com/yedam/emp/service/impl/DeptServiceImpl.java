package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	//@Autowired DeptSpringDAO dao;
	@Autowired DeptMapper dao;

	@Override
	public int insertDept(DeptVO vo) {
		
		return 0;
	}

	@Override
	public int updateDept(DeptVO vo) {
		
		return 0;
	}

	@Override
	public int deleteDept(DeptVO vo) {
		
		return 0;
	}

	@Override
	public DeptVO getDept(DeptVO vo) {
		
		return dao.getDept(vo);
	}

	@Override
	public List<DeptVO> getSearchDept(DeptVO vo) {
		
		return dao.getSearchDept(vo);
	}

	@Override
	public int getCount(DeptVO vo) {
		
		return dao.getCount(vo);
	}

}
