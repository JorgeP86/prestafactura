package com.prestafacturaService.vista.action.rol;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.RolManager;

public class BusquedaRolAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1807399587308146073L;
	
	private static final Logger logger = Logger.getLogger(BusquedaRolAction.class);

	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	@Autowired
	private RolManager rolManager;
	
	private String nombreRol;
	
	private Rol rolBusqueda;
	
	public String execute(){
		try {
			if(nombreRol!=null && nombreRol.trim().length()>0){
				logger.info("Si el nombre del Rol es distinto de NULL y mayor que 0....");
				Rol rol= rolManager.ObtenerRolByName(nombreRol);
				System.out.println("El rol a buscar es:" + rol.getNombre());
				this.setRolBusqueda(rol);
				logger.info("Obtener rol por nombre");
			}
		} catch (Exception e) {
			addFieldError("FalloBusquedaRoles",getText("busquedaRoles.Invalid"));
			return ERROR;
		}
		return SUCCESS;
		
	}

	public Rol getRolBusqueda() {
		return rolBusqueda;
	}

	public void setRolBusqueda(Rol rolBusqueda) {
		this.rolBusqueda = rolBusqueda;
	}


	public RolManager getRolManager() {
		return rolManager;
	}

	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	
}
