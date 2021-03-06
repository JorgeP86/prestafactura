package com.prestafacturaService.mongo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.repositories.PermisoRepository;

@Service
public class PermisoManager {
	
	@Autowired
	private PermisoRepository permisoRepository;

	@SuppressWarnings("unchecked")
	public List<Permiso> ObtenerPermisosRol(Rol rol) {
		return (List<Permiso>) permisoRepository.findOne(rol.getID());
	}
	
	public Permiso savePermiso(Permiso permiso){
		return permisoRepository.save(permiso);
	}

	public List<Permiso> buscarPermisoConPagRol(Recurso pagina, Rol rol) {	
		return permisoRepository.buscarPermisoConPagRol(pagina,rol);
	}

	public Permiso altaPermiso(Permiso permiso) {
		return permisoRepository.save(permiso);
		// TODO Auto-generated method stub
		
	}

	public void bajaPermiso(Permiso permiso) {
		permisoRepository.delete(permiso); 	
	}

	public List<Permiso> ObtenerPermisosByRol(Rol rol) {
		// TODO Auto-generated method stub
		return permisoRepository.obtenerPermisoByRol(rol);
	}
}
