package com.factufacil.api.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Contacto> obtenerContactos() {
		return ContServi.obtenerTodos();
	}
	
	@ResponseStatus(code = HttpStatus.OK, reason = "¡Contacto eliminado!")
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarContacto(@PathVariable Long id) {
		ContServi.eliminar(id);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "¡Contacto actualizado!")
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public void actualizarContacto(@RequestBody Contacto objContacto) {
		ContServi.actualizar(objContacto);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Contacto obtenerUnContacto (@PathVariable Long id) {
		return ContServi.obtenerUno(id);
	}
	
}
