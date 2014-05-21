package com.prestafacturaService.vista.action.factura;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Detalle;

public class CargarDatosFormFacturaAction  extends ActionSupport implements
ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger
			.getLogger(CargarDatosFormFacturaAction.class);
	
	private HttpServletRequest servletRequest;
	
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	
	

	public String execute(){
		
	try{
		
		Set<Detalle> detalles= new HashSet();
		servletRequest.getSession().setAttribute("setDetalles", detalles);
		logger.info("Inicializamos la lista de detalles vacia y lo guardamos en session");
	}catch(Exception e){
		 addActionError("Fallo al realizar el alta de la Factura");
		return ERROR;
	}
	return SUCCESS;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
