package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Moneda;

public interface MonedaRepositoryCustom {
	public Moneda obtenerMonedaByName(String monedafact);
}
