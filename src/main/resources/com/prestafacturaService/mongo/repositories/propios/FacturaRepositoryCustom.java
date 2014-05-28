package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Factura;

public interface FacturaRepositoryCustom {
	Factura obtenerFacturaByID(String facturaID);
}
