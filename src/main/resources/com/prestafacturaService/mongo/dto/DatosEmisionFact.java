package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="datosEmisionFact")
public class DatosEmisionFact extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8287543782847342016L;
	//IssueDate (3.1.2.1)
	private Date fechaExpedicion;
	//OperationDate (3.1.2.1)
	private Date fechaOperacion;
	//InvoicingPeriod (3.1.2.3) Indicar fecha inicio y fecha fin
	@DBRef
	private Fechas periodoFacturacion;
	//InvoiceCurrencyCode (3.1.2.4)
	@DBRef
	private Moneda monedaOperacion;
	//ExchangeRateDetails (3.1.2.5)
	@DBRef
	private TipoCambio tipoCambio;
	//TaxCurrencyCode (3.1.2.6)
	@DBRef
	private Moneda monedaImpuesto;
	//LanguageName (3.1.2.7)
	private String lengua;
	//Endpoint (a partir del 3.1.2.7)
	@DBRef
	private Direccion dirEntrega;
	
	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	public Date getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public Fechas getPeriodoFacturacion() {
		return periodoFacturacion;
	}
	public void setPeriodoFacturacion(Fechas periodoFacturacion) {
		this.periodoFacturacion = periodoFacturacion;
	}
	public Moneda getMonedaOperacion() {
		return monedaOperacion;
	}
	public void setMonedaOperacion(Moneda monedaOperacion) {
		this.monedaOperacion = monedaOperacion;
	}
	public TipoCambio getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(TipoCambio tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public Moneda getMonedaImpuesto() {
		return monedaImpuesto;
	}
	public void setMonedaImpuesto(Moneda monedaImpuesto) {
		this.monedaImpuesto = monedaImpuesto;
	}
	public String getLengua() {
		return lengua;
	}
	public void setLengua(String lengua) {
		this.lengua = lengua;
	}
	public Direccion getDirEntrega() {
		return dirEntrega;
	}
	public void setDirEntrega(Direccion dirEntrega) {
		this.dirEntrega = dirEntrega;
	}
	
}
