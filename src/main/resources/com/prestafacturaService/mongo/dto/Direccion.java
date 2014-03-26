package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="direccion")
public class Direccion extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7586580940674569187L;
	//StreetName (antes llamado Address)
	private String calle;
	//BuildingNumber (Nuevo campo FacturaE 4.0)
	private String numeroEdificio;
	//AdditionalStreetName (Nuevo campo FacturE 4.0)
	private String calleAdicional;
	//Departament (Nuevo campo FacturaE 4.0 -> Departamento para routing interno)
	private String departamento;
	//PostCode
	private String codigoPostal;
	//Town
	@DBRef
	private Localidad localidad;
	//Province
	@DBRef
	private Provincia provincia;
	//CountryCode
	@DBRef
	private CodigoPais codigoPais;
	//PostBox
	private String postBox;
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroEdificio() {
		return numeroEdificio;
	}
	public void setNumeroEdificio(String numeroEdificio) {
		this.numeroEdificio = numeroEdificio;
	}
	public String getCalleAdicional() {
		return calleAdicional;
	}
	public void setCalleAdicional(String calleAdicional) {
		this.calleAdicional = calleAdicional;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public CodigoPais getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(CodigoPais codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getPostBox() {
		return postBox;
	}
	public void setPostBox(String postBox) {
		this.postBox = postBox;
	}
}
