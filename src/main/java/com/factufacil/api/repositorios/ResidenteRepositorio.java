package com.factufacil.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factufacil.api.entidades.Residente;

@Repository
public interface ResidenteRepositorio extends JpaRepository<Residente, Long>{
	
	@Query("SELECT r FROM Residente r WHERE r.idResidente = :id")
	public Residente obtenerUno(Long id);
	
}
