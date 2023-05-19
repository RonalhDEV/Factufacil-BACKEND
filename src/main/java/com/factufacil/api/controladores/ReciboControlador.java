package com.factufacil.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.factufacil.api.entidades.Recibo;
import com.factufacil.api.servicios.ReciboServicio;

@RestController
@RequestMapping("/recibos")
@CrossOrigin(origins = "*")
public class ReciboControlador {
	
	@Autowired
	private ReciboServicio ReciServi;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
	public Recibo crearRecibo(@RequestBody Recibo objRecibo) {
		ReciServi.agregar(objRecibo);
		return objRecibo;
		
	}

}
