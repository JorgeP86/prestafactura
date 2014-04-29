package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Cliente;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public boolean existCliente(String identificacionFiscal) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(identificacionFiscal));
		return mongoTemplate.exists(query, Cliente.class);
	}

}
