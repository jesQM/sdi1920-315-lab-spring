package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Teacher;
import com.uniovi.entities.User;
import com.uniovi.services.teacher.TeacherService;

@Component
public class TeacherAddFormValidator implements Validator {
	
	@Autowired
	private TeacherService teachersService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Teacher teacher = (Teacher) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "Error.teacher.dni.format");
		
		if ( !isDniOk(teacher.getDNI()))
			errors.rejectValue("DNI", "Error.teacher.dni.format");
		if ( teachersService.getTeacherByDni(teacher.getDNI()) != null)
			errors.rejectValue("DNI", "Error.teacher.dni.duplicate");
	}

	private boolean isDniOk(String dni) {
		if (dni == null) return false;
		if (dni.length() != 9) return false;
		
		for (int i = 0; i < 8; i++)
			if (!Character.isDigit(dni.charAt(i))) return false;
		
		return Character.isLetter(dni.charAt(8));
	}

}
