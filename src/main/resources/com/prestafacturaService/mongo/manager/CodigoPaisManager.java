package com.prestafacturaService.mongo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.repositories.CodigoPaisRepository;
@Service
public class CodigoPaisManager {

	@Autowired
	private CodigoPaisRepository codigoPaisRepository;
	
	
	public CodigoPais ObtenerCodigoPais(String codigoPaisEntrega){
		return codigoPaisRepository.ObtenerCodigoPaisByForm(codigoPaisEntrega);
		
	}
}
