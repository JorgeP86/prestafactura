package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="moneda")
public class Moneda extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6359475269498596706L;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
