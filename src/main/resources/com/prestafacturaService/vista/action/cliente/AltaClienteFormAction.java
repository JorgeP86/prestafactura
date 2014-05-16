package com.prestafacturaService.vista.action.cliente;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;


public class AltaClienteFormAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AltaClienteFormAction.class);

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	
	
	public String execute() {
		try{
			
		}catch(Exception e){
			addActionError("Fallo al obtener datos para el formulario AltaCliente");
			return ERROR;
		}
		return SUCCESS;
	}


	
}
