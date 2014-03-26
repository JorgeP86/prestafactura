package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="impuestoEspecial")
public class ImpuestoEspecial extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6650557388206914397L;
	//SpecialTaxableEventCode (3.1.6.1.19)
	private String codImpuestoEspecial;
	//SpecialTaxableEventReason (3.1.6.1.19)
	private String razonImpuestoEspecial;

	public String getCodImpuestoEspecial() {
		return codImpuestoEspecial;
	}
	public void setCodImpuestoEspecial(String codImpuestoEspecial) {
		this.codImpuestoEspecial = codImpuestoEspecial;
	}
	public String getRazonImpuestoEspecial() {
		return razonImpuestoEspecial;
	}
	public void setRazonImpuestoEspecial(String razonImpuestoEspecial) {
		this.razonImpuestoEspecial = razonImpuestoEspecial;
	}
}
