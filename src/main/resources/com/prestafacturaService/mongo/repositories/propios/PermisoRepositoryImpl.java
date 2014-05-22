package com.prestafacturaService.mongo.repositories.propios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;

public class PermisoRepositoryImpl implements PermisoRepositoryCustom {
	@Autowired
	MongoTemplate mongoTemplate;
	

	public List<Permiso> buscarPermisoConPagRol(Recurso pagina, Rol rol) {
		Query query = new Query();
		query.addCriteria(Criteria.where("pagina").is(pagina).and("rol").is(rol));
		return mongoTemplate.find(query,Permiso.class);
	}


	public List<Permiso> obtenerPermisoByRol(Rol rol) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("rol").is(rol));
		return mongoTemplate.find(query,Permiso.class);
	}

}
