package com.prestafacturaService.abstractTest;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import com.mongodb.Mongo;

public class ApplicationConfig extends AbstractMongoConfiguration {
	
	
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "prestafactura";
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
