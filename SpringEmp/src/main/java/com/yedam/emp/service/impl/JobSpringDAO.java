package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.yedam.emp.JobVO;


@Repository
public class JobSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String GET_JOB = "select  job_id,"
			+ " job_title,"
			+ " min_salary,"
			+ " max_salary"
			+ " from jobs"
			+ " where job_id=?";
	private final String GET_SEARCH_JOB = "select  job_id,"
			+ " job_title,"
			+ " min_salary,"
			+ " max_salary"
			+ " from jobs"
			+ " order by job_id";
	
	//단건조회
		public JobVO getJob(JobVO vo) {
			return jdbc.queryForObject(GET_JOB,
					                   new JobRowMapper(),
					                   vo.getJob_id());
			
		}
		
		//목록조회
		public List<JobVO> getSearchJob (JobVO jobVO) {
			return jdbc.query(GET_SEARCH_JOB,
					          new JobRowMapper());
		}
	
	class JobRowMapper implements RowMapper<JobVO> {

		@Override
		public JobVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobVO vo = new JobVO();
			vo.setJob_id(rs.getString("job_id"));
			vo.setJob_title(rs.getString("job_title"));
			vo.setMin_salary(rs.getInt("min_salary"));
			vo.setMax_salary(rs.getInt("max_salary"));
			return vo;
		}
		
	}
}
