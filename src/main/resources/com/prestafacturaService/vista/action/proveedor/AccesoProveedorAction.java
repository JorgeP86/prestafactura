package com.prestafacturaService.vista.action.proveedor;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.manager.ProveedorManager;

public class AccesoProveedorAction  extends ActionSupport {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private static final Logger logger = Logger.getLogger(AccesoProveedorAction.class);


	@Autowired
	private ProveedorManager proveedorManager;

	private Collection<Proveedor> proveedores;

	public String execute(){
		 
		try {
			 proveedores=proveedorManager.obtenerProveedores();
				logger.info("Obtenida lista de clientes");

			 if(proveedores.size()==0){
				 addActionMessage("No hay proveedores para mostrar"); 
			 }
			 
			 
		 }catch(Exception e){
			 
			 addActionError("Fallo al realizar el acceso de los proveedores");
			return ERROR;
		 }
		 

		 return SUCCESS;
		 
	 }

	public Collection<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Collection<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	
}
