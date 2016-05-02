package com.spring.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SearchContactCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SearchContactCommand.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		SearchContactCommand scc = (SearchContactCommand) command;
		String em = scc.getEmail();

		if (em == null || em.length() == 0)
			errors.rejectValue("email", "errors.required", new Object[] { "Email" }, null);

	}

}
