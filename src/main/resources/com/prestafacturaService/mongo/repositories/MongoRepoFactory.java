package com.prestafacturaService.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class MongoRepoFactory<T extends MongoRepository<S,ObjectId>, S> extends MongoRepositoryFactoryBean<T,S,ObjectId>{
	
	protected RepositoryFactorySupport createRepositoryFactory(MongoOperations mongoOperations){
		return new BaseFactoryRepository(mongoOperations);
	}
	
	private static class BaseFactoryRepository extends MongoRepositoryFactory{
		
		MongoOperations mongoOperations;
		
		public BaseFactoryRepository(MongoOperations mongoOperations) {
			super(mongoOperations);
			this.mongoOperations = mongoOperations;
			// TODO Auto-generated constructor stub
		}


		@Override
		@SuppressWarnings({ "rawtypes", "unchecked" })
		protected Object getTargetRepository(RepositoryMetadata metadata){
			Class<?> clazz = metadata.getRepositoryInterface();
			MongoEntityInformation<?,String> entityInformation = getEntityInformation(metadata.getDomainType());
			return new GenericRepositoryImpl(clazz, entityInformation, mongoOperations);
		}
		
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){
			return GenericRepositoryImpl.class;
		}
	}
	
}
