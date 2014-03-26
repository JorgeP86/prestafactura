package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;


@Document(collection="facturaRectificativa")
public class FacturaRectificativa extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2858064238345086103L;
	private String numeroFactura;
	private String serie;
	private String codigoRazon;
	private String descripcionRazon;
	@DBRef
	@CascadeSave
	private Fechas periodoImpositivo;
	private String criterioRectificacion;
	private String descripcionCriterioRect;
	private String descripcionAdicionalCriterioRect;
	
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCodigoRazon() {
		return codigoRazon;
	}
	public void setCodigoRazon(String codigoRazon) {
		this.codigoRazon = codigoRazon;
	}
	public String getDescripcionRazon() {
		return descripcionRazon;
	}
	public void setDescripcionRazon(String descripcionRazon) {
		this.descripcionRazon = descripcionRazon;
	}
	public Fechas getPeriodoImpositivo() {
		return periodoImpositivo;
	}
	public void setPeriodoImpositivo(Fechas periodoImpositivo) {
		this.periodoImpositivo = periodoImpositivo;
	}
	public String getCriterioRectificacion() {
		return criterioRectificacion;
	}
	public void setCriterioRectificacion(String criterioRectificacion) {
		this.criterioRectificacion = criterioRectificacion;
	}
	public String getDescripcionCriterioRect() {
		return descripcionCriterioRect;
	}
	public void setDescripcionCriterioRect(String descripcionCriterioRect) {
		this.descripcionCriterioRect = descripcionCriterioRect;
	}
	public String getDescripcionAdicionalCriterioRect() {
		return descripcionAdicionalCriterioRect;
	}
	public void setDescripcionAdicionalCriterioRect(
			String descripcionAdicionalCriterioRect) {
		this.descripcionAdicionalCriterioRect = descripcionAdicionalCriterioRect;
	}
	
}
