package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;

//InvoiceHeader
@Document(collection="cabecera")
public class Cabecera extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1335546909223120789L;
	//invoiceID = invoiceNumber + invoiceSerieCode
	@Indexed(unique=true)
	private String facturaID;
	//invoiceDocumentType + invoiceClass 
	private String tipoFactura;
	//accountingCost
	private Double costeContable;
	//corrective
	@DBRef
	@CascadeSave
	private FacturaRectificativa factRectificativa;
	
	public String getFacturaID() {
		return facturaID;
	}
	public void setFacturaID(String facturaID) {
		this.facturaID = facturaID;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public Double getCosteContable() {
		return costeContable;
	}
	public void setCosteContable(Double costeContable) {
		this.costeContable = costeContable;
	}
	public FacturaRectificativa isFactRectificativa() {
		return factRectificativa;
	}
	public void setFactRectificativa(FacturaRectificativa factRectificativa) {
		this.factRectificativa = factRectificativa;
	}
	@Override
	public String toString() {
		return "Cabecera [facturaID=" + facturaID + ", tipoFactura="
				+ tipoFactura + ", costeContable=" + costeContable
				+ ", factRectificativa=" + factRectificativa + "]";
	}
	
}
