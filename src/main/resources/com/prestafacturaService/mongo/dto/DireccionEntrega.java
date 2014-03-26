package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="direccionEntrega")
public class DireccionEntrega extends Direccion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1833342477950792390L;
	//ActualDeliveryDate
	private Date fechaEntrega;
	//DeliveryLocation
	@DBRef
	private Localidad localidadEntrega;
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Localidad getLocalidadEntrega() {
		return localidadEntrega;
	}
	public void setLocalidadEntrega(Localidad localidadEntrega) {
		this.localidadEntrega = localidadEntrega;
	}
}
