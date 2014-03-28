package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="baseImponible")
public class BaseImponible extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6265874176861312230L;

	private Double baseImponible;
	@DBRef
	private Grupo grupo;
	
	public Double getBaseImponible() {
		return baseImponible;
	}
	public void setBaseImponible(Double baseImponible) {
		this.baseImponible = baseImponible;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
