package com.prestafacturaService.mongo.repositories.propios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public boolean existCliente(String identificacionFiscal) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(identificacionFiscal));
		return mongoTemplate.exists(query, Cliente.class);
	}

	public Cliente obtenerClienteById(Integer idCliente) {
		Query query=new Query();
		query.addCriteria(Criteria.where("idCliente").is(idCliente));
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(query, Cliente.class);
	}

	public Cliente updateCliente(Cliente clienteUpdate) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("idCliente").is(clienteUpdate.getIdCliente()));
		Update update=new Update();
		if(clienteUpdate.getNombre()!=null || !clienteUpdate.getNombre().trim().equals("")){
			update.push("nombre", clienteUpdate.getNombre());
			update.push("apellido1", clienteUpdate.getApellido1());
			update.push("apellido2", clienteUpdate.getApellido2());
			update.push("identificacionFiscal", clienteUpdate.getIdentificacionFiscal());
			update.push("direccion", clienteUpdate.getDireccion());
			update.push("dirEntrega", clienteUpdate.getDirEntrega());

		}if(clienteUpdate.getDetallesContacto().getTelefono()!=null || !clienteUpdate.getDetallesContacto().getTelefono().trim().equals("")){
			update.push("detallesContacto", clienteUpdate.getDetallesContacto());	
		}if(clienteUpdate.getEntidadLegal().getNombreComercial()!=null || !clienteUpdate.getEntidadLegal().getNombreComercial().trim().equals("")){
			update.push("entidadLegal", clienteUpdate.getEntidadLegal());
			update.push("identificacionFiscal", clienteUpdate.getIdentificacionFiscal());
			update.push("dirEntrega", clienteUpdate.getDirEntrega());
			
		}
		return mongoTemplate.findAndModify(query, update, Cliente.class);
		
	}

	public Cliente buscarClienteBycif(IdentificacionFiscal idFiscal) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("identificacionFiscal").is(idFiscal));
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(query, Cliente.class);
		
	}

}
