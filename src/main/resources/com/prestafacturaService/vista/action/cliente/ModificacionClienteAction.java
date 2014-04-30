package com.prestafacturaService.vista.action.cliente;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
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
	
	private Integer idCliente;
	private Collection<Cliente> clientesTrasBorrar;
	
	public String execute(){

		try {
			clienteManager.eliminarCliente(idCliente);
			logger.info("eliminacion cliente por id");
			addActionMessage("El cliente de ha eliminado correctamente");

			// obtenemos la lista de usuarios ya actualizados
			Collection<Cliente> clientes=clienteManager.obtenerClientes();
			this.setClientesTrasBorrar(clientes);
			logger.info("obtener la lista actualizada despues de borrar un cliente");

		}catch (Exception e) {
			addActionError("La eliminación del Cliente ha fallado");
			return INPUT;
		}
		return SUCCESS;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Collection<Cliente> getClientesTrasBorrar() {
		return clientesTrasBorrar;
	}

	public void setClientesTrasBorrar(Collection<Cliente> clientesTrasBorrar) {
		this.clientesTrasBorrar = clientesTrasBorrar;
	}
	
	
	
	
	
	
}
