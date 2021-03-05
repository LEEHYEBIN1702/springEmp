package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String GET_DEPT = "select  department_id,"
			+ " department_name,"
			+ " manager_id,"
			+ " location_id"
			+ " from departments"
			+ " where department_id=?";
	private final String GET_SEARCH_DEPT = "select  department_id,"
			+ " department_name,"
			+ " manager_id,"
			+ " location_id"
			+ " from departments"
			+ " order by department_id";
	
	//단건조회
	public DeptVO getDept(DeptVO vo) {
		return jdbc.queryForObject(GET_DEPT,
				                   new DeptRowMapper(),
				                   vo.getDepartment_id());
		
	}
	
	//목록조회
	public List<DeptVO> getSearchDept (DeptVO deptVO) {
		return jdbc.query(GET_SEARCH_DEPT,
				          new DeptRowMapper());
	}
	
	class DeptRowMapper implements RowMapper<DeptVO> {

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartment_id(rs.getInt("department_id"));
			vo.setDepartment_name(rs.getString("department_name"));
			vo.setManager_id(rs.getInt("manager_id"));
			vo.setLocation_id(rs.getInt("location_id"));
			return vo;
		}
		
	}
}
