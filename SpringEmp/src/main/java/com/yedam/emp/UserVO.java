package com.yedam.emp;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
	private String oldpassword;
	private String newpassword;

}
