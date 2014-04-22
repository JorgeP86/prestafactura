package com.prestafacturaService.mongo.repositories.propios;

import java.util.List;

import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;

public interface PermisoRepositoryCustom {
	public List buscarPermisoConPagRol(Recurso pagina, Rol rol);
}
