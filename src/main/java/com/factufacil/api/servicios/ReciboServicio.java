package com.factufacil.api.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.factufacil.api.entidades.Recibo;
import com.factufacil.api.interfaces.Operaciones;
import com.factufacil.api.repositorios.ReciboRepositorio;

@Service
public class ReciboServicio implements Operaciones<Recibo> {
	
	@Autowired
	private ReciboRepositorio ReciRepo;
	
	@Override
	public boolean agregar(Recibo objeto) {
		Recibo objTemporal = ReciRepo.save(objeto);
		return objTemporal != null;
	}

	@Override
	public List<Recibo> obtenerTodos() {
		return ReciRepo.findAll();
	}

	@Override
	public boolean eliminar(Long id) {
		ReciRepo.deleteById(id);
		return !ReciRepo.existsById(id);
	}

	@Override
	public boolean actualizar(Recibo objeto) {
		Optional<Recibo> objetoVerificado = ReciRepo.findById(objeto.getIdRecibo());
		if (!objetoVerificado.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe para actualizar");
		} else {
			ReciRepo.save(objeto);
			return true;
		}
	}

	@Override
	public Recibo obtenerUno(Long id) {
		return ReciRepo.obtenerUno(id);
	}

}
