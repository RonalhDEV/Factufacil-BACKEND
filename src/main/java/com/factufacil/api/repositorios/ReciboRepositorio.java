package com.factufacil.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factufacil.api.entidades.Recibo;

@Repository
public interface ReciboRepositorio extends JpaRepository<Recibo, Long> {

	@Query("SELECT r FROM Recibo r WHERE r.idRecibo = :id")
	public Recibo obtenerUno(Long id);
	
}
