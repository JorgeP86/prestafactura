package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="documento")
public class Documento extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1045016323003110171L;
	
	private String compresion;
	private String format;
	private String encoding;
	private String descripcion;
	private String attachmentData;
	public String getCompresion() {
		return compresion;
	}
	public void setCompresion(String compresion) {
		this.compresion = compresion;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAttachmentData() {
		return attachmentData;
	}
	public void setAttachmentData(String attachmentData) {
		this.attachmentData = attachmentData;
	}
	
	
}