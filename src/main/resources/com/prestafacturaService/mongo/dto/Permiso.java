package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="permiso")
public class Permiso extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2289659181758762216L;

	@DBRef
	private Recurso recurso;
	@DBRef
	private Rol rol;

	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	
	
	
	

}
