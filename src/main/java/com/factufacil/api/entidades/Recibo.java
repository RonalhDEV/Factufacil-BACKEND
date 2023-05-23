package com.factufacil.api.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recibo")
public class Recibo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRecibo")
	private Long idRecibo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idResidente", referencedColumnName = "idResidente", nullable = false, updatable = true)
	private Residente idResidente;

	@Column(name = "fechaDePago", nullable = false)
	private LocalDate fechaDePago;

	@Column(name = "valorAPagar", nullable = false, precision = 12, scale = 2)
	private Double valorAPagar;

	@Column(name = "periodoDeCobro", nullable = false, length = 30)
	private String periodoDeCobro;

	@Column(name = "estadoDeRecibo", nullable = false, length = 30)
	private String estadoDeRecibo;


	public Recibo() {
	}

	public Long getIdRecibo() {
		return idRecibo;
	}

	public void setIdRecibo(Long idRecibo) {
		this.idRecibo = idRecibo;
	}

	public Residente getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(Residente idResidente) {
		this.idResidente = idResidente;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public Double getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(Double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	public String getPeriodoDeCobro() {
		return periodoDeCobro;
	}

	public void setPeriodoDeCobro(String periodoDeCobro) {
		this.periodoDeCobro = periodoDeCobro;
	}

	public String getEstadoDeRecibo() {
		return estadoDeRecibo;
	}

	public void setEstadoDeRecibo(String estadoDeRecibo) {
		this.estadoDeRecibo = estadoDeRecibo;
	}

}
