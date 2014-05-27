package com.prestafacturaService.vista.action.cliente;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.manager.CodigoPaisManager;
import com.prestafacturaService.mongo.manager.LocalidadManager;
import com.prestafacturaService.mongo.manager.ProvinciaManager;


public class AltaClienteFormAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AltaClienteFormAction.class);

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
	
	private String localidad;
	private String provincia;
	private String codigoPais;
	
	private String localidadEntrega;
	private String provinciaEntrega;
	private String codigoPaisEntrega;
	
	private String localidadEmpresa;
	private String provinciaEmpresa;
	private String codigoPaisEmpresa;
	
	public String execute() {
		try{
			listProvincias=provinciaManager.obtenerProvincias();
			listLocalidades=localidadManager.obtenerLocalidades();
			listPais=codigoPaisManager.obtenerPais();
			logger.info("Obtenido los datos para cargar el formulario_AltaCliente");
		}catch(Exception e){
			addActionError("Fallo al obtener datos para el formulario AltaCliente");
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


	public CodigoPaisManager getCodigoPaisManager() {
		return codigoPaisManager;
	}


	public void setCodigoPaisManager(CodigoPaisManager codigoPaisManager) {
		this.codigoPaisManager = codigoPaisManager;
	}


	public List<CodigoPais> getListPais() {
		return listPais;
	}


	public void setListPais(List<CodigoPais> listPais) {
		this.listPais = listPais;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getCodigoPais() {
		return codigoPais;
	}


	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}


	public String getLocalidadEntrega() {
		return localidadEntrega;
	}


	public void setLocalidadEntrega(String localidadEntrega) {
		this.localidadEntrega = localidadEntrega;
	}


	public String getProvinciaEntrega() {
		return provinciaEntrega;
	}


	public void setProvinciaEntrega(String provinciaEntrega) {
		this.provinciaEntrega = provinciaEntrega;
	}


	public String getCodigoPaisEntrega() {
		return codigoPaisEntrega;
	}


	public void setCodigoPaisEntrega(String codigoPaisEntrega) {
		this.codigoPaisEntrega = codigoPaisEntrega;
	}


	public String getLocalidadEmpresa() {
		return localidadEmpresa;
	}


	public void setLocalidadEmpresa(String localidadEmpresa) {
		this.localidadEmpresa = localidadEmpresa;
	}


	public String getProvinciaEmpresa() {
		return provinciaEmpresa;
	}


	public void setProvinciaEmpresa(String provinciaEmpresa) {
		this.provinciaEmpresa = provinciaEmpresa;
	}


	public String getCodigoPaisEmpresa() {
		return codigoPaisEmpresa;
	}


	public void setCodigoPaisEmpresa(String codigoPaisEmpresa) {
		this.codigoPaisEmpresa = codigoPaisEmpresa;
	}



	
}
