package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="datosPago")
public class DatosPago extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7703051169905084732L;
	//InstallmentDueDate (3.1.7.1.1)
	private Date fechaVencimiento;
	//InstallmentAmount (3.1.7.1.2)
	private Double importeVencimiento;
	//PaymentsMeans (3.1.7.1.3)
	@DBRef
	private MetodoPago metodoPago;
	//PaymentChannelCode (Nuevo campo FacturaE 4.0)
	private Integer codigoCanalPago;
	//AccountToBeCredited (3.1.7.1.4)
	@DBRef
	private Cuenta cuenta;
	//PaymentReconciliationReference (3.1.7.1.5)
	private String RefPago;
	//CollectionAdditionalInformation (3.1.7.1.7)
	private String infoAdicional;
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Double getImporteVencimiento() {
		return importeVencimiento;
	}
	public void setImporteVencimiento(Double importeVencimiento) {
		this.importeVencimiento = importeVencimiento;
	}
	public MetodoPago getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Integer getCodigoCanalPago() {
		return codigoCanalPago;
	}
	public void setCodigoCanalPago(Integer codigoCanalPago) {
		this.codigoCanalPago = codigoCanalPago;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public String getRefPago() {
		return RefPago;
	}
	public void setRefPago(String refPago) {
		RefPago = refPago;
	}
	public String getInfoAdicional() {
		return infoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
}
