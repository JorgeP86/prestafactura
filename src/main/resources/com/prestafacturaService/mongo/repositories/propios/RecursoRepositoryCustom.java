package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Recurso;

public interface RecursoRepositoryCustom {
	public Recurso obtenerPaginaBypath(String path);

}
