package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="fechas")
public class Fechas extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4635860631582718260L;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
