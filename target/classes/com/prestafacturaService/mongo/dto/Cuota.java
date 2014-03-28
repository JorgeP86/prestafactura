package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cuota")
public class Cuota extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -756134404432229177L;
	private Double cuota;
	@DBRef
	private Grupo grupo;
	
	public Double getCuota() {
		return cuota;
	}
	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
