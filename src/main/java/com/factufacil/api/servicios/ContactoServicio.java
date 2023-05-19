package com.factufacil.api.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Contacto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto obtenerUno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
