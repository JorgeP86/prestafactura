package com.prestafacturaService.mongo.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.repositories.ProveedorRepository;


@Service
public class ProveedorManager {

	@Autowired
	private ProveedorRepository proveedorRepository;

	public Collection<Proveedor> obtenerProveedores() {
		// TODO Auto-generated method stub
		return proveedorRepository.findAll();
	}

	public boolean existProveedor(IdentificacionFiscal idFiscal) {
		// TODO Auto-generated method stub
		return proveedorRepository.existsProveedor(idFiscal);
	}

	public Proveedor saveProveedor(Proveedor proveedorNuevo) {
		// TODO Auto-generated method stub
		return proveedorRepository.save(proveedorNuevo);
	}

	public Proveedor obtenerProveedorByid(Integer idProveedor) {
		// TODO Auto-generated method stub
		return proveedorRepository.obtenerProveedorByid(idProveedor);
	}

	public Proveedor UpdateProveedor(Proveedor proveedorSelec) {
		// TODO Auto-generated method stub
		return proveedorRepository.updateProveedor(proveedorSelec);
	}
	
	
	
	
	
}
