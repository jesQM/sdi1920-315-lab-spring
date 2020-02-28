package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {

	// Las funciones findBy<nombre_atributo> se dotan de funcionalidad de forma automática.
	User findByDni(String dni); 

	@Query("SELECT u FROM User u WHERE ( LOWER(u.name) LIKE(?1) OR LOWER(u.lastName) LIKE(?1) )")
	List<User> searchBySubstringInNameOrSurname(String contained);
}
