package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cargo")
public class Cargo extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2058876666706975698L;
	//ChargeReason (3.1.6.1.13.1.1)
	private String concepto;
	//ChargeRate (3.1.6.1.13.1.2)
	private Double porcentaje;
	//ChargeAmount (3.1.6.1.13.1.3)
	private Double importe;
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
}
