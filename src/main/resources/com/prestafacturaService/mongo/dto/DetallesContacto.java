package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="detallesContacto")
public class DetallesContacto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7930702016547678569L;
	private String telefono;
	private String fax;
	private String direccionWeb;
	private String mail;
	private String personaContacto;
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDireccionWeb() {
		return direccionWeb;
	}
	public void setDireccionWeb(String direccionWeb) {
		this.direccionWeb = direccionWeb;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPersonaContacto() {
		return personaContacto;
	}
	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}
	
}
