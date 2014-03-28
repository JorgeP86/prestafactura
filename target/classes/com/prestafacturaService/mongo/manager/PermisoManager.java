package com.prestafacturaService.mongo.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.repositories.PermisoRepository;

@Service
public class PermisoManager {
	
	@Autowired
	private PermisoRepository permisoRepository;

	@SuppressWarnings("unchecked")
	public Collection<Permiso> ObtenerPermisosRol(Rol rol) {
		return (Collection<Permiso>)permisoRepository.findOne(rol.getID());
	}
	
	public Permiso savePermiso(Permiso permiso){
		return permisoRepository.save(permiso);
	}
}
