package com.prestafacturaService.mongo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.repositories.LocalidadRepository;

@Service
public class LocalidadManager {

	@Autowired
	private LocalidadRepository localidadRepository;
	
	public List<Localidad> obtenerLocalidades(){
		return localidadRepository.findAll();
	}

	public Localidad obtenerLocalidadByName(String localidad) {
		return localidadRepository.obtenerLocalByName(localidad);
	}
}
