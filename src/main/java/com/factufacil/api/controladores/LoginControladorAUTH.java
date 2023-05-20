package com.factufacil.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.factufacil.api.entidades.Login;
import com.factufacil.api.repositorios.LoginRepositorio;

@Controller
public class LoginControladorAUTH {

  @Autowired
  private LoginRepositorio loginRepositorio;

  @PostMapping("/validar")
  public String valida(@Validated Login login, Model model) {
    try {
      Login objLogin = loginRepositorio.findByEmailResidente(login.getEmailResidente());
      if (objLogin == null) {
        return "/validar";
      } else {
        if (objLogin.getClaveResidente().equals(login.getClaveResidente())) {
          model.addAttribute("logins", objLogin);
          return "/index";
        } else {
          return "/validar";
        }
      }
    } catch (Exception e) {
      System.out.println("Error!!!: " + e);
    }
    return "";
  }

}

