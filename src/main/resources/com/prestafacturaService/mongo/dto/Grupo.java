package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.prestafacturaService.mongo.util.CascadeSave;

@Document(collection="grupo")
public class Grupo extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 122776451961468264L;
	@DBRef
	@CascadeSave
	private TipoCambio tipoCambio;
	
	public TipoCambio getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(TipoCambio tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
}
