package com.prestafacturaService.vista.action.factura;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.dto.Detalle;
import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.manager.CodigoPaisManager;
import com.prestafacturaService.mongo.manager.LocalidadManager;
import com.prestafacturaService.mongo.manager.ProvinciaManager;

public class CargarDatosFormFacturaAction extends ActionSupport implements
		ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(CargarDatosFormFacturaAction.class);

	private HttpServletRequest servletRequest;

	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";

	@Autowired
	private ProvinciaManager provinciaManager;
	@Autowired
	private LocalidadManager localidadManager;
	@Autowired
	private CodigoPaisManager codigoPaisManager;
	

	private List<Provincia> listProvincias;
	private List<Localidad> listLocalidades;
	private List<CodigoPais> listPais;
	
	
	
	public String execute() {

		try {

			Set<Detalle> detalles = new HashSet();
			servletRequest.getSession().setAttribute("setDetalles", detalles);
			logger.info("Inicializamos la lista de detalles vacia y lo guardamos en session");

			listProvincias = provinciaManager.obtenerProvincias();
			listLocalidades = localidadManager.obtenerLocalidades();
			listPais = codigoPaisManager.obtenerPais();
	
			logger.info("Obtenido los datos para cargar el formulario_AltaFactura");
			
		} catch (Exception e) {
			addActionError("Fallo al obtener datos para el formulario AltaFactura");
			return ERROR;
		}
		return SUCCESS;

	}
	
	public ProvinciaManager getProvinciaManager() {
		return provinciaManager;
	}

	public void setProvinciaManager(ProvinciaManager provinciaManager) {
		this.provinciaManager = provinciaManager;
	}

	public LocalidadManager getLocalidadManager() {
		return localidadManager;
	}

	public void setLocalidadManager(LocalidadManager localidadManager) {
		this.localidadManager = localidadManager;
	}

	public CodigoPaisManager getCodigoPaisManager() {
		return codigoPaisManager;
	}

	public void setCodigoPaisManager(CodigoPaisManager codigoPaisManager) {
		this.codigoPaisManager = codigoPaisManager;
	}

	public List<Provincia> getListProvincias() {
		return listProvincias;
	}

	public void setListProvincias(List<Provincia> listProvincias) {
		this.listProvincias = listProvincias;
	}

	public List<Localidad> getListLocalidades() {
		return listLocalidades;
	}

	public void setListLocalidades(List<Localidad> listLocalidades) {
		this.listLocalidades = listLocalidades;
	}

	public List<CodigoPais> getListPais() {
		return listPais;
	}

	public void setListPais(List<CodigoPais> listPais) {
		this.listPais = listPais;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	

}
