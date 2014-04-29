package com.prestafacturaService.mongo.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.repositories.ClienteRepository;


@Service
public class ClienteManager {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	public boolean existCliente(String identificacionFiscal){
		return clienteRepository.existCliente(identificacionFiscal);
		
	}

	public Collection<Cliente> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	public void guardarCliente(Cliente clienteNuevo) {
		// TODO Auto-generated method stub
		clienteRepository.save(clienteNuevo);
	}
}
