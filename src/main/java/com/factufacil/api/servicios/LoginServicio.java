package com.factufacil.api.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.factufacil.api.entidades.Login;
import com.factufacil.api.interfaces.Operaciones;
import com.factufacil.api.repositorios.LoginRepositorio;

@Service
public class LoginServicio implements Operaciones<Login> {
	
	
	@Autowired
	private LoginRepositorio LogiRepo;
	
	@Override
	public boolean agregar(Login objeto) {
		Login objTemporal = LogiRepo.save(objeto);
		return objTemporal != null;
	}

	@Override
	public List<Login> obtenerTodos() {
		return LogiRepo.findAll();
	}

	@Override
	public boolean eliminar(Long id) {
		LogiRepo.deleteById(id);
		return !LogiRepo.existsById(id);
	}

	@Override
	public boolean actualizar(Login objeto) {
		Optional<Login> objetoVerificado = LogiRepo.findById(objeto.getIdLogin());
		if (!objetoVerificado.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe para actualizar");
		} else {
			LogiRepo.save(objeto);
			return true;
		}
	}

	@Override
	public Login obtenerUno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
