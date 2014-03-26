package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="codigoPais")
public class CodigoPais extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8688305370555587602L;
	private String codigoPais;
	
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	
}
