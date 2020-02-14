package com.uniovi.services.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;

@Service
public class TeacherService {
	
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	@PostConstruct
	public void init() {
		teachers.add(new Teacher("1", "Paco", "Pacoso", "Cat"));
		teachers.add(new Teacher("2", "Pepe", "Peposo", "Cat"));
		teachers.add(new Teacher("3", "Pepa", "Peposa", "Cat"));
	}
	
	
	public List<Teacher> getTeacher() {
    	return new ArrayList<Teacher>(teachers);
    }
    
    public Teacher getTeacher(String DNI) {
    	return teachers.stream().filter( t -> t.getDNI().equals(DNI) ).findFirst().get();
    }
    
    public void addMark(Teacher mark) {
    	teachers.add(mark);
    }
    
    public void deleteTeacher(String DNI) {
    	for (int i = 0; i < teachers.size(); i++) {
			if( teachers.get(i).getDNI().equals(DNI) ) {
				teachers.remove(i);
				break;
			}
		}
    }


	public void swap(Teacher id) {
		deleteTeacher(id.getDNI());
		addMark(id);
	}
}
