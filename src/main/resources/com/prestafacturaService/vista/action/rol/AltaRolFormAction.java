package com.prestafacturaService.vista.action.rol;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.manager.RecursoManager;

public class AltaRolFormAction extends ActionSupport {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AltaRolFormAction.class);

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	
	private Collection<Recurso> recursos;
	
	@Autowired
	private RecursoManager recursoManager;
	
	
	public String execute() {
		try{
			
			recursos=(Collection<Recurso>) recursoManager.obtenerPaginas();

		}catch(Exception e){
			addActionError("Fallo al obtener datos para el formulario AltaRol");
			return ERROR;
		}
		return SUCCESS;
	}


	public Collection<Recurso> getRecursos() {
		return recursos;
	}


	public void setRecursos(Collection<Recurso> recursos) {
		this.recursos = recursos;
	}


	public RecursoManager getRecursoManager() {
		return recursoManager;
	}


	public void setRecursoManager(RecursoManager recursoManager) {
		this.recursoManager = recursoManager;
	}
	
	
	
	
	
}


