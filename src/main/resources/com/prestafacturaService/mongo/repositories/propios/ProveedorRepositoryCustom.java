package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Proveedor;

public interface ProveedorRepositoryCustom {
	public boolean existsProveedor(IdentificacionFiscal idFiscal);
	public Proveedor obtenerProveedorByid(Integer idProveedor);
	public Proveedor updateProveedor(Proveedor proveedorSelec);
	public Proveedor obtenerProveedorBycif(IdentificacionFiscal idFiscal);
}
