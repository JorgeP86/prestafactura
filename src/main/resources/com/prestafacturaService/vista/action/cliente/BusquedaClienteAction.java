package com.prestafacturaService.vista.action.cliente;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.manager.ClienteManager;


public class BusquedaClienteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final Logger logger = Logger.getLogger(BusquedaClienteAction.class);
	
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
	private ClienteManager clienteManager;
	
	private Cliente clienteBusqueda;
	private IdentificacionFiscal idFiscal;
	
		public String execute(){
		
			try{
			clienteBusqueda=clienteManager.buscarClienteByCIF(idFiscal);
			logger.info("Busqueda de cliente por parámetros");
			if(clienteBusqueda==null){
				addActionMessage("No hay clientes con esos valores");
				return INPUT;
			}
			
			
		}catch(Exception e){
			addActionError("La busqueda del cliente ha fallado");
			return INPUT;
		}
	return SUCCESS;
}

		public ClienteManager getClienteManager() {
			return clienteManager;
		}

		public void setClienteManager(ClienteManager clienteManager) {
			this.clienteManager = clienteManager;
		}

		public IdentificacionFiscal getIdFiscal() {
			return idFiscal;
		}

		public void setIdFiscal(IdentificacionFiscal idFiscal) {
			this.idFiscal = idFiscal;
		}

		public Cliente getClienteBusqueda() {
			return clienteBusqueda;
		}

		public void setClienteBusqueda(Cliente clienteBusqueda) {
			this.clienteBusqueda = clienteBusqueda;
		}
		
		
		
}