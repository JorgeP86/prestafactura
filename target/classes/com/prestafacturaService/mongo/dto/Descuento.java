package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="descuento")
public class Descuento extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3562507899163369787L;
	//DiscountReason (3.1.6.1.12.1.1)
	private String concepto;
	//DiscountRate (3.1.6.1.12.1.2)
	private Double porcentaje;
	//DiscountAmount (3.1.6.1.12.1.3)
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
	@Override
	public String toString() {
		return "Descuento [concepto=" + concepto + ", porcentaje=" + porcentaje
				+ ", importe=" + importe + "]";
	}
	
}
