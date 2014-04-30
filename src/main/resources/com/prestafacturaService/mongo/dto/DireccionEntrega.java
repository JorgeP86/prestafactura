package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="direccionEntrega")
public class DireccionEntrega extends Direccion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1833342477950792390L;
	//ActualDeliveryDate
	private Date fechaEntrega;
	
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

}
