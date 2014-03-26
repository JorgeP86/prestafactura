package com.prestafacturaService.mongo.dto;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;

@Document(collection="factura")
public class Factura extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6161473096326535825L;
	//invoiceHeader (3.1.1)
	@DBRef
	@CascadeSave
	private Cabecera cabecera;
	//invoiceIssueData (3.1.2)
	@DBRef
	@CascadeSave
	private DatosEmisionFact datosEmisionFact;
	//taxesOutputs and taxesWithheld (3.1.3 y 3.1.4)
	@DBRef
	@CascadeSave
	private Set<Impuesto> impuestos;
	//invoiceTotals (3.1.5)
	@DBRef
	@CascadeSave
	private TotalesFactura totalesFactura;
	//item (3.1.6)
	@DBRef
	@CascadeSave
	private Set<Detalle> detalles;
	//paymentsDetails (3.1.7)
	@DBRef
	@CascadeSave
	private DatosPago datosPago;
	//legalLiterals (3.1.8)
	@DBRef
	@CascadeSave
	private List<Literales> literales;
	//AdditionalData (3.1.9)
	@DBRef
	@CascadeSave
	private DatosAdicionales datosAdicionales;
	//parties SellerParty->(2.1) BuyerParty->(2.2) PayeeParty->(2.3)
	@DBRef
	@CascadeSave
	private Set<FiguraFactura> figuraFactura;
	
	public Cabecera getCabecera() {
		return cabecera;
	}
	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}
	public DatosEmisionFact getDatosEmisionFact() {
		return datosEmisionFact;
	}
	public void setDatosEmisionFact(DatosEmisionFact datosEmisionFact) {
		this.datosEmisionFact = datosEmisionFact;
	}
	public Set<Impuesto> getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(Set<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}
	public TotalesFactura getTotalesFactura() {
		return totalesFactura;
	}
	public void setTotalesFactura(TotalesFactura totalesFactura) {
		this.totalesFactura = totalesFactura;
	}
	public Set<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(Set<Detalle> detalles) {
		this.detalles = detalles;
	}
	public DatosPago getDatosPago() {
		return datosPago;
	}
	public void setDatosPago(DatosPago datosPago) {
		this.datosPago = datosPago;
	}
	public List<Literales> getLiterales() {
		return literales;
	}
	public void setLiterales(List<Literales> literales) {
		this.literales = literales;
	}
	public DatosAdicionales getDatosAdicionales() {
		return datosAdicionales;
	}
	public void setDatosAdicionales(DatosAdicionales datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}
	public Set<FiguraFactura> getFiguraFactura() {
		return figuraFactura;
	}
	public void setFiguraFactura(Set<FiguraFactura> figuraFactura) {
		this.figuraFactura = figuraFactura;
	}
}
