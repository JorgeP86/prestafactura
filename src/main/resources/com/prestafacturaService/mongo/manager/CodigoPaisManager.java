package com.prestafacturaService.mongo.manager;

import java.util.List;

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


	public List<CodigoPais> obtenerPais() {
		// TODO Auto-generated method stub
		return codigoPaisRepository.findAll();
	}
}
