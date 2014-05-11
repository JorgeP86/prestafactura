package com.prestafacturaService.vista.action.datosPropios;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.dto.DatosPropios;
import com.prestafacturaService.mongo.dto.DetallesContacto;
import com.prestafacturaService.mongo.dto.Direccion;
import com.prestafacturaService.mongo.dto.DireccionEntrega;
import com.prestafacturaService.mongo.dto.EntidadLegal;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.manager.DatosPropiosManager;
import com.prestafacturaService.mongo.manager.ProvinciaManager;

public class AltaDatosPropiosAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private static final Logger logger = Logger.getLogger(AltaDatosPropiosAction.class);

	
	
	
	private int idDatosPropios;
	
	@Autowired
	private DatosPropiosManager datosPropiosManager;
	@Autowired
	private ProvinciaManager provinciaManager;
	
	private String nombre;
	private String apellidoP;
	private String apellidoS;
	
	private String identificacionFiscal;
	//direccion del Cliente
	private String calle;
	private String numeroEdificio;
	private String calleAdicional;
	private String departamento;
	private String codigoPostal;
	private String localidad;
	private String provincia;
	private String codigoPais;
	private String posbox;
	//direccion de entrega
	private String calleEntrega;
	private String numeroEdificioEntrega;
	private String calleAdicionalEntrega;
	private String departamentoEntrega;
	private String codigoPostalEntrega;
	private String localidadEntrega;
	private String provinciaEntrega;
	private String codigoPaisEntrega;
	private String posboxEntrega;
	//detalles contacto cliente
	private String telefono;
	private String fax;
	private String direccionWeb;
	private String mail;
	private String personaContacto;
	//EntidadLegal
	private String razonSocial;
	private String nombreComercial;
	private String datosRegistrales;
	//dire empresa
	private String calleEmpresa;
	private String numeroEdificioEmpresa;
	private String calleAdicionalEmpresa;
	private String departamentoEmpresa;
	private String codigoPostalEmpresa;
	private String localidadEmpresa;
	private String provinciaEmpresa;
	private String codigoPaisEmpresa;
	private String posboxEmpresa;
	//Detalles contacto empresa
	private String telefonoEmpresa;
	private String faxEmpresa;
	private String direccionWebEmpresa;
	private String mailEmpresa;
	private String personaContactoEmpresa;
	
	private DatosPropios PropiosModifica;
	private DatosPropios datosPropiosNuevo;
	
	
	public String execute(){
		clearFieldErrors();
		try{
			
			if(idDatosPropios==0 && !datosPropiosManager.existedatosPropios(identificacionFiscal)){ //Alta
				logger.info("Comienza operacion alta cliente");
				
				//Creacion Identificacion Fiscal
				IdentificacionFiscal idFiscal= new IdentificacionFiscal();
				idFiscal.setIdentificacionFiscal(identificacionFiscal);
				logger.info("Creacion identificacion fiscal datosPropios");
				
				//Obtener la Provincia y la localidad Cliente
				Provincia provinciadatos=provinciaManager.obtenerProvinciaByName(provincia);
				Localidad localidaddatos=new Localidad();
				for(Localidad l:provinciadatos.getLocalidades()){
					if(l.getLocalidad().equals(localidad)){
						localidaddatos=l;
					}
				}
				logger.info("Provincia y localidad datosPropios obtenida");
				
				//Obtener el codigo del pais
				CodigoPais codigoPaisp=new CodigoPais();
				codigoPaisp.setCodigoPais(codigoPais);
				logger.info("Codigo pais cliente creado");
				
				
				//Crear la Direccion propia
				Direccion diCliente=new Direccion();
				diCliente.setTipodireccion("Dirección DatosPropios");
				diCliente.setCalle(calle);
				if(this.calleAdicional!=null || ! this.calleAdicional.trim().equals("")){
					diCliente.setCalleAdicional(calleAdicional);
				}
				diCliente.setCodigoPostal(codigoPostal);
				diCliente.setDepartamento(departamento);
				diCliente.setNumeroEdificio(numeroEdificio);
				diCliente.setProvincia(provinciadatos);
				diCliente.setLocalidad(localidaddatos);
				diCliente.setPostBox(posbox);
				diCliente.setCodigoPais(codigoPaisp);
				
				logger.info("Creacion direccion DatosPropios");
				
				//Crear los detalles de contacto
				DetallesContacto dcpropios=new DetallesContacto();
				dcpropios.setDireccionWeb(direccionWeb);
				dcpropios.setFax(fax);
				dcpropios.setMail(mail);
				dcpropios.setPersonaContacto(personaContacto);
				dcpropios.setTelefono(telefono);
				logger.info("Creacion detalles contacto propio");
			
				//Creación de la dirección de Entrega
				
				
				Provincia pEntrega=provinciaManager.obtenerProvinciaByName(provinciaEntrega);
				Localidad lEntrega=new Localidad();
				for(Localidad l:pEntrega.getLocalidades()){
					if(l.getLocalidad().equals(localidadEntrega)){
						lEntrega=l;
					}
				}
				
				logger.info("Creacion provincia y localidad de direccion de entrega");

				//Creacion del codigoPais
				CodigoPais cpaisEntrega= new CodigoPais();
				cpaisEntrega.setCodigoPais(codigoPaisEntrega);
				logger.info("Creacion código pais direccion de entrega");

				
				Direccion diEntrega=new DireccionEntrega();
				diEntrega.setTipodireccion("Dirección Entrega");
				diEntrega.setCalle(calleEntrega);
					if(this.calleAdicionalEntrega!=null || ! this.calleAdicionalEntrega.trim().equals("")){
					diEntrega.setCalleAdicional(calleAdicionalEntrega);
					}
				diEntrega.setCodigoPostal(codigoPostalEntrega );
				diEntrega.setDepartamento(departamentoEntrega);
				diEntrega.setNumeroEdificio(numeroEdificioEntrega);
				diEntrega.setProvincia(pEntrega);
				diEntrega.setLocalidad(lEntrega);
				diEntrega.setPostBox(posboxEntrega);
				diEntrega.setCodigoPais(cpaisEntrega);
				
				logger.info("Creacion Direccion de Entrega");

				//Creacion Entidad Legal
				
				
				
				Provincia pEmpresa=provinciaManager.obtenerProvinciaByName(provinciaEmpresa);
				Localidad lEmpresa=new Localidad();
				for(Localidad l:pEmpresa.getLocalidades()){
					if(l.getLocalidad().equals(localidadEmpresa)){
						lEmpresa=l;
					}
				}
				
				logger.info("Creacion provincia y localidad de entidad legal");

				//Creacion del codigoPais
				CodigoPais cpaisEmpresa= new CodigoPais();
				cpaisEmpresa.setCodigoPais(codigoPaisEntrega);
				logger.info("Creacion codigo pais de entidad legal");

				
				Direccion direcccionELegal=new Direccion();
				direcccionELegal.setTipodireccion("Dirección Empresa");
				direcccionELegal.setCalle(calleEmpresa);
					if(this.calleAdicionalEmpresa!=null || ! this.calleAdicionalEmpresa.trim().equals("")){
						direcccionELegal.setCalleAdicional(calleAdicionalEmpresa);
					}
				direcccionELegal.setCodigoPostal(codigoPostalEmpresa );
				direcccionELegal.setDepartamento(departamentoEmpresa);
				direcccionELegal.setNumeroEdificio(numeroEdificioEmpresa);
				direcccionELegal.setProvincia(pEmpresa);
				direcccionELegal.setLocalidad(lEmpresa);
				direcccionELegal.setPostBox(posboxEmpresa);
				direcccionELegal.setCodigoPais(cpaisEmpresa);
				logger.info("Creacion Direccion de Entidad Legal");

				
				
				DetallesContacto dContactoEmpresa=new DetallesContacto();
				dContactoEmpresa.setDireccionWeb(direccionWebEmpresa);
				dContactoEmpresa.setFax(faxEmpresa);
				dContactoEmpresa.setMail(mailEmpresa);
				dContactoEmpresa.setPersonaContacto(personaContactoEmpresa);
				dContactoEmpresa.setTelefono(telefonoEmpresa);
				logger.info("Creacion detalles de contacto de empresa");

				
				
				EntidadLegal eLdatos=new EntidadLegal();
				eLdatos.setDatosRegistrales(datosRegistrales);
						if(this.direccionWebEmpresa!=null || ! this.direccionWebEmpresa.trim().equals("") &&
						this.faxEmpresa!=null || !this.faxEmpresa.trim().equals("") &&
						this.mailEmpresa!=null || ! this.mailEmpresa.trim().equals("")&&
						this.personaContactoEmpresa!=null || !mailEmpresa.trim().equals("")&&
						this.telefonoEmpresa!=null || ! this.telefonoEmpresa.trim().equals("")){
							eLdatos.setDetallesContacto(dContactoEmpresa);
						}
						eLdatos.setNombreComercial(nombreComercial);
						eLdatos.setRazonSocial(razonSocial);
						eLdatos.setDireccion(direcccionELegal);
				
				logger.info("Creacion de Entidad Legal");

				
				//Creación del Cliente
				 datosPropiosNuevo=new DatosPropios();
				
				
				//Si el cliente es una persona se crea el objeto sólo con sus datos
				if(nombre!=null || !nombre.trim().equals("")){
					datosPropiosNuevo.setIdDatosPropios((new Integer(UUID.randomUUID().toString())));
					datosPropiosNuevo.setNombre(nombre);
					datosPropiosNuevo.setApellido1(apellidoP);
					datosPropiosNuevo.setApellido2(apellidoS);
					datosPropiosNuevo.setIdentificacionFiscal(idFiscal);
					datosPropiosNuevo.setDireccion(diCliente);
					datosPropiosNuevo.setDirEntrega(diEntrega);
					//Si detalles Contacto se ha rellenado
					if(this.telefono!=null || !telefono.trim().equals("") &&
						this.fax!=null || !fax.trim().equals("") &&
						this.direccionWeb!=null || !direccionWeb.trim().equals("") &&
						this.mail!=null || !mail.trim().equals("") &&
						this.personaContacto!=null || !personaContacto.trim().equals("")){
						datosPropiosNuevo.setDetallesContacto(dcpropios);
					}
				
				//Si es una empresa se cre la entidadLegal en el cliente
				}if(nombreComercial!=null && !nombreComercial.trim().equals("")){
				datosPropiosNuevo.setIdDatosPropios((new Integer(UUID.randomUUID().toString())));
				datosPropiosNuevo.setEntidadLegal(eLdatos);
				datosPropiosNuevo.setIdentificacionFiscal(idFiscal);
				datosPropiosNuevo.setDirEntrega(diEntrega);
				}
				
				//GuardarDatosPropios
				logger.info("Se llamará a guardarClinte");
				datosPropiosManager.guardarCliente(datosPropiosNuevo);
				addActionMessage("El Cliente se ha creado correctamente");
				logger.info("Creacion DATOS PROPIOS");
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}if(idDatosPropios>0){
			PropiosModifica=datosPropiosManager.obtenerDatosPropiosByid(idDatosPropios);
			
			//Modificacion Identificacion Fiscal
			IdentificacionFiscal idFiscalModificacion= new IdentificacionFiscal();
			idFiscalModificacion.setIdentificacionFiscal(identificacionFiscal);
			logger.info("Modificar identificacion fiscal Datos Propios");

			//Obtener la Provincia y la localidad Cliente
			Provincia provinciaModificacion=provinciaManager.obtenerProvinciaByName(provincia);
			Localidad localidadModificacion=new Localidad();
			for(Localidad l:provinciaModificacion.getLocalidades()){
				if(l.getLocalidad().equals(localidad)){
					localidadModificacion=l;
				}
			}
			logger.info("Provincia y localidad Datos Propios Modificado");

			//Obtener el codigo del pais
			CodigoPais codigoPaisModificacion=new CodigoPais();
			codigoPaisModificacion.setCodigoPais(codigoPais);
			logger.info("Codigo pais Datos Propios Modificado");

		//Crear la Direccion del Cliente
			Direccion diModificacion=new Direccion();
			diModificacion.setTipodireccion("Dirección Cliente");
			diModificacion.setCalle(calle);
			if(this.calleAdicional!=null || ! this.calleAdicional.trim().equals("")){
				diModificacion.setCalleAdicional(calleAdicional);
			}
			diModificacion.setCodigoPostal(codigoPostal);
			diModificacion.setDepartamento(departamento);
			diModificacion.setNumeroEdificio(numeroEdificio);
			diModificacion.setProvincia(provinciaModificacion);
			diModificacion.setLocalidad(localidadModificacion);
			diModificacion.setPostBox(posbox);
			diModificacion.setCodigoPais(codigoPaisModificacion);
			
			logger.info("Modificar direccion cliente");

			
		//Crear los detalles de contacto
			DetallesContacto dcModificacion=new DetallesContacto();
			dcModificacion.setDireccionWeb(direccionWeb);
			dcModificacion.setFax(fax);
			dcModificacion.setMail(mail);
			dcModificacion.setPersonaContacto(personaContacto);
			dcModificacion.setTelefono(telefono);
			logger.info("Modificar detalles contacto Datos Propios");

	
		//Creación de la dirección de Entrega
			

			Provincia pEntrega=provinciaManager.obtenerProvinciaByName(provinciaEntrega);
			Localidad lEntrega=new Localidad();
			for(Localidad l:pEntrega.getLocalidades()){
				if(l.getLocalidad().equals(localidadEntrega)){
					lEntrega=l;
				}
			}
			
			logger.info("Modificar provincia y localidad de direccion de entrega");

						//Creacion del codigoPais
			CodigoPais cpaisEntrega= new CodigoPais();
			cpaisEntrega.setCodigoPais(codigoPaisEntrega);
			logger.info("Modificar código pais direccion de entrega");

			
			Direccion diEntrega=new DireccionEntrega();
			diEntrega.setTipodireccion("Dirección Entrega");
			diEntrega.setCalle(calleEntrega);
				if(this.calleAdicionalEntrega!=null || ! this.calleAdicionalEntrega.trim().equals("")){
				diEntrega.setCalleAdicional(calleAdicionalEntrega);
				}
			diEntrega.setCodigoPostal(codigoPostalEntrega );
			diEntrega.setDepartamento(departamentoEntrega);
			diEntrega.setNumeroEdificio(numeroEdificioEntrega);
			diEntrega.setProvincia(pEntrega);
			diEntrega.setLocalidad(lEntrega);
			diEntrega.setPostBox(posboxEntrega);
			diEntrega.setCodigoPais(cpaisEntrega);
			
			logger.info("Modificar Direccion de Entrega");

			
		//Creacion Entidad Legal
			
	
			
			Provincia pEmpresa=provinciaManager.obtenerProvinciaByName(provinciaEmpresa);
			Localidad lEmpresa=new Localidad();
			for(Localidad l:pEmpresa.getLocalidades()){
				if(l.getLocalidad().equals(localidadEmpresa)){
					lEmpresa=l;
				}
			}
			
			logger.info("Modificar provincia y localidad de entidad legal");

			//Creacion del codigoPais
			CodigoPais cpaisEmpresa= new CodigoPais();
			cpaisEmpresa.setCodigoPais(codigoPaisEntrega);
			logger.info("Modificar codigo pais de entidad legal");

			
			Direccion direcccionELegal=new Direccion();
			direcccionELegal.setTipodireccion("Dirección Empresa");
			direcccionELegal.setCalle(calleEmpresa);
				if(this.calleAdicionalEmpresa!=null || ! this.calleAdicionalEmpresa.trim().equals("")){
					direcccionELegal.setCalleAdicional(calleAdicionalEmpresa);
				}
			direcccionELegal.setCodigoPostal(codigoPostalEmpresa );
			direcccionELegal.setDepartamento(departamentoEmpresa);
			direcccionELegal.setNumeroEdificio(numeroEdificioEmpresa);
			direcccionELegal.setProvincia(pEmpresa);
			direcccionELegal.setLocalidad(lEmpresa);
			direcccionELegal.setPostBox(posboxEmpresa);
			direcccionELegal.setCodigoPais(cpaisEmpresa);
			logger.info("Modificar Direccion de Entidad Legal");

			
			
			DetallesContacto dContactoEmpresa=new DetallesContacto();
			dContactoEmpresa.setDireccionWeb(direccionWebEmpresa);
			dContactoEmpresa.setFax(faxEmpresa);
			dContactoEmpresa.setMail(mailEmpresa);
			dContactoEmpresa.setPersonaContacto(personaContactoEmpresa);
			dContactoEmpresa.setTelefono(telefonoEmpresa);
			logger.info("Modificar detalles de contacto de empresa");

			
			
			EntidadLegal eLModificacion=new EntidadLegal();
			eLModificacion.setDatosRegistrales(datosRegistrales);
					if(this.direccionWebEmpresa!=null || ! this.direccionWebEmpresa.trim().equals("") &&
					this.faxEmpresa!=null || !this.faxEmpresa.trim().equals("") &&
					this.mailEmpresa!=null || ! this.mailEmpresa.trim().equals("")&&
					this.personaContactoEmpresa!=null || !mailEmpresa.trim().equals("")&&
					this.telefonoEmpresa!=null || ! this.telefonoEmpresa.trim().equals("")){
						eLModificacion.setDetallesContacto(dContactoEmpresa);
					}
			eLModificacion.setNombreComercial(nombreComercial);
			eLModificacion.setRazonSocial(razonSocial);
			eLModificacion.setDireccion(direcccionELegal);
			
			logger.info("Modificar de Entidad Legal");

			//Si los Datos Propios es una persona se crea el objeto sólo con sus datos
			if(nombre!=null || !nombre.trim().equals("")){
				PropiosModifica.setNombre(nombre);
				PropiosModifica.setApellido1(apellidoP);
				PropiosModifica.setApellido2(apellidoS);
				PropiosModifica.setIdentificacionFiscal(idFiscalModificacion);
				PropiosModifica.setDireccion(diModificacion);
				PropiosModifica.setDirEntrega(diEntrega);
				//Si detalles Contacto se ha rellenado
			}if(this.telefono!=null || !telefono.trim().equals("") &&
					this.fax!=null || !fax.trim().equals("") &&
					this.direccionWeb!=null || !direccionWeb.trim().equals("") &&
					this.mail!=null || !mail.trim().equals("") &&
					this.personaContacto!=null || !personaContacto.trim().equals("")){
				PropiosModifica.setDetallesContacto(dcModificacion);
			
			
			//Si es una empresa se crea la entidadLegal en el cliente
		}if(nombreComercial!=null && !nombreComercial.trim().equals("")){
			PropiosModifica.setEntidadLegal(eLModificacion);
			PropiosModifica.setIdentificacionFiscal(idFiscalModificacion);
			PropiosModifica.setDirEntrega(diEntrega);
		}
				
		//revisar el DatosPropiosmodificacion
		PropiosModifica=datosPropiosManager.updateCliente(PropiosModifica);
		addActionMessage("Los Datos Propios se han modificado correctamente");
		logger.info("Modificacion DATOS PROPIOS");
		
	}	
			
		
		}catch(Exception e){
			addActionError("Ha ocurrido un error en la gestion de Datos Propios");
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	
////////////////////////////////////////////////////////
	

	public void validate(){
		Boolean res=camposCompletos();
		if(res==false){
			addFieldError("AltaDatosPropiosCampos", getText("altaDatosPropios.camposInvalid"));
		}
		
	}	

	public boolean camposCompletos(){
		Boolean res=false;
		if(this.nombre!=null || !this.nombre.trim().equals("") &&
				this.apellidoP!=null || !this.apellidoP.trim().equals("") &&
				this.apellidoS!=null || !this.apellidoS.trim().equals("") &&
				this.identificacionFiscal!=null || !this.identificacionFiscal.trim().equals("") &&
				this.calle!=null || !this.calle.trim().equals("") &&
				this.numeroEdificio!=null || !this.numeroEdificio.trim().equals("") &&
				this.departamento!=null || !this.departamento.trim().equals("") &&
				this.codigoPostalEntrega!=null || !this.codigoPostalEntrega.trim().equals("") &&
				this.localidad!=null || !this.localidad.trim().equals("") &&
				this.provincia!=null || !this.provincia.trim().equals("") &&
				this.codigoPais!=null || !this.codigoPais.trim().equals("") &&
				this.posbox!=null || !this.posbox.trim().equals("") &&
				this.calleEntrega !=null || !this.calleEntrega.trim().equals("") &&
				this.numeroEdificioEntrega!=null || !this.numeroEdificioEntrega.trim().equals("") &&
				this.departamentoEntrega!=null || !this.departamentoEntrega.trim().equals("") &&
				this.localidadEntrega!=null || !this.localidadEntrega.trim().equals("") &&
				this.provinciaEntrega!=null || !this.provinciaEntrega.trim().equals("") &&
				this.codigoPaisEntrega!=null || !this.codigoPaisEntrega.trim().equals("") &&
				this.posboxEntrega!=null || !this.posboxEntrega.trim().equals("")&&
				this.codigoPostalEntrega!=null || !this.codigoPostalEntrega.trim().equals("")){
				
			res=true;
		}if(this.razonSocial!=null || !this.razonSocial.trim().equals("") &&
				this.nombreComercial!=null || !this.nombreComercial.trim().equals("") &&
				this.calleEmpresa!=null || !this.calleEmpresa.trim().equals("") &&
				this.numeroEdificioEmpresa!=null || !this.numeroEdificioEmpresa.trim().equals("") &&
				this.departamentoEmpresa!=null || !this.departamentoEmpresa.trim().equals("") &&
				this.localidadEmpresa!=null || !this.localidadEmpresa.trim().equals("") &&
				this.provinciaEmpresa!=null || !this.provinciaEmpresa.trim().equals("") &&
				this.codigoPaisEmpresa!=null || !this.codigoPaisEmpresa.trim().equals("") &&
				this.posboxEmpresa!=null || !this.posboxEmpresa.trim().equals("")&&
				this.codigoPostalEmpresa!=null || !this.codigoPostalEmpresa.trim().equals("") &&
				this.identificacionFiscal!=null || !this.identificacionFiscal.trim().equals("")&&
				this.calleEntrega!=null || !this.calleEntrega.trim().equals("") &&
				this.numeroEdificioEntrega!=null || !this.numeroEdificioEntrega.trim().equals("") &&
				this.departamentoEntrega!=null || !this.departamentoEntrega.trim().equals("") &&
				this.localidadEntrega!=null || !this.localidadEntrega.trim().equals("") &&
				this.provinciaEntrega!=null || !this.provinciaEntrega.trim().equals("") &&
				this.codigoPaisEntrega!=null || !this.codigoPaisEntrega.trim().equals("") &&
				this.posboxEntrega!=null || !this.posboxEntrega.trim().equals("")&&
				this.codigoPostalEntrega!=null || !this.codigoPostalEntrega.trim().equals("")){
			res=true;
		}
		return res;
	}

	public int getIdDatosPropios() {
		return idDatosPropios;
	}

	public void setIdDatosPropios(int idDatosPropios) {
		this.idDatosPropios = idDatosPropios;
	}

	public DatosPropiosManager getDatosPropiosManager() {
		return datosPropiosManager;
	}

	public void setDatosPropiosManager(DatosPropiosManager datosPropiosManager) {
		this.datosPropiosManager = datosPropiosManager;
	}

	public DatosPropios getPropiosModifica() {
		return PropiosModifica;
	}

	public void setPropiosModifica(DatosPropios propiosModifica) {
		PropiosModifica = propiosModifica;
	}

	public ProvinciaManager getProvinciaManager() {
		return provinciaManager;
	}

	public void setProvinciaManager(ProvinciaManager provinciaManager) {
		this.provinciaManager = provinciaManager;
	}

	public DatosPropios getDatosPropiosNuevo() {
		return datosPropiosNuevo;
	}

	public void setDatosPropiosNuevo(DatosPropios datosPropiosNuevo) {
		this.datosPropiosNuevo = datosPropiosNuevo;
	}
	
	
	
	
}
