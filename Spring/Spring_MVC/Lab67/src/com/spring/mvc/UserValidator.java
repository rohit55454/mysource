package com.spring.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		User user = (User)command;
		if(user.getUsername().equals(null) || user.getUsername().length() == 0){
			errors.rejectValue("username", "errors.username.required", null, "username required");
		}
		
		if(user.getPassword() == null || user.getPassword().length() == 0){
			errors.rejectValue("password", "errors.password.required", null, "password required");
		}
	
	}	
	
	
}
