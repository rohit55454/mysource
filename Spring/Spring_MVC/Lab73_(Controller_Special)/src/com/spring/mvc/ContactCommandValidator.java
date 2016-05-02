package com.spring.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContactCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactCommand.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ContactCommand cc = (ContactCommand)command;
		String fn = cc.getFname();
		String ln = cc.getLname();
		String em = cc.getEmail();
		String ph = cc.getPhone();
		
		if(fn == null || fn.length()==0)
			errors.rejectValue("fname", "errors.required", new Object[]{"First Name"}, null);

		if(ln == null || ln.length()==0)
			errors.rejectValue("lname", "errors.required", new Object[]{"Last Name"}, null);
		
		if(em == null || em.length()==0)
			errors.rejectValue("email", "errors.required", new Object[]{"Email"}, null);
		
		if(ph == null || ph.length()==0)
			errors.rejectValue("phone", "errors.required", new Object[]{"Phone"}, null);
	
	}
	
	
}
