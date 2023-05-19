package com.factufacil.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factufacil.api.entidades.Residente;

@Repository
public interface ResidenteRepositorio extends JpaRepository<Residente, Long>{

}
