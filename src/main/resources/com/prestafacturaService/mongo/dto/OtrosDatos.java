package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="otrosDatos")
public class OtrosDatos extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7761326453838154316L;
	//IssuerContractDate (3.1.6.1.1)
	private Date fechaContratoEmisor;
	//IssuerTransactionReference (3.1.6.1.2)
	private String refOperacionEmisor;
	//IssuerTransactionDate (3.1.6.1.2)
	private Date fechaOperacionEmisor;
	//ReceiverContractReference (3.1.6.1.3)
	private String refContratoReceptor;
	//ReceiverContractDate (3.1.6.1.3)
	private Date fechaContratoReceptor;
	//ReceiverTransactionReference (3.1.6.1.4)
	private String refOperacionReceptor;
	//ReceiverTransactionDate (3.1.6.1.4)
	private Date fechaOperacionReceptor;	
	//FileReference (3.1.6.1.5)
	private String refExpediente;
	//FileDate (3.1.6.1.5)
	private Date fechaExpediente;
	//ArticleCode (3.1.6.1.19) (En FacturaE 4.0 este atributo pasa a llamarse sellerIdentifier)
	private String identificadorVenta;
	
	
	public Date getFechaContratoEmisor() {
		return fechaContratoEmisor;
	}
	public void setFechaContratoEmisor(Date fechaContratoEmisor) {
		this.fechaContratoEmisor = fechaContratoEmisor;
	}
	public String getRefOperacionEmisor() {
		return refOperacionEmisor;
	}
	public void setRefOperacionEmisor(String refOperacionEmisor) {
		this.refOperacionEmisor = refOperacionEmisor;
	}
	public Date getFechaOperacionEmisor() {
		return fechaOperacionEmisor;
	}
	public void setFechaOperacionEmisor(Date fechaOperacionEmisor) {
		this.fechaOperacionEmisor = fechaOperacionEmisor;
	}
	public String getRefContratoReceptor() {
		return refContratoReceptor;
	}
	public void setRefContratoReceptor(String refContratoReceptor) {
		this.refContratoReceptor = refContratoReceptor;
	}
	public Date getFechaContratoReceptor() {
		return fechaContratoReceptor;
	}
	public void setFechaContratoReceptor(Date fechaContratoReceptor) {
		this.fechaContratoReceptor = fechaContratoReceptor;
	}
	public String getRefOperacionReceptor() {
		return refOperacionReceptor;
	}
	public void setRefOperacionReceptor(String refOperacionReceptor) {
		this.refOperacionReceptor = refOperacionReceptor;
	}
	public Date getFechaOperacionReceptor() {
		return fechaOperacionReceptor;
	}
	public void setFechaOperacionReceptor(Date fechaOperacionReceptor) {
		this.fechaOperacionReceptor = fechaOperacionReceptor;
	}
	public String getRefExpediente() {
		return refExpediente;
	}
	public void setRefExpediente(String refExpediente) {
		this.refExpediente = refExpediente;
	}
	public Date getFechaExpediente() {
		return fechaExpediente;
	}
	public void setFechaExpediente(Date fechaExpediente) {
		this.fechaExpediente = fechaExpediente;
	}
	public String getIdentificadorVenta() {
		return identificadorVenta;
	}
	public void setIdentificadorVenta(String identificadorVenta) {
		this.identificadorVenta = identificadorVenta;
	}
}
