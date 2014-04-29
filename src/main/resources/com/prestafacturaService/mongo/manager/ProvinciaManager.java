package com.prestafacturaService.mongo.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.repositories.ProvinciaRepository;


public class ProvinciaManager {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;

	public Provincia obtenerProvinciaByName(String provinciaEntrega) {
		// TODO Auto-generated method stub
		return provinciaRepository.obtenerProvinciaByName(provinciaEntrega);
	}
	
	

}
