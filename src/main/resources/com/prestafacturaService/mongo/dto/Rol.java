package com.prestafacturaService.mongo.dto;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="rol")
public class Rol extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4619067839399826231L;
	@Indexed(unique = true)
	private String nombre;
	private String descripcion;
	private List<Permiso> permisos;
	
	@Indexed(unique = true)
	private int idrol;
	

	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
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
