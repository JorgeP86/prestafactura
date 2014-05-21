package com.prestafacturaService.vista.action.factura;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.DatosAdicionales;
import com.prestafacturaService.mongo.dto.Factura;
import com.prestafacturaService.mongo.manager.FacturaManager;

public class CrearDatosAdicionalesAction  extends ActionSupport implements ServletRequestAware {
	
	
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private HttpServletRequest servletRequest;

	private String facturaID;
	
	@Autowired
	private FacturaManager facturaManager;
	
	public String execute(){
		
	try{
		if(facturaID.trim().trim().equals("")){
			Factura factasociada=facturaManager.ObtenerFacturaByfacturaID(facturaID);
			
			//crear la factura asociada
			
			DatosAdicionales datosAdicionalN= new DatosAdicionales();
			
			
			servletRequest.getSession().setAttribute("DatosAdicionales", datosAdicionalN);
		}
		}catch (Exception e){
			addActionError("Fallo al realizar el alta de los datosAdicionales");
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
