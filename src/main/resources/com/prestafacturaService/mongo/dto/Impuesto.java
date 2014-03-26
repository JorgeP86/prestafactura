package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="impuesto")
public class Impuesto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6163945695737017697L;
	//Tipo de impuesto (Retenido y/o Repercutido)
	private String tipoImpuesto;
	//TaxTypeCode (3.1.3.1.1)
	private String claseImpuesto;
	//TaxCategoryID (Nuevo campo FacturaE 4.0)
	private Integer categoriaID;
	//TaxRate (3.1.3.1.2)
	private Double porcentaje;
	//TaxableBase (3.1.3.1.3)
	@DBRef
	private BaseImponible baseImponible;
	//TaxAmount (3.1.3.1.4)
	@DBRef
	private Cuota cuota; //resultado de aplicar a la baseImp el porcentaje
	//SpecialTaxableEvent (3.1.6.1.19) (FacturaE 4.0 -> Reubicaci�n a impuestos)
	@DBRef
	private ImpuestoEspecial impuestosEspeciales;
	
	public String getTipoImpuesto() {
		return tipoImpuesto;
	}
	public void setTipoImpuesto(String tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}
	public String getClaseImpuesto() {
		return claseImpuesto;
	}
	public void setClaseImpuesto(String claseImpuesto) {
		this.claseImpuesto = claseImpuesto;
	}
	public Integer getCategoriaID() {
		return categoriaID;
	}
	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}
	public Double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public BaseImponible getBaseImponible() {
		return baseImponible;
	}
	public void setBaseImponible(BaseImponible baseImponible) {
		this.baseImponible = baseImponible;
	}
	public Cuota getCuota() {
		return cuota;
	}
	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}
	public ImpuestoEspecial getImpuestosEspeciales() {
		return impuestosEspeciales;
	}
	public void setImpuestosEspeciales(ImpuestoEspecial impuestosEspeciales) {
		this.impuestosEspeciales = impuestosEspeciales;
	}
	
}
