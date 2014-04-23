package com.prestafacturaService.vista.action.usuario;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class AccesoUsuarioAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -548536444855489980L;

	 private HttpServletRequest servletRequest;
	 public static final String ERROR = "error";
	 public static final String SUCCESS = "success";
	 
	 @Autowired
	    private RolManager rolManager;
		@Autowired
		private UsuarioManager usuarioManager;
		
	 
	 public String execute(){
			clearFieldErrors();
			
		try {
			Collection usuarios= usuarioManager.obtenerUsuarios();
			Collection roles= rolManager.ObtenerRoles();
			
			servletRequest.setAttribute("usuario", usuarios);
			servletRequest.setAttribute("roles", roles);
	
			
		} catch (Exception e){
			addActionError("Fallo al realizar la busqueda de los usuarios");
			return ERROR;
		}
		return SUCCESS;
	
			
	 }
	 
	 
	 
	 
	 

	public RolManager getRolManager() {
		return rolManager;
	}






	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}






	public UsuarioManager getUsuarioManager() {
		return usuarioManager;
	}






	public void setUsuarioManager(UsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}






	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	 

	
	
}
