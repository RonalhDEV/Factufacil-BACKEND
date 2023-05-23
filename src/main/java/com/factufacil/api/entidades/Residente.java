package com.factufacil.api.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "residente")
public class Residente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idResidente")
	private Long idResidente;

	@Column(name = "nombreResidente", nullable = false, length = 100)
	private String nombreResidente;

	@Column(name = "apellidoResidente", nullable = false, length = 100)
	private String apellidoResidente;

	@Column(name = "documentoResidente", nullable = false, length = 20)
	private Long documentoResidente;

	@Column(name = "aptoResidente", nullable = false, length = 10)
	private Long aptoResidente;

	@Column(name = "torreResidente", nullable = false, length = 10)
	private Long torreResidente;

	public Residente() {
	}

	public Residente(Long idResidente) {
		this.idResidente = idResidente;
	}

	public Long getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(Long idResidente) {
		this.idResidente = idResidente;
	}

	public String getNombreResidente() {
		return nombreResidente;
	}

	public void setNombreResidente(String nombreResidente) {
		this.nombreResidente = nombreResidente;
	}

	public String getApellidoResidente() {
		return apellidoResidente;
	}

	public void setApellidoResidente(String apellidoResidente) {
		this.apellidoResidente = apellidoResidente;
	}

	public Long getDocumentoResidente() {
		return documentoResidente;
	}

	public void setDocumentoResidente(Long documentoResidente) {
		this.documentoResidente = documentoResidente;
	}

	public Long getAptoResidente() {
		return aptoResidente;
	}

	public void setAptoResidente(Long aptoResidente) {
		this.aptoResidente = aptoResidente;
	}

	public Long getTorreResidente() {
		return torreResidente;
	}

	public void setTorreResidente(Long torreResidente) {
		this.torreResidente = torreResidente;
	}
}
