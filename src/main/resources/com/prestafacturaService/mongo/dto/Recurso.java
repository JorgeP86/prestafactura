package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="recurso")
public class Recurso extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2887083669831054266L;
	private boolean enc=false;
	@Indexed(unique = true)
	private String idpagina;
	private String path;
	private String descripcion;
	private String ambito;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAmbito() {
		return ambito;
	}
	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}
	public boolean isEnc() {
		return enc;
	}
	public void setEnc(boolean enc) {
		this.enc = enc;
	}
	public String getIdpagina() {
		return idpagina;
	}
	public void setIdpagina(String idpagina) {
		this.idpagina = idpagina;
	}
	
	
	

}
