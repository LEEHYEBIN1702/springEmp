package com.yedam.emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	private String last_name;
	private String city;
	Integer page = 1;
	int start = 1;
	int end = 10;

}
