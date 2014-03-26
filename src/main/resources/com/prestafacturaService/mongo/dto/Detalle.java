package com.prestafacturaService.mongo.dto;

import java.io.File;
import java.util.Date;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="detalle")
public class Detalle extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5119740592877359427L;
	//-----------A partir de aqu� la aplicaci�n de facturaci�n entiende como Cabecera Detalles o General detalles-------------------//
	//LineID (3.1.6.1) Nuevo campo facturae 4.0
	private Integer lineaID;
	//IssuerContractReference (3.1.6.1.1)
	private String refContratoEmisor;
	//SequenceNumber (3.1.6.1.5) (Entiendo que: En Facturae 4.0 este dato pasa de Otros Datos a Cabecera de l�nea)
	private String numLineaDentroPedido;
	//DeliveryNotesReferences (3.1.6.1.6)
	@DBRef
	private Set<InformacionAlbaran> albaranes;
	//ItemDescription (3.1.6.1.7) (En FacturaE 4.0 ItemDescription pasa a ser opcional)
	private String descripcion;
	//Quantity (3.1.6.1.8)
	private Double cantidad;
	//UnitOfMeasure (3.1.6.1.9) (En FacturaE 4.0 este pasa a ser un atributo)
	private String unidadMedida;
	//UnitTaxWithoutTax (3.1.6.1.10)
	private Double precioUnitario;
	//TotalCost (3.1.6.1.11)
	private Double costeTotal;
	//GrossAmount (3.1.6.1.14)
	private Double importeBruto;
	//DiscountsAndRebates (3.1.6.1.12)
	@DBRef
	private Set<Descuento> descuentos;
	//Charges (3.1.6.1.13)
	@DBRef
	private Set<Cargo> cargos;
	//LineItemPeriod (3.1.6.1.17) (Periodo de prestaci�n de un servicio)
	private Date periodoServicio;  //En caso de facturar un servicio
	//TransactionDate (3.1.6.1.18) (Fecha concreta de entrega del bien o prestacion del servicio)
	private Date fechaOperacion;
	//AdditionalLineItemInformation (3.1.6.1.19)
	private String infoAdicional;
	//Extensions (3.1.6.1.20)
	private File extension;
	
	//-----------A partir de aqu� la aplicaci�n de facturaci�n entiende como Otros Datos-------------------//
	@DBRef
	private OtrosDatos otrosDatos;

	//-----------A partir de aqu� la aplicaci�n de facturaci�n entiende como Impuestos-------------------//
	//TaxesWitheld (3.1.6.1.15) (En FacturaE 4.0 los impuestos retenidos se incluyen como una forma de pago) (Entiendo que: en cada l�nea se especifica la retenci�n pero no afectar� al importe Total de cada producto)
	@DBRef
	private Set<Impuesto> impuestosRetenidos;
	//TaxesOutputs (3.1.6.1.16)
	@DBRef
	private Set<Impuesto> impuestosRepercutidos;
	
	
	//-----------Nuevos campos FacturaE 4.0 --------------------------//
	/*
	private String standardIdentifier;
	private String commodityClassification;
	private String commodityClassificationCode;
	private String classifiedTaxCategory;
	private Integer identifier;
	private Double percent;
	private String taxScheme;
	*/
	
	public Integer getLineaID() {
		return lineaID;
	}
	public void setLineaID(Integer lineaID) {
		this.lineaID = lineaID;
	}
	public String getRefContratoEmisor() {
		return refContratoEmisor;
	}
	public void setRefContratoEmisor(String refContratoEmisor) {
		this.refContratoEmisor = refContratoEmisor;
	}
	public String getNumLineaDentroPedido() {
		return numLineaDentroPedido;
	}
	public void setNumLineaDentroPedido(String numLineaDentroPedido) {
		this.numLineaDentroPedido = numLineaDentroPedido;
	}
	public Set<InformacionAlbaran> getAlbaranes() {
		return albaranes;
	}
	public void setAlbaranes(Set<InformacionAlbaran> albaranes) {
		this.albaranes = albaranes;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Double getCosteTotal() {
		return costeTotal;
	}
	public void setCosteTotal(Double costeTotal) {
		this.costeTotal = costeTotal;
	}
	public Double getImporteBruto() {
		return importeBruto;
	}
	public void setImporteBruto(Double importeBruto) {
		this.importeBruto = importeBruto;
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
	public Date getPeriodoServicio() {
		return periodoServicio;
	}
	public void setPeriodoServicio(Date periodoServicio) {
		this.periodoServicio = periodoServicio;
	}
	public Date getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public String getInfoAdicional() {
		return infoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	public OtrosDatos getOtrosDatos() {
		return otrosDatos;
	}
	public void setOtrosDatos(OtrosDatos otrosDatos) {
		this.otrosDatos = otrosDatos;
	}
	public Set<Impuesto> getImpuestosRetenidos() {
		return impuestosRetenidos;
	}
	public void setImpuestosRetenidos(Set<Impuesto> impuestosRetenidos) {
		this.impuestosRetenidos = impuestosRetenidos;
	}
	public Set<Impuesto> getImpuestosRepercutidos() {
		return impuestosRepercutidos;
	}
	public void setImpuestosRepercutidos(Set<Impuesto> impuestosRepercutidos) {
		this.impuestosRepercutidos = impuestosRepercutidos;
	}
	public File getExtension() {
		return extension;
	}
	public void setExtension(File extension) {
		this.extension = extension;
	}
	
}
