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

	public Collection<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	public void guardarCliente(Cliente clienteNuevo) {
		// TODO Auto-generated method stub
		clienteRepository.save(clienteNuevo);
	}

	public Cliente obtenerClienteById(Integer idCliente) {
		// TODO Auto-generated method stub
		return clienteRepository.obtenerClienteById(idCliente);
	}

	public Cliente updateCliente(Cliente clienteUpdate) {
		// TODO Auto-generated method stub
		return clienteRepository.updateCliente(clienteUpdate);
		
	}

	public void eliminarCliente(Integer idCliente) {
		Cliente clienteBorrar=clienteRepository.obtenerClienteById(idCliente);
		clienteRepository.delete(clienteBorrar);
		// TODO Auto-generated method stub
		
	}
}
