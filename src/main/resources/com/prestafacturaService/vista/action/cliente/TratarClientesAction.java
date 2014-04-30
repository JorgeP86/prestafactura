package com.prestafacturaService.vista.action.cliente;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.manager.ClienteManager;

public class TratarClientesAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(TratarClientesAction.class);

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	@Autowired
	public ClienteManager clienteManager;
	
	private Integer idCliente;
	private Cliente clienteModificacion;
	
	public String execute() {
		try{
			// Definimos si se ha elegido alta o modificacion
			
			if(idCliente>0){
				 logger.info("definir si es alta o modificacion usuario");
				 clienteModificacion= clienteManager.obtenerClienteById(idCliente);
					logger.info("obtener cliente por id");

			}
			
			
		}catch (Exception e) {
			addActionError("Fallo al tratar el Cliente");
			return ERROR;
		}
		return SUCCESS;
		
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente getClienteModificacion() {
		return clienteModificacion;
	}

	public void setClienteModificacion(Cliente clienteModificacion) {
		this.clienteModificacion = clienteModificacion;
	}
	
	
	
	
	
	
	
	
	
}
