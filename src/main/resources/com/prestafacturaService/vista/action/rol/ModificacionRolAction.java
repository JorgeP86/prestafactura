package com.prestafacturaService.vista.action.rol;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class ModificacionRolAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 909700589759645941L;

	private HttpServletRequest servletRequest;
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	int idRol= (Integer) servletRequest.getAttribute("idRol");
	
	@Autowired
	 private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;
	
	public String execute(){
		try{
			Rol rol=rolManager.ObtenerRolByidRol(idRol);
			//Comprobamos que no existe al menos un usuario asignado a ese rol
    		//pues si existe no daremos posibilidad de eliminarlo ante de quitar
    		//la relación
			if(usuarioManager.usuariosConRol(rol).size()!=0){
				addActionError("No se puede eliminar ese Rol porque tiene un Usuario asociado.");
			}else{
				rolManager.bajaRol(rol);
				addActionError("Operación de borrar correcta");	
			}
				Collection roles=rolManager.ObtenerRoles();
				servletRequest.setAttribute("RolesTrasBorrar", roles);
			
		} catch (Exception e) {
			
		addActionError("Fallo al eliminar el Rol");
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
