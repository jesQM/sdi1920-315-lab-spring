package com.uniovi.controllers.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Teacher;
import com.uniovi.services.teacher.TeacherService;
import com.uniovi.validators.TeacherAddFormValidator;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@Autowired
	private TeacherAddFormValidator teacherAddFormValidator;
	
	@RequestMapping("/teacher/teacher")
	public String getHome() {
		return "teacher/teacher";
	}
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("teacherList", service.getTeachers() );
		return "teacher/list";
	}
	
	
	@RequestMapping(value="/teacher/add")
	public String setTeacher(Model model){
		model.addAttribute("teacher", new Teacher());
		return "teacher/add";
	}
	
	@RequestMapping(value="/teacher/add", method=RequestMethod.POST )
	public String setTeacher(@Validated@ModelAttribute Teacher teacher, BindingResult result){
		teacherAddFormValidator.validate(teacher, result);
		if (result.hasErrors())
			return "teacher/add";
		
		service.addTeacher(teacher);
		return "redirect:/teacher/list";
	}
	
	@RequestMapping("/teacher/delete/{id}" )
	public String deleteTeacher(@PathVariable String id){ //GET with param id
		service.deleteTeacher(id);
		return "redirect:/teacher/list";
	}
	
	@RequestMapping("/teacher/details/{id}" )
	public String getDetail(Model model, @PathVariable String id){ //GET with param id
		model.addAttribute("teacher", service.getTeacher(id) );
		return "teacher/details";
	}

	
	@RequestMapping(value="/teacher/edit/{id}") // GET
	public String getEdit(Model model, @PathVariable String id){
		model.addAttribute("teacher", service.getTeacher(id) );
		return "teacher/edit";
	}
	
	@RequestMapping(value="/teacher/edit", method=RequestMethod.POST )
	public String setEdit(@ModelAttribute Teacher id){
		service.swap(id);
		return "redirect:/teacher/list";
	}
}
