package com.prestafacturaService.mongo.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;


@Document(collection="permiso")
public class Permiso extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2289659181758762216L;
	@DBRef
	@CascadeSave
	private Recurso recurso;
	Map<String,String> permisos=new HashMap<String, String>();
	
	public Recurso getPagina() {
		return recurso;
	}
	public void setPagina(Recurso recurso) {
		this.recurso = recurso;
	}
	public Map<String,String> getPermisos() {
		return permisos;
	}
	public void setPermisos(Map<String,String> permisos) {
		this.permisos = permisos;
	}
	
	
	

}
