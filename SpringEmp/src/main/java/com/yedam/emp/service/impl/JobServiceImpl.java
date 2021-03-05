package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired JobMapper dao;

	@Override
	public int insertJob(JobVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateJob(JobVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteJob(JobVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JobVO getJob(JobVO vo) {
		// TODO Auto-generated method stub
		return dao.getJob(vo);
	}

	@Override
	public List<JobVO> getSearchJob(JobVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchJob(vo);
	}

	@Override
	public int getCount(JobVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
