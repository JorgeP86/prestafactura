package com.prestafacturaService.vista.action.proveedor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.manager.ProveedorManager;

public class BusquedaProveedorAction extends ActionSupport{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private static final Logger logger = Logger.getLogger(BusquedaProveedorAction.class);
	
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
	private ProveedorManager proveedorManager;
	
	private IdentificacionFiscal idFiscal;
	private Proveedor busProveedor;
	
	
	public String execute(){
		try{
			busProveedor=(Proveedor) proveedorManager.obtenerProveedorporCif(idFiscal);
			logger.info("Busqueda de cliente por parámetros");

			if(busProveedor==null){
				addActionMessage("No hay Proveedores con esos valores");
				return INPUT;
			}
		
		}catch(Exception e){
			addActionError("La busqueda del proveedor ha fallado");
			return INPUT;
		}
	return SUCCESS;
	}


	public IdentificacionFiscal getIdFiscal() {
		return idFiscal;
	}


	public void setIdFiscal(IdentificacionFiscal idFiscal) {
		this.idFiscal = idFiscal;
	}


	public Proveedor getBusProveedor() {
		return busProveedor;
	}


	public void setBusProveedor(Proveedor busProveedor) {
		this.busProveedor = busProveedor;
	}
	
	
	
	
	
	
}




