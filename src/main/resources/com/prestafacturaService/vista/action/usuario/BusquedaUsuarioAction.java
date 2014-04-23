package com.prestafacturaService.vista.action.usuario;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class BusquedaUsuarioAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4966141920094210279L;
	
	private HttpServletRequest servletRequest;
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
    private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;
	
	private String nombreBus;
	private String apellido1Bus;
	private String apellido2Bus;
	private String departamentoBus;
	private String nombreRolBus;
	
	
	
	public String execute(){
		
		try{
			Rol rol=rolManager.ObtenerRolByName(nombreRolBus);
			Collection usuarios=usuarioManager.busquedaUsuario(nombreBus,apellido1Bus,apellido2Bus, departamentoBus,rol);
			
			servletRequest.setAttribute("busquedaUsuarios", usuarios);
			if(usuarios.size()==0){
				addActionMessage("No hay usuarios con esos valores");
				return SUCCESS;
			}else{
				return SUCCESS;
			}
			
			
		}catch(Exception e){
			addActionError("La busqueda del usuario ha fallado");
			return INPUT;
		}
		
		
	}
	
	
	public void validate(){
		if(nombreBus!= null && !nombreBus.equals("")){
			addFieldError("nombreBus.invalid", getText("nombreBus.invalid"));
		}if(apellido1Bus!= null && !apellido1Bus.equals("")){
			addFieldError("apellido1Bus.invalid", getText("apellido1Bus.invalid"));
		}if(apellido2Bus!= null && !apellido2Bus.equals("")){
			addFieldError("apellido2Bus.invalid", getText("apellido2Bus.invalid"));
		}if(departamentoBus!= null && !departamentoBus.equals("")){
			addFieldError("departamentoBus.invalid", getText("departamentoBus.invalid"));
		}if(nombreRolBus!= null && !nombreRolBus.equals("")){
			addFieldError("nombreRolBus.invalid", getText("nombreRolBus.invalid"));
		}
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

	public UsuarioManager getUsuarioManager() {
		return usuarioManager;
	}

	public void setUsuarioManager(UsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}
	
	
	
	
	
	
	
	
}
