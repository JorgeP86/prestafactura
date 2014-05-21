package com.prestafacturaService.mongo.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.repositories.RecursoRepository;


public class RecursoManager {
	@Autowired
	private RecursoRepository recursoRepository;

	public Collection<Recurso> obtenerPaginas() {
		// TODO Auto-generated method stub
		return recursoRepository.findAll();
	}

	public Recurso obtenerPaginaBypath(String path) {
		// TODO Auto-generated method stub
		return recursoRepository.obtenerPaginaBypath(path);
	}

}
