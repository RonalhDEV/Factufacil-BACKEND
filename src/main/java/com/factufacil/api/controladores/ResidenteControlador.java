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
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Residente> obtenerResidentes() {
		return ResiServi.obtenerTodos();
	}

	@ResponseStatus(code = HttpStatus.OK, reason = "¡Residente eliminado!")
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarResidente(@PathVariable Long id) {
		ResiServi.eliminar(id);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "¡Residente actualizado!")
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public void actualizarResidente(@RequestBody Residente objResidente) {
		ResiServi.actualizar(objResidente);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
	public Residente obtenerUnResidente (@PathVariable Long id) {
		return ResiServi.obtenerUno(id);
	}
	
	
	
	
	
	
	
	
	
}
