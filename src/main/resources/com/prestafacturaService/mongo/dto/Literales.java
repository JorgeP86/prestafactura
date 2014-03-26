package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="literales")
public class Literales extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3774506085674124805L;
	//Literales legales establecidos: Donaciones, Subvenciones,
	//Car�cter irreversible subvenciones, Atenci�n pago
	//moneda prevista, Proveedores residentes,etc
	private String nombreDelLiteral;

	public String getNombreDelLiteral() {
		return nombreDelLiteral;
	}
	public void setNombreDelLiteral(String nombreDelLiteral) {
		this.nombreDelLiteral = nombreDelLiteral;
	}
	
}
