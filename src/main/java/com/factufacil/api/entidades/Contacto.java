package com.factufacil.api.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idContacto", nullable = false)
	private Long idContacto;

	@Column(name = "correoResidente", nullable = false, length = 100)
	private String correoResidente;

	@Column(name = "telefonoResidente", nullable = false, length = 20)
	private Long telefonoResidente;

	public Contacto() {
	}

	public Long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(Long idContacto) {
		this.idContacto = idContacto;
	}

	public String getCorreoResidente() {
		return correoResidente;
	}

	public void setCorreoResidente(String correoResidente) {
		this.correoResidente = correoResidente;
	}

	public Long getTelefonoResidente() {
		return telefonoResidente;
	}

	public void setTelefonoResidente(Long telefonoResidente) {
		this.telefonoResidente = telefonoResidente;
	}

}
