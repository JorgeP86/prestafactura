package com.prestafacturaService.mongo.repositories.propios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;


public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Usuario getUsuario(String username, String password){
		Query query = new Query();
	    query.addCriteria(Criteria.where("login").is(username).and("password").is(password));
		
		return mongoTemplate.findOne(query,Usuario.class);
	}
	
	public Boolean existsUsuario(String username, String password){
		Query query= new Query();
		query.addCriteria(Criteria.where("login").is(username).and("password").is(password));
		
		return mongoTemplate.exists(query, Usuario.class);
		
	}

	public List usuariosConRol(Rol rol) {
		Query query= new Query();
		query.addCriteria(Criteria.where("rol").is(rol));
		return mongoTemplate.find(query, Usuario.class);

	}
	
}
