package com.prestafacturaService.mongo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.repositories.RolRepository;


@Service
public class RolManager {
	
	@Autowired
	private RolRepository rolRepository;
	//private static ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
	
	
	
	public Rol saveRol(Rol rol){
		return rolRepository.save(rol);
	}
	
	public List<Rol> ObtenerRoles(){
		return rolRepository.findAll();
	}
	
	public Rol ObtenerRolByName(String nameRol){
		return rolRepository.ObtenerRolByName(nameRol);
	}

	public Boolean existsNombreRol(String nombreRol) {
		return rolRepository.existNombreRol(nombreRol);
	}
	
	public Rol ObtenerRolByidRol(Integer idRol){
		return rolRepository.ObtenerRolByidRol(idRol);
	}
	
	public Rol UpdateRol(Rol rol){
		return rolRepository.UpdateRol(rol);
	}

	public void bajaRol(Rol rol) {
		// TODO Auto-generated method stub
		rolRepository.delete(rol);
	}


}
