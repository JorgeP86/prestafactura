package com.prestafacturaService.vista.action.rol;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.RolManager;




public class AccesoRolAction extends ActionSupport{/**
	 * 
	 */
	private static final long serialVersionUID = 5134879089245551269L;
	private static final Logger logger = Logger.getLogger(AccesoRolAction.class);


	@Autowired
	private RolManager rolManager;
	private Collection<Rol> roles;
	
	 public static final String ERROR = "error";
	 public static final String SUCCESS = "success";
	
	 public String execute(){
		 try {
			Collection<Rol> rolesAux = rolManager.ObtenerRoles();
			this.setRoles(rolesAux);
			 logger.info("Se obtienen los roles");

		 }catch (Exception e) {
			 addFieldError("FalloBusquedaListaRoles",getText("busquedaListaRoles.Invalid"));
			 return ERROR;	 
		 }
		 
		return SUCCESS;
		 
	 }
	

	public Collection<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
	public RolManager getRolManager() {
		return rolManager;
	}
	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}
	

}
