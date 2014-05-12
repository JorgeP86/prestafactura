package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Proveedor;

public class ProveedorRepositoryImpl implements ProveedorRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public boolean existsProveedor(IdentificacionFiscal idFiscal) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(idFiscal));
		return mongoTemplate.exists(query, Proveedor.class) ;
	}

	public Proveedor obtenerProveedorByid(Integer idProveedor) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("idProveedor").is(idProveedor));
		return mongoTemplate.findOne(query, Proveedor.class);
	}

	public Proveedor updateProveedor(Proveedor proveedorSelec) {
		Query query=new Query();
		query.addCriteria(Criteria.where("idProveedor").is(proveedorSelec.getIdProveedor()));
		
		//terminar.........
		
		
		return null;
	}

	public Proveedor obtenerProveedorBycif(IdentificacionFiscal idFiscal) {
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(idFiscal));
		return mongoTemplate.findOne(query, Proveedor.class);
	}

}
