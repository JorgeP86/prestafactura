package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "sequenceId")
public class SecuenceId extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id;
 
	private Integer seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
 

	
	
	
}
