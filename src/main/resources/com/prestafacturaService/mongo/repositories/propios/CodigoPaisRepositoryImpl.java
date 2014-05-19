package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.CodigoPais;

public class CodigoPaisRepositoryImpl implements CodigoPaisRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public CodigoPais ObtenerCodigoPaisByForm(String codigoPaisEntrega) {
		Query query=new Query();
		query.addCriteria(Criteria.where("codigoPais").is(codigoPaisEntrega));
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(query, CodigoPais.class);
	}

}
