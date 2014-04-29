package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;


//Se utiliza una �nica entidad para especificar a la parte. No es necesario especificar entre entidad
//jur�dica o individuo
//Por tanto en Entidad Legal se especifica la parte si es jur�dica.
@Document(collection="entidadLegal")
public class EntidadLegal extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 614860609319258006L;
	//CorporateName (2.1.3.1.1)
	private String razonSocial;
	//TradeName (2.1.3.1.2)
	private String nombreComercial;
	//RegistrationData (2.1.3.1.3) (En FacturaE 4.0 -> No es necesario estructurar 
	//la informaci�n de registro. Se propone el uso de un identificador con el texto 
	//que se incluye en las facturas para identificar el registro.
	private String datosRegistrales;
	//Address (2.1.3.1.4) (En FacturaE 4.0 -> No hay distinci�n entre direcci�n 
	//postal en Espa�a y en el extranjero.
	@DBRef
	@CascadeSave
	private Direccion direccion;
	//ContactDetails (2.1.3.1.5) 
	@DBRef
	@CascadeSave
	private DetallesContacto detallesContacto;
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getDatosRegistrales() {
		return datosRegistrales;
	}
	public void setDatosRegistrales(String datosRegistrales) {
		this.datosRegistrales = datosRegistrales;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public DetallesContacto getDetallesContacto() {
		return detallesContacto;
	}
	public void setDetallesContacto(DetallesContacto detallesContacto) {
		this.detallesContacto = detallesContacto;
	}
	
}
