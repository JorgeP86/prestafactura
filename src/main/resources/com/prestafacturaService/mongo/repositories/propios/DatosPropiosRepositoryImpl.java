package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.prestafacturaService.mongo.dto.DatosPropios;

public class DatosPropiosRepositoryImpl implements DatosPropiosRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	public Boolean existdtPropios(String identFiscal) {
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(identFiscal));
		return mongoTemplate.exists(query,DatosPropios.class);
	}

	public DatosPropios obtenerDtPropiosByid(int idDatosPropios) {
		Query query=new Query();
		query.addCriteria(Criteria.where("idDatosPropios").is(idDatosPropios));
		return mongoTemplate.findOne(query,DatosPropios.class);
	}

	public DatosPropios updateCliente(DatosPropios propiosModifica) {
		Query query=new Query();
		query.addCriteria(Criteria.where("idDatosPropios").is(propiosModifica.getIdDatosPropios()));
		Update update=new Update();
		if(propiosModifica.getNombre()!=null || !propiosModifica.getNombre().trim().equals("")){
			update.push("nombre", propiosModifica.getNombre());
			update.push("apellido1", propiosModifica.getApellido1());
			update.push("apellido2", propiosModifica.getApellido2());
			update.push("identificacionFiscal", propiosModifica.getIdentificacionFiscal());
			update.push("direccion", propiosModifica.getDireccion());
			update.push("dirEntrega", propiosModifica.getDirEntrega());

		}if(propiosModifica.getDetallesContacto().getTelefono()!=null || !propiosModifica.getDetallesContacto().getTelefono().trim().equals("")){
			update.push("detallesContacto", propiosModifica.getDetallesContacto());	
		}if(propiosModifica.getEntidadLegal().getNombreComercial()!=null || !propiosModifica.getEntidadLegal().getNombreComercial().trim().equals("")){
			update.push("entidadLegal", propiosModifica.getEntidadLegal());
			update.push("identificacionFiscal", propiosModifica.getIdentificacionFiscal());
			update.push("dirEntrega", propiosModifica.getDirEntrega());
			
		}
		return mongoTemplate.findAndModify(query, update, DatosPropios.class);
		
	}

	public DatosPropios obtenerDatosPropiosByFiscal(
			String idfiscal) {
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(idfiscal));
		return (DatosPropios) mongoTemplate.find(query, DatosPropios.class);
	}
	
}

