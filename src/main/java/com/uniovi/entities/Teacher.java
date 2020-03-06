package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Teacher {

	@Id
	private String DNI;
	
	private String Nombre;
	private String apellidos;
	private String Categoria;
	
//	@ManyToOne
//    private Departamento department;
	
	public Teacher() { }
	
	public Teacher(String dNI, String nombre, String apellidos, String categoria) {
		super();
		this.DNI = dNI;
		this.Nombre = nombre;
		this.apellidos = apellidos;
		this.Categoria = categoria;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		this.Categoria = categoria;
	}
	
	
	@Override
	public String toString() {
		return "Teacher [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + apellidos + ", Categoria="
				+ Categoria + "]";
	}
}
