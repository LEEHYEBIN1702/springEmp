package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO user = (UserVO) target;
		
		 if(user.getPassword() == null  || user.getNewpassword().isEmpty()) // == rejectIfEmptyOrWhitespace
			errors.rejectValue("password != newpassword", "비밀번호가 틀립니다."); 
		
	}

}
