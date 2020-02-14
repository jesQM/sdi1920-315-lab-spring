package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	private String DNI;
	
	private String Nombre;
	private String Apellidos;
	private String Categoria;
	
	public Teacher() { }
	
	public Teacher(String dNI, String nombre, String apellidos, String categoria) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;
		Categoria = categoria;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	
	@Override
	public String toString() {
		return "Teacher [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Categoria="
				+ Categoria + "]";
	}
}
