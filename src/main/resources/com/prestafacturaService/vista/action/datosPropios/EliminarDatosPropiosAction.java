package com.prestafacturaService.vista.action.datosPropios;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.manager.DatosPropiosManager;

public class EliminarDatosPropiosAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(EliminarDatosPropiosAction.class);

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	
	@Autowired
	private DatosPropiosManager datosPropiosManager;
	
	private String identificacionFiscal;
	
	
	public String execute() {
		try{
			logger.info("entra en eliminar");
		//DatosPropios dto=datosPropiosManager.obtenerDatosPropiosByIdFiscal(identificacionFiscal);
		logger.info("Se ha obtenido los Datos Propios");
		//datosPropiosManager.eliminarDatoPropio(dto);
		logger.info("Se ha eliminado los Datos Propios");	
			
		}catch(Exception e){
			addActionError("Fallo al obtener datos para el formulario AltaDatosPropios");
			return ERROR;
		}
		return SUCCESS;
	}


	public DatosPropiosManager getDatosPropiosManager() {
		return datosPropiosManager;
	}


	public void setDatosPropiosManager(DatosPropiosManager datosPropiosManager) {
		this.datosPropiosManager = datosPropiosManager;
	}


	public String getIdentificacionFiscal() {
		return identificacionFiscal;
	}


	public void setIdentificacionFiscal(String identificacionFiscal) {
		this.identificacionFiscal = identificacionFiscal;
	}


	


		
	
	
	
	
	
}
