package com.prestafacturaService.mongo.dto;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;

@Document(collection="rol")
public class Rol extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4619067839399826231L;
	private String nombre;
	private String descripcion;
	@DBRef
	private List<Permiso> permisos;
	

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Permiso> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

}
