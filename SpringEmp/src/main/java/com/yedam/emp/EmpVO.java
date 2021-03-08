package com.yedam.emp;



import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data; // 앞으로 이것만 추가하면 get set tostring 추가 안 해도 된다.
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	@NotBlank
	@NotEmpty
	private String employee_id;
	
	@NotEmpty
	private String first_name;
	
	@NotEmpty (message = "last_name 필수입니다.")
	private String last_name;
	
	@NotEmpty
	private String email;
	
	@NotBlank
	private String phone_number;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	private String department_name;
	private String job_title;
}
