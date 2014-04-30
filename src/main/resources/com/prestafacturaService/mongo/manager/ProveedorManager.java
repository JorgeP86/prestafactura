package com.prestafacturaService.mongo.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
	
	
}
