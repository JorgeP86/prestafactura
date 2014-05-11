package com.prestafacturaService.mongo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.DatosPropios;
import com.prestafacturaService.mongo.repositories.DatosPropiosRepository;

@Service
public class DatosPropiosManager {

	@Autowired
	private DatosPropiosRepository datosPropiosRepository;

	public List<DatosPropios> obtenerDatosPropios() {
		return datosPropiosRepository.findAll();
	}

	public boolean existedatosPropios(String dtpropiosform) {
		return datosPropiosRepository.existdtPropios(dtpropiosform);
	}

	public void guardarCliente(DatosPropios datosPropiosNuevo) {
		// TODO Auto-generated method stub
		datosPropiosRepository.save(datosPropiosNuevo);
	}

	public DatosPropios obtenerDatosPropiosByid(int idDatosPropios) {
		// TODO Auto-generated method stub
		return datosPropiosRepository.obtenerDtPropiosByid(idDatosPropios);
	}

	public DatosPropios updateCliente(DatosPropios propiosModifica) {
		// TODO Auto-generated method stub
		return datosPropiosRepository.updateCliente(propiosModifica);
	}
	
	




}
