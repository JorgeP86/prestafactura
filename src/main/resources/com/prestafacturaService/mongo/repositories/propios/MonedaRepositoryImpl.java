package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Moneda;

public class MonedaRepositoryImpl implements MonedaRepositoryCustom{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Moneda obtenerMonedaByName(String monedafact) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("nombre").is(monedafact));
		return mongoTemplate.findOne(query, Moneda.class);
	}

}
