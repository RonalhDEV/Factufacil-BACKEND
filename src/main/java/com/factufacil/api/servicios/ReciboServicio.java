package com.factufacil.api.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Recibo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Recibo obtenerUno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
