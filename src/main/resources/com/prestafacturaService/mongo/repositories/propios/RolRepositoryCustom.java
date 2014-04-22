package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Rol;

public interface RolRepositoryCustom {
	
	public Rol ObtenerRolByName(String nameRol);
	public Rol ObtenerRolByidRol(Integer idrol);
	public Boolean existNombreRol(String nombreRol);
	public Rol UpdateRol(Rol rol);

}
