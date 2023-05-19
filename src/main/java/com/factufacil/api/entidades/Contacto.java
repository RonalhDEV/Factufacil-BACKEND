package com.factufacil.api.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idContacto")
	private Long idContacto;

	@Column(name = "correoResidente", nullable = false, length = 100)
	private String correoResidente;

	@Column(name = "telefonoResidente", nullable = false, length = 20)
	private Long telefonoResidente;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idResidente", unique = true, referencedColumnName = "idResidente", nullable = true, updatable = true)
	private Residente idResidente;

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

	public Residente getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(Residente idResidente) {
		this.idResidente = idResidente;
	}

}
