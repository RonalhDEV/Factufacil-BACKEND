package com.factufacil.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factufacil.api.entidades.Contacto;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Long> {

}
