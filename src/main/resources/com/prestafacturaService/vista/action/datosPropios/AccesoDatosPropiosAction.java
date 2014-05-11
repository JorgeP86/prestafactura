package com.prestafacturaService.vista.action.datosPropios;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.DatosPropios;
import com.prestafacturaService.mongo.manager.DatosPropiosManager;

public class AccesoDatosPropiosAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private static final Logger logger = Logger.getLogger(AccesoDatosPropiosAction.class);
	
	private DatosPropios datosPropios;
	
	@Autowired
	private DatosPropiosManager datosPropiosManager;
	
	public String execute(){
		 
		try {
		
			 List<DatosPropios> datos=datosPropiosManager.obtenerDatosPropios();
			 datosPropios=datos.get(0);
			 logger.info("Obtenido los datos propios");
				
				if(datos.size()==0 ){
					 addActionMessage("No hay Datos Propios para mostrar"); 
				}
			
			 
		 }catch(Exception e){
			 
			 addActionError("Fallo al realizar el acceso de los Datos Propios");
			return ERROR;
		 }

		 return SUCCESS; 

	}

	public DatosPropios getDatosPropios() {
		return datosPropios;
	}

	public void setDatosPropios(DatosPropios datosPropios) {
		this.datosPropios = datosPropios;
	}

	public DatosPropiosManager getDatosPropiosManager() {
		return datosPropiosManager;
	}

	public void setDatosPropiosManager(DatosPropiosManager datosPropiosManager) {
		this.datosPropiosManager = datosPropiosManager;
	}
	
	
}
