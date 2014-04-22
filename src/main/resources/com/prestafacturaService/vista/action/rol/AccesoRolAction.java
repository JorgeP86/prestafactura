package com.prestafacturaService.vista.action.rol;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.manager.RolManager;




public class AccesoRolAction extends ActionSupport implements ServletRequestAware{/**
	 * 
	 */
	private static final long serialVersionUID = 5134879089245551269L;


	@Autowired
	private RolManager rolManager;
	private HttpServletRequest servletRequest;
	
	 public static final String ERROR = "error";
	 public static final String SUCCESS = "success";
	
	 public String execute(){
		 try {
			Collection roles=rolManager.ObtenerRoles();
			servletRequest.setAttribute("roles", roles);
			 
		 } catch (Exception e) {
			 addFieldError("FalloBusquedaListaRoles",getText("busquedaListaRoles.Invalid"));
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
	public RolManager getRolManager() {
		return rolManager;
	}
	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}
	

}
