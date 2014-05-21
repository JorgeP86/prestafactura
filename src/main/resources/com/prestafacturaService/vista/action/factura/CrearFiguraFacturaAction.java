package com.prestafacturaService.vista.action.factura;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.dto.DatosPropios;
import com.prestafacturaService.mongo.dto.FiguraFactura;
import com.prestafacturaService.mongo.manager.ClienteManager;
import com.prestafacturaService.mongo.manager.DatosPropiosManager;

public class CrearFiguraFacturaAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(CrearFiguraFacturaAction.class);

	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private Integer idCliente;
	private Integer idDatosPropios;
	
	private HttpServletRequest servletRequest;
	
	@Autowired
	private ClienteManager clienteManager;
	
	@Autowired
	private DatosPropiosManager datosPropiosManager;
	
	public String execute(){
		try{
			if(idCliente>0){
				Cliente clienteselec=clienteManager.obtenerClienteById(idCliente);
				logger.info("Obtenido el cliente selecionado");
				
				FiguraFactura figuraFacCliente= new FiguraFactura();
				figuraFacCliente.setIdentificacionDeFigura("Figura_Cliente");
				figuraFacCliente.setIdentificacionFiscal(clienteselec.getIdentificacionFiscal());
				figuraFacCliente.setDirEntrega(clienteselec.getDirEntrega());
				figuraFacCliente.setCliente(clienteselec);
				if(clienteselec.getNombre()!=null){
				figuraFacCliente.setNombre(clienteselec.getNombre());
				figuraFacCliente.setApellido1(clienteselec.getApellido1());
				figuraFacCliente.setApellido2(clienteselec.getApellido2());
				figuraFacCliente.setDetallesContacto(clienteselec.getDetallesContacto());
				figuraFacCliente.setDireccion(clienteselec.getDireccion());
				}
				if(clienteselec.getEntidadLegal()!=null){
					figuraFacCliente.setEntidadLegal(clienteselec.getEntidadLegal());	
				}
				logger.info("Creado la figuraFactura con los datos del cliente selecionado");
				servletRequest.getSession().setAttribute("figuraFacCliente", figuraFacCliente);
				logger.info("Guardado en session la figuraFactura de tipo Cliente");

			}if(idDatosPropios>0){
				DatosPropios datosPSelec=datosPropiosManager.obtenerDatosPropiosByid(idDatosPropios);
				logger.info("Obtenido los Datos Propios selecionado");
				
				FiguraFactura figuraFacDatosP= new FiguraFactura();
				figuraFacDatosP.setIdentificacionDeFigura("Figura_DatosPropios");
				figuraFacDatosP.setIdentificacionFiscal(datosPSelec.getIdentificacionFiscal());
				figuraFacDatosP.setDirEntrega(datosPSelec.getDirEntrega());
				figuraFacDatosP.setDatospropios(datosPSelec);
				if(datosPSelec.getNombre()!=null){
					figuraFacDatosP.setNombre(datosPSelec.getNombre());
					figuraFacDatosP.setApellido1(datosPSelec.getApellido1());
					figuraFacDatosP.setApellido2(datosPSelec.getApellido2());
					figuraFacDatosP.setDetallesContacto(datosPSelec.getDetallesContacto());
					figuraFacDatosP.setDireccion(datosPSelec.getDireccion());
				}
				if(datosPSelec.getEntidadLegal()!=null){
					figuraFacDatosP.setEntidadLegal(datosPSelec.getEntidadLegal());	
				}
			
				logger.info("Creado la figuraFactura con los datosPropios selecionado");
				servletRequest.getSession().setAttribute("figuraFacDatosP", figuraFacDatosP);
				logger.info("Guardado en session la figuraFactura de tipo Datos Propios");
			
			
			}
	
		}catch(Exception e){
			 addActionError("Fallo al crear el alta de la Figura Factura");
				return ERROR;
		}
		return SUCCESS;
		
		
		
		
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdDatosPropios() {
		return idDatosPropios;
	}

	public void setIdDatosPropios(Integer idDatosPropios) {
		this.idDatosPropios = idDatosPropios;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public ClienteManager getClienteManager() {
		return clienteManager;
	}

	public void setClienteManager(ClienteManager clienteManager) {
		this.clienteManager = clienteManager;
	}

	
}
