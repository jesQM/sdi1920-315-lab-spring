package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;
import com.uniovi.entities.User;
import com.uniovi.services.UsersService;

@Component
public class MarkAddFormValidator implements Validator {
	
	@Autowired
	private UsersService usersService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		
		if (mark.getUser() == null || usersService.getUser(mark.getUser().getId()) == null )
			errors.rejectValue("user", "Error.mark.user");
		if (mark.getScore() < 0 || mark.getScore() > 10)
			errors.rejectValue("score", "Error.mark.score");
		if (mark.getDescription().length() < 20)
			errors.rejectValue("description", "Error.mark.description");
	}

}
