package com.prestafacturaService.vista.action.factura;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class EliminarDetalleAction  extends ActionSupport implements
ServletRequestAware {
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";

	private static final Logger logger = Logger
			.getLogger(EliminarDetalleAction.class);

	private HttpServletRequest servletRequest;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
