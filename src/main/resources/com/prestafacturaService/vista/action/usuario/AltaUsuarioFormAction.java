package com.prestafacturaService.vista.action.usuario;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.RolManager;

public class AltaUsuarioFormAction extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AltaUsuarioFormAction.class);

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	
	@Autowired
	private RolManager rolManager;
	
	private List<Rol> listRoles;
	
	public String execute() {
		try{
			logger.info("Obteniendo Roles");
			listRoles=rolManager.ObtenerRoles();
			logger.info("Roles Obtenidos");
		}catch(Exception e){
			addActionError("Fallo al obtener datos para el formulario Alta Usuario");
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

	public List<Rol> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Rol> listRoles) {
		this.listRoles = listRoles;
	}
	
	
	
	

}
