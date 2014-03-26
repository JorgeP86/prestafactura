package com.prestafacturaService.abstractTest;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.Mongo;
import com.opensymphony.xwork2.interceptor.annotations.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:Test-applicationContext.xml"})
public abstract class AbstractIntegrationTest {
	
	@Autowired
	private Mongo mongo;
	
	@Before
	public void setUp(){
		DB database = mongo.getDB("prestafactura");
		
		DBCollection cabecera = database.getCollection("cabecera");
		cabecera.drop();
		DBObject facturaID = new BasicDBObject("facturaID", "23A");
		DBObject costeContable = new BasicDBObject("costeContable", 10.0);
		DBObject tipoFactura = new BasicDBObject("tipoFactura", "Completa");
		cabecera.insert(facturaID, costeContable, tipoFactura);
		
		DBCollection facturaRectificativa = database.getCollection("facturaRectificativa");
		facturaRectificativa.drop();
		BasicDBObject numeroFactura = new BasicDBObject("numeroFactura", 1);
		BasicDBObject serie = new BasicDBObject("serie", "A");
		BasicDBObject codigoRazon = new BasicDBObject("codigoRaz�n", "codigoRazon");
		BasicDBObject descripcionRazon = new BasicDBObject("descripcionRazon", "descripcionRazon");
		BasicDBObject criterioRectificacion = new BasicDBObject("criterioRectificacion", "criterioRectificacion");
		BasicDBObject descripcionCriterioRec = new BasicDBObject("descripcionCriterioRec", "descripcionCriterioRectification");
		BasicDBObject descripcionAdicionalCriterioRec = new BasicDBObject("descripcionAdicionalCriterioRec", "descripcionAdicionalCriterioRectificacion");
		DBRef ref = new DBRef(database, "cabecera", cabecera.findOne().get("_id"));
		DBObject cabeceraRef = new BasicDBObject("cabecera", ref);
		facturaRectificativa.insert(numeroFactura, 
				serie, codigoRazon, descripcionRazon, 
				criterioRectificacion, descripcionCriterioRec, descripcionAdicionalCriterioRec, cabeceraRef);
		
		DBCollection fecha = database.getCollection("fechas");
		fecha.drop();
		BasicDBObject fechaInicio = new BasicDBObject("Fecha inicio", new Date());
		BasicDBObject fechaFin = new BasicDBObject("Fecha fin", new Date());
		DBRef refFecha = new DBRef(database, "facturaRectificativa", facturaRectificativa.findOne(numeroFactura));
		DBObject fechasRef = new BasicDBObject("facturaRectificativa", refFecha);
		fecha.insert(fechaInicio, fechaFin, fechasRef);
		
	}
		
	
	
}
