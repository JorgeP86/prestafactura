package com.prestafacturaService.vista.action.rol;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.RolManager;

public class BusquedaRolAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1807399587308146073L;
	
	private HttpServletRequest servletRequest;
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	@Autowired
	private RolManager rolManager;
	
	 private String nombreRol;
	 private String descripcionRol;
	
	public String execute(){
		try {
			if(nombreRol!=null && nombreRol.trim().length()>0 &&
					descripcionRol!=null && descripcionRol.trim().length()>0){
				Rol rol= rolManager.ObtenerRolByName(nombreRol);
				servletRequest.setAttribute("RolBusqueda", rol);
			
			}
			
		} catch (Exception e) {
			addFieldError("FalloBusquedaRoles",getText("busquedaRoles.Invalid"));
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
