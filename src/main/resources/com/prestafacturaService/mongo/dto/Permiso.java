package com.prestafacturaService.mongo.dto;

import java.util.HashMap;
import java.util.Map;

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
	private Rol rol;
	Map<Recurso, Rol> permisosPR=new HashMap<Recurso, Rol>();
	
	
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
	public Map<Recurso, Rol> getPermisos() {
		return permisosPR;
	}
	public void setPermisos(Map<Recurso, Rol> permisos) {
		this.permisosPR = permisos;
	}
	
	
	
	

}
