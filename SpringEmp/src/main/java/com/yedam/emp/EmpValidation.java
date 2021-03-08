package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmpValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp = (EmpVO)target; //형변환 시켜줘야함..(다운캐스팅) vo에 있는 값을 검사한다.
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", null, 
	    		                     "Empty last_name is now allowed.");
	    
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hire_date", null, 
                "Empty hire_date is now allowed.");
	    
	    if(emp.getEmail() == null  || emp.getEmail().isEmpty()) // == rejectIfEmptyOrWhitespace
	    errors.rejectValue("email", null, "eamil not null"); 
	    // rejectIfEmptyOrWhitespace를 사용하던가 if(emp.getEmail() == null  || emp.getEmail().isEmpty()) 쓰던가 자유
	    
	    if(emp.getDepartment_id() == null  || emp.getDepartment_id().isEmpty())
	    errors.rejectValue("department_id", null, "department_id not null");
		
	}

}
