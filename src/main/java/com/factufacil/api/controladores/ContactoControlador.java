package com.factufacil.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.factufacil.api.entidades.Contacto;
import com.factufacil.api.servicios.ContactoServicio;

@RestController
@RequestMapping("/contactos")
@CrossOrigin(origins = "*")
public class ContactoControlador {
	
	@Autowired
	private ContactoServicio ContServi;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
	public Contacto crearContacto(@RequestBody Contacto objContacto) {
		ContServi.agregar(objContacto);
		return objContacto;
		
	}
	
}
