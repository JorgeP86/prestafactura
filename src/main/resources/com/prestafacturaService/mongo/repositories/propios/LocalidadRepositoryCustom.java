package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Localidad;

public interface LocalidadRepositoryCustom {
	Localidad obtenerLocalByName(String localidad);
}
