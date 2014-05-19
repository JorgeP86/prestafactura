package com.prestafacturaService.mongo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Moneda;
import com.prestafacturaService.mongo.repositories.MonedaRepository;

@Service
public class MonedaManager {
	
	@Autowired
	private MonedaRepository monedaRepository;
	
	public  Moneda ObtenerMoneda(String monedafact) {
		// TODO Auto-generated method stub
		return monedaRepository.obtenerMonedaByName(monedafact);
	}

}
