package com.factufacil.api.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Residente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Residente obtenerUno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
