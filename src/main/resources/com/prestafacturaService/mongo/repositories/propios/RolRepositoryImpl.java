package com.prestafacturaService.mongo.repositories.propios;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.prestafacturaService.mongo.dto.Rol;

public class RolRepositoryImpl implements RolRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Rol ObtenerRolByName(String nameRol) {
		Query query = new Query();
		query.addCriteria(Criteria.where("nombre").is(nameRol));
		
		return mongoTemplate.findOne(query,Rol.class);
	}
	
	public Boolean existNombreRol(String nombreRol){
		Query query = new Query();
		query.addCriteria(Criteria.where("nombre").is(nombreRol));
	
		return mongoTemplate.exists(query,Rol.class);
		
	}
	
	public Rol ObtenerRolByidRol(Integer idrol){
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(idrol));
		
		return mongoTemplate.findOne(query, Rol.class);
		
	}

	public Rol UpdateRol(Rol rol) {
		Query query=new Query();
		ObjectId id=rol.getID();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update= new Update();
		update.push("nombre",rol.getNombre());
		update.push("descripcion", rol.getDescripcion());
		WriteResult w=mongoTemplate.updateFirst(query, update, Rol.class);
		return mongoTemplate.findById(rol.getID(), Rol.class);
	}

}
