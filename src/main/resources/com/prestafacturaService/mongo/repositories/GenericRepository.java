package com.prestafacturaService.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean //Para evitar que Spring instancie un repositorio de una interfaz 
public interface GenericRepository<T> extends MongoRepository<T, ObjectId> {
	
}
