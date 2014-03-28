package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;

//parties (2.0)
@Document(collection="figuraFactura")
public class FiguraFactura extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -634718540335904109L;
	//TaxIdentification
	@DBRef
	@CascadeSave
	private IdentificacionFiscal identificacionFiscal;
	//partyIdentification (2.1.2) (Identificaci�n de la entidad; Rellenar con el n�mero de referencia de la entidad del programa de facturaci�n que utilice)
	private String identificacionDeFigura;
	//Name
	private String nombre;
	//surname
	private String apellidos;
	//Endpoint (nuevo campo Facturae 4.0 -> El EndpointID es un elemento que permite especificar la direcci�n de entrega de la factura electr�nica. Sustituye al centro administrativo)
	@DBRef
	private Direccion dirEntrega;
	//legalEntity (2.1.4) (Persona jur�dica y otras)
	@DBRef
	private EntidadLegal entidadLegal;
	//ContactDetails (2.1.3.1.7)
	@DBRef
	private DetallesContacto detallesContacto;
	//Address (2.1.3.1.4.1) (en Facturae 4.0 ya no hay distimci�n entre addressInSpain y OverseasAddress)
	@DBRef
	private Direccion direccion;
	
	public IdentificacionFiscal getIdentificacionFiscal() {
		return identificacionFiscal;
	}
	public void setIdentificacionFiscal(IdentificacionFiscal identificacionFiscal) {
		this.identificacionFiscal = identificacionFiscal;
	}
	public String getIdentificacionDeFigura() {
		return identificacionDeFigura;
	}
	public void setIdentificacionDeFigura(String identificacionDeFigura) {
		this.identificacionDeFigura = identificacionDeFigura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDirEntrega() {
		return dirEntrega;
	}
	public void setDirEntrega(Direccion dirEntrega) {
		this.dirEntrega = dirEntrega;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public EntidadLegal getEntidadLegal() {
		return entidadLegal;
	}
	public void setEntidadLegal(EntidadLegal entidadLegal) {
		this.entidadLegal = entidadLegal;
	}
	public DetallesContacto getDetallesContacto() {
		return detallesContacto;
	}
	public void setDetallesContacto(DetallesContacto detallesContacto) {
		this.detallesContacto = detallesContacto;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
