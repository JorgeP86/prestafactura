package com.prestafacturaService.vista.action.cliente;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.manager.ClienteManager;


public class ModificacionClienteAction extends ActionSupport {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private static final Logger logger = Logger.getLogger(ModificacionClienteAction.class);
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	@Autowired
	private ClienteManager clienteManager;
	
	private IdentificacionFiscal identificacionFiscal;
	public String execute(){

		try {
			Cliente client=new Cliente();
			client= clienteManager.buscarClienteByCIF(identificacionFiscal);
			clienteManager.eliminarCliente(client);
			logger.info("eliminacion cliente por id");
			addActionMessage("El cliente de ha eliminado correctamente");

		}catch (Exception e) {
			addActionError("La eliminaci�n del Cliente ha fallado");
			return INPUT;
		}
		return SUCCESS;
	}

	
	
	
	
	
	
	
}
