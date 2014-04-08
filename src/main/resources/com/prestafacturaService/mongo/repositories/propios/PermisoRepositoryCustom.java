package com.prestafacturaService.mongo.repositories.propios;

import java.util.List;

import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Rol;

public interface PermisoRepositoryCustom {
	public List<Permiso> obtenerPermisosByRol(Rol rol);
}
