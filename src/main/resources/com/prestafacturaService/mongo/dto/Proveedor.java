package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;


@Document(collection="Proveedor")
public class Proveedor extends BaseEntity{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Indexed(unique = true)
	private Integer idProveedor;
	@DBRef
	@CascadeSave
	private IdentificacionFiscal identificacionFiscal;
	//partyIdentification (2.1.2) (Identificaci�n de la entidad; Rellenar con el n�mero de referencia de la entidad del programa de facturaci�n que utilice)
	private String identificacionDeFigura;
	//Name
	private String nombre;
	//surname
	private String apellido2;
	private String apellido1;
	//Endpoint (nuevo campo Facturae 4.0 -> El EndpointID es un elemento que permite especificar la direcci�n de entrega de la factura electr�nica. Sustituye al centro administrativo)
	//legalEntity (2.1.4) (Persona jur�dica y otras)
	@DBRef
	@CascadeSave
	private EntidadLegal entidadLegal;
	//ContactDetails (2.1.3.1.7)
	@DBRef
	@CascadeSave
	private DetallesContacto detallesContacto;
	//Address (2.1.3.1.4.1) (en Facturae 4.0 ya no hay distimci�n entre addressInSpain y OverseasAddress)
	@DBRef
	@CascadeSave
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

	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
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
