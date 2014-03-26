package com.prestafacturaService.mongo.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

public abstract class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 925525405731598418L;
	@Id
	@Field("ID")
	private ObjectId ID;
	@Version
	@Field("version")
	private Long version;
	
	public ObjectId getID() {
		return ID;
	}
	public void setID(ObjectId iD) {
		ID = iD;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
}
