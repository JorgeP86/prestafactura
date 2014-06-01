package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.DatosPropios;


public interface DatosPropiosRepositoryCustom {

	Boolean existdtPropios(String identFiscal);
	DatosPropios obtenerDtPropiosByid(int idDatosPropios);
	DatosPropios updateCliente(DatosPropios propiosModifica);
	DatosPropios obtenerDatosPropiosByFiscal(String idfiscal);

}
