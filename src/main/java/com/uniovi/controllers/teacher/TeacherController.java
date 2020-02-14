package com.uniovi.controllers.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.teacher.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping("/teacher/list")
	public String getList() {
		return service.getTeachers().toString();
	}
	
	@RequestMapping(value="/teacher/add", method=RequestMethod.POST )
	public String setTeacher(@ModelAttribute Teacher teacher){
		service.addTeacher(teacher);
		return "added: " + teacher;
	}
	
	@RequestMapping("/teacher/delete/{id}" )
	public String deleteMark(@PathVariable String id){ //GET with param id
		service.deleteTeacher(id);
		return "OK";
	}
	
	@RequestMapping("/teacher/details/{id}" )
	public String getDetail(@PathVariable String id){ //GET with param id
		return service.getTeacher(id).toString();
	}

	@RequestMapping(value="/teacher/edit", method=RequestMethod.POST )
	public String setEdit(@ModelAttribute Teacher id){
		service.swap(id);
		return "Ok";
	}
}
