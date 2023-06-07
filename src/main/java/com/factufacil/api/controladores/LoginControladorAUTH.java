package com.factufacil.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.factufacil.api.entidades.Login;
import com.factufacil.api.repositorios.LoginRepositorio;

@RestController
@CrossOrigin(origins = "*")
public class LoginControladorAUTH {

  @Autowired
  private LoginRepositorio loginRepositorio;

  @PostMapping("/login/validar")
  public ResponseEntity<String> valida(@Validated @RequestBody Login login) {
    try {
      Login objLogin = loginRepositorio.findByEmailResidente(login.getEmailResidente());
      if (objLogin == null) {
        return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
      } else {
        if (objLogin.getClaveResidente().equals(login.getClaveResidente())) {
          return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
        } else {
          return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
      }
    } catch (Exception e) {
      return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
