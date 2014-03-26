package com.prestafacturaService.mongo.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


//Clase antigua de FacturaE 3.2, para FacturaE 4.0 cambian los campos
@Document(collection="datosAdicionales")
public class DatosAdicionales extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2898520929525191547L;
	private String facturaAsociada; //n�mero y serie de emisor/receptor
	private String observaciones;
	private String ficheros;
	@DBRef
	private Set<Documento> documentos= new HashSet<Documento>();
	
	public String getFacturaAsociada() {
		return facturaAsociada;
	}
	public void setFacturaAsociada(String facturaAsociada) {
		this.facturaAsociada = facturaAsociada;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getFicheros() {
		return ficheros;
	}
	public void setFicheros(String ficheros) {
		this.ficheros = ficheros;
	}
	public Set<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	} 
	
}
