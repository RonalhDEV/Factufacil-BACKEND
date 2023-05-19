package com.factufacil.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.factufacil.api.entidades.Residente;
import com.factufacil.api.servicios.ResidenteServicio;

@RestController
@RequestMapping("/residentes")
@CrossOrigin(origins = "*")
public class ResidenteControlador {
	
	@Autowired
	private ResidenteServicio ResiServi;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
	public Residente crearResidente(@RequestBody Residente objResidente) {
		ResiServi.agregar(objResidente);
		return objResidente;
		
	}

}
