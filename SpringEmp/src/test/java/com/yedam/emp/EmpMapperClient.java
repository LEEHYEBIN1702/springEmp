package com.yedam.emp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	@Autowired EmpMapper empMapper;
	@Autowired EmpService empService;
	
	//@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
				   .email("a@a.cbb")
				   .employee_id("4001")
				   .build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1);
	}
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
				        .employee_id("4507")
				        .last_name("test7")
				        .email("cxvz@a.zxc")
				        .hire_date(new java.sql.Date(new Date().getTime()))
				        .job_id("IT_PROG")
				        .first_name("t2")
				        .department_id("20")
				        .phone_number("010.9999.9999")
				        .build();
		int result = empService.insertEmp(vo);
		assertEquals(result, 1);
	}
	
	//@Test
	/*
	 * public void getSearchEmp() { //lombok 기능 사용해서 만들어봄 EmpVO vo =
	 * EmpVO.builder().first_name("na").build(); List<EmpVO> list =
	 * empMapper.getSearchEmp(vo); System.out.println(list); }
	 */
	
	//@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
		//assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO);
		System.out.println(resultVO);
	}
}
