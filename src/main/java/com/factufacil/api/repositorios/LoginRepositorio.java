package com.factufacil.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factufacil.api.entidades.Login;

@Repository
public interface LoginRepositorio extends JpaRepository<Login, Long> {

	public Login findByEmailResidente(String email);
	
}
