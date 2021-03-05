package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
    
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	//@Transactional
	public int insertEmp(EmpVO vo) {
		//dao.insertEmp(vo); //트랜잭션이 지정되지 않으면 자동커밋 됨
		return dao.insertEmp(vo); //
	}

	@Override
	public int updateEmp(EmpVO vo) {
		
		return dao.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		
		return dao.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		
		return dao.getEmp(vo);
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		
		return dao.getSearchEmp(vo);
		
	}

	@Override
	public int getCount(EmpSearchVO vo) {

		return dao.getCount(vo);
	}

}
