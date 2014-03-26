package com.prestafacturaService.mongo.dto;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="totalesFactura")
public class TotalesFactura extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 424938741603875705L;
	//TotalGrossAmount (3.1.5.1)
	private Double importeTotalBruto;
	//GeneralDicounts (3.1.5.2)
	@DBRef
	private Set<Descuento> descuentos;
	//GeneralSurcharges (3.1.5.3)
	@DBRef
	private Set<Cargo> cargos;
	//TotalGeneralDiscounts (3.1.5.4)
	private Double totalDescuentos;
	//TotalGeneralSurcharges (3.1.5.5)
	private Double totalCargaos;
	//TotalGrossAmountBeforeTaxes (3.1.5.6) (Resultado de: importeBruto - totalDescuentos + totalCargos)
	private Double totalBruto;
	//TotalTaxOutputs (3.1.5.7)
	private Double totalImpuestosRepercutidos;
	//TotalTaxesWithheld (3.1.5.8) (En FacturaE 4.0 son opcionales)
	private Double totalImpuestosRetenidos;
	//TotalInvoice (3.1.5.9) (En FacturaE 4.0 no se debe reflejar los impuestos Retenidos en el total factura) (Resultado de: TotalGrossAmountBeforeTaxes + TotalTaxOutputs)
	private Double totalFactura;
	//TotalOutstandingAmount (3.1.5.13)
	private Double totalAPagar;
	//TotalPaymentsOnAccount (3.1.5.12)
	private Double totalAnticipos;
	//AmountsWithheld (3.1.5.14) (Se trata de un importe retenido hasta la finalizaci�n del proyecto, por tanto se trata de un vencimiento de un pago.)
	@DBRef
	private Impuesto impuestosRetenido;
	//TotalExecutableAmount (3.1.5.15) (Tal como se restan las retenciones, en este punto se deber�an restar los impuestos retenidos.)
	private Double totalEjecutar;
	

	public Double getImporteTotalBruto() {
		return importeTotalBruto;
	}
	public void setImporteTotalBruto(Double importeTotalBruto) {
		this.importeTotalBruto = importeTotalBruto;
	}
	public Set<Descuento> getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(Set<Descuento> descuentos) {
		this.descuentos = descuentos;
	}
	public Set<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(Set<Cargo> cargos) {
		this.cargos = cargos;
	}
	public Double getTotalDescuentos() {
		return totalDescuentos;
	}
	public void setTotalDescuentos(Double totalDescuentos) {
		this.totalDescuentos = totalDescuentos;
	}
	public Double getTotalCargaos() {
		return totalCargaos;
	}
	public void setTotalCargaos(Double totalCargaos) {
		this.totalCargaos = totalCargaos;
	}
	public Double getTotalBruto() {
		return totalBruto;
	}
	public void setTotalBruto(Double totalBruto) {
		this.totalBruto = totalBruto;
	}
	public Double getTotalImpuestosRepercutidos() {
		return totalImpuestosRepercutidos;
	}
	public void setTotalImpuestosRepercutidos(Double totalImpuestosRepercutidos) {
		this.totalImpuestosRepercutidos = totalImpuestosRepercutidos;
	}
	public Double getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}
	public void setTotalImpuestosRetenidos(Double totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}
	public Double getTotalFactura() {
		return totalFactura;
	}
	public void setTotalFactura(Double totalFactura) {
		this.totalFactura = totalFactura;
	}
	public Double getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	public Double getTotalAnticipos() {
		return totalAnticipos;
	}
	public void setTotalAnticipos(Double totalAnticipos) {
		this.totalAnticipos = totalAnticipos;
	}
	public Impuesto getImpuestosRetenido() {
		return impuestosRetenido;
	}
	public void setImpuestosRetenido(Impuesto impuestosRetenido) {
		this.impuestosRetenido = impuestosRetenido;
	}
	public Double getTotalEjecutar() {
		return totalEjecutar;
	}
	public void setTotalEjecutar(Double totalEjecutar) {
		this.totalEjecutar = totalEjecutar;
	}
}
