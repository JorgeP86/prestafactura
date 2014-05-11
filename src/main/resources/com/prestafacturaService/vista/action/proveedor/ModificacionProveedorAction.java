package com.prestafacturaService.vista.action.proveedor;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.manager.ProveedorManager;

public class ModificacionProveedorAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ModificacionProveedorAction.class);
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
	private ProveedorManager proveedorManager;
	
	private Integer idProveedor;
	private Collection<Proveedor> proveedoresTrasBorrar;
	
	public String execute(){

		try {
			proveedorManager.eliminarProveedor(idProveedor);
			logger.info("eliminacion proveedor por id");
			addActionMessage("El proveedor de ha eliminado correctamente");
			
			proveedoresTrasBorrar=proveedorManager.obtenerProveedores();
			logger.info("obtener la lista actualizada despues de borrar un Proveedor");

		
		}catch (Exception e) {
			addActionError("La eliminación del Proveedor ha fallado");
			return INPUT;
		}
		return SUCCESS;
	
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Collection<Proveedor> getProveedoresTrasBorrar() {
		return proveedoresTrasBorrar;
	}

	public void setProveedoresTrasBorrar(Collection<Proveedor> proveedoresTrasBorrar) {
		this.proveedoresTrasBorrar = proveedoresTrasBorrar;
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	

