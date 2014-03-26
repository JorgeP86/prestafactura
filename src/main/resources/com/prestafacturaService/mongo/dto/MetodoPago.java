package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="metodoPago")
public class MetodoPago extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4605147685084909199L;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
