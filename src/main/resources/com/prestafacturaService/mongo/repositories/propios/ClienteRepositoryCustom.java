package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Cliente;


public interface ClienteRepositoryCustom {

	public boolean existCliente(String identificacionFiscal);
	public Cliente obtenerClienteById(Integer idCliente);
	public Cliente updateCliente(Cliente clienteUpdate);
}
