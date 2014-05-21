package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Recurso;


public class RecursoRepositoryImpl implements RecursoRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Recurso obtenerPaginaBypath(String path) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("path").is(path));
		
		return mongoTemplate.findOne(query, Recurso.class);
	
	}

}
