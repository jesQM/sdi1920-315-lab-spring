package com.uniovi.services.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;
import com.uniovi.entities.User;
import com.uniovi.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repo;
	
	@PostConstruct
	public void init() {
		addTeacher(new Teacher("1", "Paco", "Pacoso", "Cat"));
		addTeacher(new Teacher("2", "Pepe", "Peposo", "Cat"));
		addTeacher(new Teacher("3", "Pepa", "Peposa", "Cat"));
	}
	
	
	public List<Teacher> getTeachers() {
		List<Teacher> teacher = new ArrayList<>();
    	repo.findAll().forEach(teacher::add);
    	return teacher;
    }
    
    public Teacher getTeacher(String DNI) {
    	return repo.findById(DNI).get();
    }
    
    public Teacher getTeacherByDni(String dni) {
		return repo.findByDNI(dni);
	}
    
    public void addTeacher(Teacher mark) {
    	repo.save(mark);
    }
    
    public void deleteTeacher(String DNI) {
    	repo.deleteById(DNI);
    }


	public void swap(Teacher id) {
		deleteTeacher(id.getDNI());
		addTeacher(id);
	}
}
