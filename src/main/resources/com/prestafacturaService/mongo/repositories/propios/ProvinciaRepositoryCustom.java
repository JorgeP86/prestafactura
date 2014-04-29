package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Provincia;

public interface ProvinciaRepositoryCustom {
	public Provincia obtenerProvinciaByName(String provincia);

}
