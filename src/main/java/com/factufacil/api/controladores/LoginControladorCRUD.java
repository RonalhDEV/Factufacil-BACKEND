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

import com.factufacil.api.entidades.Login;
import com.factufacil.api.servicios.LoginServicio;

@RestController
@RequestMapping("/validar")
@CrossOrigin(origins = "*")
public class LoginControladorCRUD {
	
	@Autowired LoginServicio LogiServi;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
	public Login crearLogin(@RequestBody Login objLogin) {
		LogiServi.agregar(objLogin);
		return objLogin;
	}
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Login> obtenerLogins() {
		return LogiServi.obtenerTodos();
	}
	
	@ResponseStatus(code = HttpStatus.OK, reason = "¡Usuario eliminado!")
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarLogin(@PathVariable Long id) {
		LogiServi.eliminar(id);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED, reason = "¡Usuario actualizado!")
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
	public void actualizarLogin(@RequestBody Login objLogin) {
		LogiServi.actualizar(objLogin);
	}
	
	
}
