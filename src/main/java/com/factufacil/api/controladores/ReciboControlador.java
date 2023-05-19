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
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Recibo> obtenerRecibos() {
		return ReciServi.obtenerTodos();
	}
	
	@ResponseStatus(code = HttpStatus.OK, reason = "¡Recibo eliminado!")
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarRecibo(@PathVariable Long id) {
		ReciServi.eliminar(id);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "¡Recibo actualizado!")
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public void actualizarRecibo(@RequestBody Recibo objRecibo) {
		ReciServi.actualizar(objRecibo);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Recibo obtenerUnRecibo (@PathVariable Long id) {
		return ReciServi.obtenerUno(id);
	}

}
