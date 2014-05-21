package com.prestafacturaService.vista.action.factura;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Detalle;

public class CrearDetallesAction extends ActionSupport implements
ServletRequestAware {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";

	private static final Logger logger = Logger
			.getLogger(CrearDetallesAction.class);

	private HttpServletRequest servletRequest;

	public String execute(){
		try{
			Detalle detalleNuevo= new Detalle();
			
			
			
			
			
			
			Set<Detalle> detalles=(Set<Detalle>) servletRequest.getSession().getAttribute("setDetalles");
			detalles.add(detalleNuevo);
			logger.info("sacamos de session el set<Detalle> y le añadimos el detalleNuevo");
			servletRequest.getSession().setAttribute("setDetalles", detalles);
			logger.info("Guardamos en session el set Detalle actualizado");
			
			
		}catch(Exception e){
			addActionError("Fallo al crear Detalles de la Factura");
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
