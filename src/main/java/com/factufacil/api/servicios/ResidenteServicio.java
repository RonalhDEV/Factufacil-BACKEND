package com.factufacil.api.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.factufacil.api.entidades.Residente;
import com.factufacil.api.interfaces.Operaciones;
import com.factufacil.api.repositorios.ResidenteRepositorio;

@Service
public class ResidenteServicio implements Operaciones<Residente> {

	@Autowired
	private ResidenteRepositorio ResiRepo;

	@Override
	public boolean agregar(Residente objeto) {
		Residente objTemporal = ResiRepo.save(objeto);
		return objTemporal != null;
	}

	@Override
	public List<Residente> obtenerTodos() {
		return ResiRepo.findAll();
	}

	@Override
	public boolean eliminar(Long id) {
		ResiRepo.deleteById(id);
		return !ResiRepo.existsById(id);
	}

	@Override
	public boolean actualizar(Residente objeto) {
		Optional<Residente> objetoVerificado = ResiRepo.findById(objeto.getIdResidente());
		if (!objetoVerificado.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe para actualizar");
		} else {
			ResiRepo.save(objeto);
			return true;
		}
	}

	@Override
	public Residente obtenerUno(Long id) {
		return ResiRepo.obtenerUno(id);
	}

}
