package com.prestafacturaService.vista.action.factura;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarFiguraFacturaAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(EliminarFiguraFacturaAction.class);

	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private HttpServletRequest servletRequest;
	private Integer eliminarCliente;
	private Integer eliminarDatosPropios;
	
	
	
	public String execute(){
		try{
		if(eliminarCliente==1){
			servletRequest.getSession().setAttribute("figuraFacCliente", null);
			logger.info("Establecido a null la variable guardada en session de FiguraCliente");

		}if(eliminarDatosPropios==1){
			servletRequest.getSession().setAttribute("figuraFacDatosP", null);
			logger.info("Establecido a null la variable guardada en session de FiguraDatosPropios");

		}
			
		}catch(Exception e){
			 addActionError("Fallo al eliminar la Figura Factura");
				logger.info("Fallo al eliminar la figura factura");
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



	public Integer getEliminarCliente() {
		return eliminarCliente;
	}



	public void setEliminarCliente(Integer eliminarCliente) {
		this.eliminarCliente = eliminarCliente;
	}



	public Integer getEliminarDatosPropios() {
		return eliminarDatosPropios;
	}



	public void setEliminarDatosPropios(Integer eliminarDatosPropios) {
		this.eliminarDatosPropios = eliminarDatosPropios;
	}
	
	
	
	
}
