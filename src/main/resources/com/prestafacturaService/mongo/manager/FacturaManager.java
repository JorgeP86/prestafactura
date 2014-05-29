package com.prestafacturaService.mongo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Factura;
import com.prestafacturaService.mongo.repositories.FacturaRepository;



@Service
public class FacturaManager {
	
	@Autowired
	private FacturaRepository facturaRepository;
	

	public Factura ObtenerFacturaByfacturaID(String facturaID) {
		// TODO Auto-generated method stub
		return facturaRepository.obtenerFacturaByID(facturaID);
	}
	
	
}
