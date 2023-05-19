package com.factufacil.api.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.factufacil.api.entidades.Contacto;
import com.factufacil.api.interfaces.Operaciones;
import com.factufacil.api.repositorios.ContactoRepositorio;

@Service
public class ContactoServicio implements Operaciones<Contacto> {

	@Autowired
	private ContactoRepositorio ContRepo;

	@Override
	public boolean agregar(Contacto objeto) {
		Contacto objTemporal = ContRepo.save(objeto);
		return objTemporal != null;
	}

	@Override
	public List<Contacto> obtenerTodos() {
		return ContRepo.findAll();
	}

	@Override
	public boolean eliminar(Long id) {
		ContRepo.deleteById(id);
		return !ContRepo.existsById(id);
	}

	@Override
	public boolean actualizar(Contacto objeto) {
		Optional<Contacto> objetoVerificado = ContRepo.findById(objeto.getIdContacto());
		if (!objetoVerificado.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe para actualizar");
		} else {
			ContRepo.save(objeto);
			return true;
		}
	}

	@Override
	public Contacto obtenerUno(Long id) {
		return ContRepo.obtenerUno(id);
	}

}
