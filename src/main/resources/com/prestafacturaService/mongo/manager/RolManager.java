package com.prestafacturaService.mongo.manager;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.repositories.RolRepository;


@Service
public class RolManager {
	
	@Autowired
	private RolRepository rolRepository;
	//private static ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
	
	public Rol obtenerRolByID(ObjectId id){
		//RolRepository m = ctx.getBean(RolRepository.class);
		//return m.findOne(id);
		return rolRepository.findOne(id);    	
	}
	
	public Rol saveRol(Rol rol){
		return rolRepository.save(rol);
	}
	
	public List<Rol> ObtenerRoles(){
		return rolRepository.findAll();
	}


}
