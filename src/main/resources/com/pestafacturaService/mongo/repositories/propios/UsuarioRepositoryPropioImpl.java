package com.pestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Usuario;

public class UsuarioRepositoryPropioImpl implements UsuarioRepositoryPropio{

	@Autowired
	 MongoTemplate mongoTemplate;
	
	public Usuario getUsuario(String username, String password){
		Query query = new Query();
	    query.addCriteria(Criteria.where("Login").is(username).and("Password").is(password));
		
		return (Usuario) mongoTemplate.find(query,Usuario.class);
	}
}
