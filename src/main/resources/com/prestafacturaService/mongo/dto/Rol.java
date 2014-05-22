package com.prestafacturaService.mongo.dto;

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

	private int idRol;
	


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

	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


}
