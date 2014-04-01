package com.prestafacturaService.mongo.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="informacionAlbaran")
public class InformacionAlbaran extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5241126288777740708L;
	//DeliveryNoteNumber (3.1.6.1.6.1.1)
	private String numRefAlbaran;
	//DeliveryNoteDate (3.1.6.1.6.1.1)
	private Date fechaRefAlbaran;

	public String getNumRefAlbaran() {
		return numRefAlbaran;
	}
	public void setNumRefAlbaran(String numRefAlbaran) {
		this.numRefAlbaran = numRefAlbaran;
	}
	public Date getFechaRefAlbaran() {
		return fechaRefAlbaran;
	}
	public void setFechaRefAlbaran(Date fechaRefAlbaran) {
		this.fechaRefAlbaran = fechaRefAlbaran;
	}
}
