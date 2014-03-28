package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cuenta")
public class Cuenta extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1057111273359335358L;
	//IBAN + accountNumber (3.1.7.1.4.1) (En FacturaE 4.0 Se unen en el elemento identificador.)
	private String ibanNumeroCuenta;
	//BankCode (3.1.7.1.4.2)
	private String codigoEntidadFinanciera;
	//BranchCode (3.1.7.1.4.3)
	private String codigoOficina;
	//Address (3.1.7.1.4.4) (Una sola direcci�n independientemente de si es en Espa�a o en el extranjero.)
	@DBRef
	private Direccion direccion;
	
	public String getIbanNumeroCuenta() {
		return ibanNumeroCuenta;
	}
	public void setIbanNumeroCuenta(String ibanNumeroCuenta) {
		this.ibanNumeroCuenta = ibanNumeroCuenta;
	}
	public String getCodigoEntidadFinanciera() {
		return codigoEntidadFinanciera;
	}
	public void setCodigoEntidadFinanciera(String codigoEntidadFinanciera) {
		this.codigoEntidadFinanciera = codigoEntidadFinanciera;
	}
	public String getCodigoOficina() {
		return codigoOficina;
	}
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
