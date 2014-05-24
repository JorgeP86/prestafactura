package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Localidad;

public class LocalidadRepositoryImpl implements LocalidadRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Localidad obtenerLocalByName(String localidad) {
		Query query=new Query();
		query.addCriteria(Criteria.where("localidad").is(localidad));
		return mongoTemplate.findOne(query, Localidad.class);
	}

}
