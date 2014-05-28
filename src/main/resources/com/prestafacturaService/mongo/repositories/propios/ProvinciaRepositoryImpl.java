package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Provincia;

public class ProvinciaRepositoryImpl implements ProvinciaRepositoryCustom{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Provincia obtenerProvinciaByName(String provincia) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("provincia").is(provincia));
		return mongoTemplate.findOne(query, Provincia.class);
	}

}
