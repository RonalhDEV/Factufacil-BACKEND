package com.factufacil.api.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "login", uniqueConstraints = @UniqueConstraint(columnNames = "emailResidente"))
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLogin")
	private Long idLogin;

	@Column(name = "emailResidente", nullable = false)
	private String emailResidente;

	@Column(name = "claveResidente", nullable = false)
	private String claveResidente;

	public Login() {
	}

	public Long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public String getEmailResidente() {
		return emailResidente;
	}

	public void setEmailResidente(String emailResidente) {
		this.emailResidente = emailResidente;
	}

	public String getClaveResidente() {
		return claveResidente;
	}

	public void setClaveResidente(String claveResidente) {
		this.claveResidente = claveResidente;
	}

}
