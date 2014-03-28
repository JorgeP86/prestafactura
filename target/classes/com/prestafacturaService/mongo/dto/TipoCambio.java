package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="tipoCambio")
public class TipoCambio extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 836712959497159480L;
	//ExchangeRate (3.1.2.5.1)
	private Double porcentaje;
	//ExchangeRateDate (3.1.2.5.2)
	private Date fechaTipoCambio;
	

	public Double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Date getFechaTipoCambio() {
		return fechaTipoCambio;
	}
	public void setFechaTipoCambio(Date fechaTipoCambio) {
		this.fechaTipoCambio = fechaTipoCambio;
	}
}
