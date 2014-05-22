package com.prestafacturaService.mongo.repositories.propios;

import java.util.List;

import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;

public interface PermisoRepositoryCustom {
	public List<Permiso> buscarPermisoConPagRol(Recurso pagina, Rol rol);
	public List<Permiso> obtenerPermisoByRol(Rol rol);
}
