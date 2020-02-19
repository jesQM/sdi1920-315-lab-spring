package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {

	// Las funciones findBy<nombre_atributo> se dotan de funcionalidad de forma automática.
	User findByDni(String dni); 

}
