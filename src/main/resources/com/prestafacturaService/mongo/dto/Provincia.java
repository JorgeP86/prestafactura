package com.prestafacturaService.mongo.dto;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="provincia")
public class Provincia extends BaseEntity implements Comparable<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4381836497330168644L;
	private String provincia;
	@DBRef
	private Set<Localidad> localidades;
	

	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Set<Localidad> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(Set<Localidad> localidades) {
		this.localidades = localidades;
	}
	public int compareTo(Object o) {
		Provincia prov = (Provincia)o;
		return provincia.compareTo(prov.getProvincia());
	}
}
