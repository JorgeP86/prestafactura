package com.prestafacturaService.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml","Test-applicationContext.xml"})
public class PermisoRepositoryTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Before
	public void setUp(){
		mongoTemplate.dropCollection("permiso");
		mongoTemplate.createCollection("permiso");
	}
	
	@Test
	public void test() {
	}
}
