package com.prestafacturaService.vista.action.cliente;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.manager.ClienteManager;

public class AccesoClientesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private static final Logger logger = Logger.getLogger(AccesoClientesAction.class);


	@Autowired
	private ClienteManager clienteManager;

	private Collection<Cliente> listaClientes;

	public String execute(){
		try {
			listaClientes=clienteManager.obtenerClientes();
			logger.info("Obtenida lista de clientes");
			if(listaClientes.size()==0){
				addActionMessage("No hay clientes para mostrar"); 
			}			 
		}catch(Exception e){			 
			addActionError("Fallo al realizar el acceso de los clientes");
			return ERROR;
		}
		return SUCCESS;
	 }

	public ClienteManager getClienteManager() {
		return clienteManager;
	}

	public void setClienteManager(ClienteManager clienteManager) {
		this.clienteManager = clienteManager;
	}

	public Collection<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(Collection<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
