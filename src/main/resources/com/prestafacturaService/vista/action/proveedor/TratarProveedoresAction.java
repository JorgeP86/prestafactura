package com.prestafacturaService.vista.action.proveedor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.manager.ProveedorManager;

public class TratarProveedoresAction extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(TratarProveedoresAction.class);

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
	private ProveedorManager proveedorManager;
	
	private Proveedor proveedorModificacion;
	private Integer idProveedor;
	
	public String execute() {
		try{
			// Definimos si se ha elegido alta o modificacion
			if(idProveedor>0){
			logger.info("definir si es alta o modificacion usuario");
			proveedorModificacion=proveedorManager.obtenerProveedorByid(idProveedor);
			 
			 logger.info("definir si es alta o modificacion usuario");

			}
			
		}catch (Exception e) {
			addActionError("Fallo al tratar el Cliente");
			return ERROR;
		}
		return SUCCESS;
		
	}

	public Proveedor getProveedorModificacion() {
		return proveedorModificacion;
	}

	public void setProveedorModificacion(Proveedor proveedorModificacion) {
		this.proveedorModificacion = proveedorModificacion;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
	
	
	
	
	
}
