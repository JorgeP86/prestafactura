package com.prestafacturaService.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.prestafacturaService.mongo.dto.BaseEntity;


public class GenericRepositoryImpl<T extends BaseEntity> extends SimpleMongoRepository<T,ObjectId> implements GenericRepository<T> {
	@Autowired
	private MongoOperations mongoOperations;
	@Autowired
	private MongoEntityInformation<T,ObjectId> metadata;
	private Class<?> clazz;
	
	@Autowired
	public GenericRepositoryImpl(Class<?> clazz, MongoEntityInformation<T,ObjectId> entityInformation, MongoOperations mongoOperations) {
		super(entityInformation, mongoOperations);
		this.metadata = entityInformation;
		this.mongoOperations = mongoOperations;
		this.setClazz(clazz);
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	
}
