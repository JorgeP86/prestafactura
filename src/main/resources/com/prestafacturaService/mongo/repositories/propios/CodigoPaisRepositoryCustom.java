package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.CodigoPais;

public interface CodigoPaisRepositoryCustom {

	public CodigoPais ObtenerCodigoPaisByForm(String codigoPaisEntrega);
}
