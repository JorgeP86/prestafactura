package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="identificacionFiscal")
public class IdentificacionFiscal extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 324943980712494367L;
	private String identificacionFiscal;

	public String getIdentificacionFiscal() {
		return identificacionFiscal;
	}

	public void setIdentificacionFiscal(String identificacionFiscal) {
		this.identificacionFiscal = identificacionFiscal;
	}
	
}
