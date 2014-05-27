package com.prestafacturaService.vista.action.cliente;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.dto.DetallesContacto;
import com.prestafacturaService.mongo.dto.Direccion;
import com.prestafacturaService.mongo.dto.DireccionEntrega;
import com.prestafacturaService.mongo.dto.EntidadLegal;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.manager.ClienteManager;
import com.prestafacturaService.mongo.manager.CodigoPaisManager;
import com.prestafacturaService.mongo.manager.LocalidadManager;
import com.prestafacturaService.mongo.manager.ProvinciaManager;

public class AltaClienteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(AltaClienteAction.class);

	
	@Autowired
	private ClienteManager clienteManager;
	@Autowired
	private ProvinciaManager provinciaManager;
	@Autowired
	private LocalidadManager localidadManager;
	@Autowired
	private CodigoPaisManager codigoPaisManager;
	
	private static final String ERROR = "error";
	private static final String SUCCESS = "success";
	
	private String nombreCliente;
	private String apellidoPCliente;
	private String apellidoSCliente;
	
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
	
	private Integer idCliente;
	private Cliente clienteModificacion;
	
	
	public String execute(){
		clearFieldErrors();
		try{
			
			if(idCliente==0){ //Alta
				
				System.out.print(provincia);
				System.out.print(codigoPais);
				System.out.print(localidad);
				System.out.print(localidadEntrega);
				System.out.print(provinciaEntrega);
				System.out.print(codigoPaisEntrega);
				System.out.print(provinciaEmpresa);
				System.out.print(localidadEmpresa);
				System.out.print(codigoPaisEmpresa);
				logger.info("Comienza operacion alta cliente");
				IdentificacionFiscal idFiscal= new IdentificacionFiscal();
				idFiscal.setIdentificacionFiscal(identificacionFiscal);
				logger.info("Se crea el objeto identificación fical");

				
				Provincia provinciaCliente=new Provincia();
				provinciaCliente=provinciaManager.obtenerProvinciaByName(provincia);
				
				System.out.print(provinciaCliente.getProvincia());
		
				Localidad localidadCliente= new Localidad();
				localidadCliente = localidadManager.obtenerLocalidadByName(localidad);
				System.out.print(localidadCliente.getLocalidad());
				
				CodigoPais codigoPaisCliente=new CodigoPais();
				codigoPaisCliente=codigoPaisManager.ObtenerCodigoPais(codigoPais);
				
				Direccion diCliente=new Direccion();
				diCliente.setTipodireccion("Dirección Cliente");
				diCliente.setCalle(calle);
				diCliente.setCalleAdicional(calleAdicional);
				diCliente.setCodigoPostal(codigoPostal);
				diCliente.setDepartamento(departamento);
				diCliente.setNumeroEdificio(numeroEdificio);
				diCliente.setProvincia(provinciaCliente);
				diCliente.setLocalidad(localidadCliente);
				diCliente.setPostBox(posbox);
				diCliente.setCodigoPais(codigoPaisCliente);
				
				logger.info("Se crea el objeto Direccion Cliente");

				
				
				
				//
				DetallesContacto dcCliente=new DetallesContacto();
				dcCliente.setDireccionWeb(direccionWeb);
				dcCliente.setFax(fax);
				dcCliente.setMail(mail);
				dcCliente.setPersonaContacto(personaContacto);
				dcCliente.setTelefono(telefono);
				logger.info("Se crea el objeto Detalles Contacto Cliente");

				
				
				///
				Provincia pEntrega=new Provincia();
				pEntrega=provinciaManager.obtenerProvinciaByName(provinciaEntrega);
				
				Localidad lEntrega= new Localidad();
				lEntrega = localidadManager.obtenerLocalidadByName(localidadEntrega);
				
				CodigoPais cpaisEntrega=new CodigoPais();
				cpaisEntrega=codigoPaisManager.ObtenerCodigoPais(codigoPaisEntrega);
				
				
				
				Direccion diEntrega=new DireccionEntrega();
				diEntrega.setTipodireccion("Dirección Entrega");
				diEntrega.setCalle(calleEntrega);
				diEntrega.setCalleAdicional(calleAdicionalEntrega);
				diEntrega.setCodigoPostal(codigoPostalEntrega);
				diEntrega.setDepartamento(departamentoEntrega);
				diEntrega.setNumeroEdificio(numeroEdificioEntrega);
				diEntrega.setProvincia(pEntrega);
				diEntrega.setLocalidad(lEntrega);
				diEntrega.setPostBox(posboxEntrega);
				diEntrega.setCodigoPais(cpaisEntrega);
				logger.info("Se crea el objeto Direccion Entrega");

				
				///
				Provincia pEmpresa=new Provincia();
				pEmpresa=provinciaManager.obtenerProvinciaByName(provinciaEmpresa);
				
				Localidad lEmpresa= new Localidad();
				lEmpresa = localidadManager.obtenerLocalidadByName(localidadEmpresa);
				
				CodigoPais cpaisEmpresa=new CodigoPais();
				cpaisEmpresa=codigoPaisManager.ObtenerCodigoPais(codigoPaisEmpresa);
				
				
	
				Direccion direcccionELegal=new Direccion();
				direcccionELegal.setTipodireccion("Dirección Empresa");
				direcccionELegal.setCalle(calleEmpresa);
				direcccionELegal.setCalleAdicional(calleAdicionalEmpresa);
				direcccionELegal.setCodigoPostal(codigoPostalEmpresa);
				direcccionELegal.setDepartamento(departamentoEmpresa);
				direcccionELegal.setNumeroEdificio(numeroEdificioEmpresa);
				direcccionELegal.setProvincia(pEmpresa);
				direcccionELegal.setLocalidad(lEmpresa);
				direcccionELegal.setPostBox(posboxEmpresa);
				direcccionELegal.setCodigoPais(cpaisEmpresa);
				logger.info("Se crea el objeto Direccion Empresa");

				
				
				DetallesContacto dContactoEmpresa=new DetallesContacto();
				dContactoEmpresa.setDireccionWeb(direccionWebEmpresa);
				dContactoEmpresa.setFax(faxEmpresa);
				dContactoEmpresa.setMail(mailEmpresa);
				dContactoEmpresa.setPersonaContacto(personaContactoEmpresa);
				dContactoEmpresa.setTelefono(telefonoEmpresa);
				logger.info("Se crea el objeto Detalles Contacto Empresa");
				
				//
				EntidadLegal eLCliente=new EntidadLegal();
				eLCliente.setDatosRegistrales(datosRegistrales);
				eLCliente.setNombreComercial(nombreComercial);
				eLCliente.setRazonSocial(razonSocial);
				eLCliente.setDireccion(direcccionELegal);
				logger.info("Se crea el objeto EntidadLegal");
				
				
				logger.info("Se procedera a crearse el objeto cliente");
				Cliente clienteNuevo= new Cliente();
					clienteNuevo.setNombre(nombreCliente);
					clienteNuevo.setApellido1(apellidoPCliente);
					clienteNuevo.setApellido2(apellidoSCliente);
					clienteNuevo.setIdentificacionFiscal(idFiscal);
					clienteNuevo.setDireccion(diCliente);
					clienteNuevo.setDirEntrega(diEntrega);
					clienteNuevo.setDetallesContacto(dcCliente);
					clienteNuevo.setEntidadLegal(eLCliente);
					
					
				
				clienteManager.guardarCliente(clienteNuevo);
				logger.info("Se guarda el Cliente en BD");

				
			
	////////////////////////////////////////////////////////////////////////////////////////////////
					
					
					
				}if(idCliente>0){ //Modificacion
					clienteModificacion= clienteManager.obtenerClienteById(idCliente);
					
					
					//Creacion Identificacion Fiscal
					IdentificacionFiscal idFiscal= new IdentificacionFiscal();
					idFiscal.setIdentificacionFiscal(identificacionFiscal);
					logger.info("Modificar identificacion fiscal cliente");

					//Obtener la Provincia y la localidad Cliente
					Provincia provinciaCliente=provinciaManager.obtenerProvinciaByName(provincia);
					Localidad localidadCliente=new Localidad();
					for(Localidad l:provinciaCliente.getLocalidades()){
						if(l.getLocalidad().equals(localidad)){
							localidadCliente=l;
						}
					}
					logger.info("Provincia y localidad cliente Modificado");

					//Obtener el codigo del pais
					CodigoPais codigoPaisCliente=new CodigoPais();
					codigoPaisCliente.setCodigoPais(codigoPais);
					logger.info("Codigo pais cliente Modificado");

				//Crear la Direccion del Cliente
					Direccion diCliente=new Direccion();
					diCliente.setTipodireccion("Dirección Cliente");
					diCliente.setCalle(calle);
					if(this.calleAdicional!=null || ! this.calleAdicional.trim().equals("")){
						diCliente.setCalleAdicional(calleAdicional);
					}
					diCliente.setCodigoPostal(codigoPostal);
					diCliente.setDepartamento(departamento);
					diCliente.setNumeroEdificio(numeroEdificio);
					diCliente.setProvincia(provinciaCliente);
					diCliente.setLocalidad(localidadCliente);
					diCliente.setPostBox(posbox);
					diCliente.setCodigoPais(codigoPaisCliente);
					
					logger.info("Modificar direccion cliente");

					
				//Crear los detalles de contacto
					DetallesContacto dcCliente=new DetallesContacto();
					dcCliente.setDireccionWeb(direccionWeb);
					dcCliente.setFax(fax);
					dcCliente.setMail(mail);
					dcCliente.setPersonaContacto(personaContacto);
					dcCliente.setTelefono(telefono);
					logger.info("Modificar detalles contacto cliente");

			
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

					
					
					EntidadLegal eLCliente=new EntidadLegal();
					eLCliente.setDatosRegistrales(datosRegistrales);
							if(this.direccionWebEmpresa!=null || ! this.direccionWebEmpresa.trim().equals("") &&
							this.faxEmpresa!=null || !this.faxEmpresa.trim().equals("") &&
							this.mailEmpresa!=null || ! this.mailEmpresa.trim().equals("")&&
							this.personaContactoEmpresa!=null || !mailEmpresa.trim().equals("")&&
							this.telefonoEmpresa!=null || ! this.telefonoEmpresa.trim().equals("")){
								eLCliente.setDetallesContacto(dContactoEmpresa);
							}
					eLCliente.setNombreComercial(nombreComercial);
					eLCliente.setRazonSocial(razonSocial);
					eLCliente.setDireccion(direcccionELegal);
					
					logger.info("Modificar de Entidad Legal");

				
					
					
					//Si el cliente es una persona se crea el objeto sólo con sus datos
					if(nombreCliente!=null || !nombreCliente.trim().equals("")){
						
						clienteModificacion.setNombre(nombreCliente);
						clienteModificacion.setApellido1(apellidoPCliente);
						clienteModificacion.setApellido2(apellidoSCliente);
						clienteModificacion.setIdentificacionFiscal(idFiscal);
						clienteModificacion.setDireccion(diCliente);
						clienteModificacion.setDirEntrega(diEntrega);
						//Si detalles Contacto se ha rellenado
						if(this.telefono!=null || !telefono.trim().equals("") &&
							this.fax!=null || !fax.trim().equals("") &&
							this.direccionWeb!=null || !direccionWeb.trim().equals("") &&
							this.mail!=null || !mail.trim().equals("") &&
							this.personaContacto!=null || !personaContacto.trim().equals("")){
							clienteModificacion.setDetallesContacto(dcCliente);
						}
						
						
						//Si es una empresa se crea la entidadLegal en el cliente
					}if(nombreComercial!=null && !nombreComercial.trim().equals("")){
						clienteModificacion.setEntidadLegal(eLCliente);
						clienteModificacion.setIdentificacionFiscal(idFiscal);
						clienteModificacion.setDirEntrega(diEntrega);
					}
					
					//revisar el clientemodificacion
					clienteModificacion=clienteManager.updateCliente(clienteModificacion);
					addActionMessage("El Cliente se ha modificado correctamente");
					logger.info("Modificacion CLIENTE");
					
				}
					
			
		
				
		}catch(Exception e){
			addActionError("El usuario ya existe");
		}
		
		
		return SUCCESS;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	
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



	public void validate(){
		Boolean res=camposCompletos();
		if(res==false){
			addFieldError("AltaClienteCampos", getText("altaCliente.camposInvalid"));
		}
		
	}	

	public boolean camposCompletos(){
		Boolean res=false;
		if(this.nombreCliente!=null || !this.nombreCliente.trim().equals("") &&
				this.apellidoPCliente!=null || !this.apellidoPCliente.trim().equals("") &&
				this.apellidoSCliente!=null || !this.apellidoSCliente.trim().equals("") &&
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

	
	public ClienteManager getClienteManager() {
		return clienteManager;
	}


	public void setClienteManager(ClienteManager clienteManager) {
		this.clienteManager = clienteManager;
	}


	public ProvinciaManager getProvinciaManager() {
		return provinciaManager;
	}


	public void setProvinciaManager(ProvinciaManager provinciaManager) {
		this.provinciaManager = provinciaManager;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getApellidoPCliente() {
		return apellidoPCliente;
	}


	public void setApellidoPCliente(String apellidoPCliente) {
		this.apellidoPCliente = apellidoPCliente;
	}


	public String getApellidoSCliente() {
		return apellidoSCliente;
	}


	public void setApellidoSCliente(String apellidoSCliente) {
		this.apellidoSCliente = apellidoSCliente;
	}


	public String getIdentificacionFiscal() {
		return identificacionFiscal;
	}


	public void setIdentificacionFiscal(String identificacionFiscal) {
		this.identificacionFiscal = identificacionFiscal;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getNumeroEdificio() {
		return numeroEdificio;
	}


	public void setNumeroEdificio(String numeroEdificio) {
		this.numeroEdificio = numeroEdificio;
	}


	public String getCalleAdicional() {
		return calleAdicional;
	}


	public void setCalleAdicional(String calleAdicional) {
		this.calleAdicional = calleAdicional;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
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


	public String getPosbox() {
		return posbox;
	}


	public void setPosbox(String posbox) {
		this.posbox = posbox;
	}


	public String getCalleEntrega() {
		return calleEntrega;
	}


	public void setCalleEntrega(String calleEntrega) {
		this.calleEntrega = calleEntrega;
	}


	public String getNumeroEdificioEntrega() {
		return numeroEdificioEntrega;
	}


	public void setNumeroEdificioEntrega(String numeroEdificioEntrega) {
		this.numeroEdificioEntrega = numeroEdificioEntrega;
	}


	public String getCalleAdicionalEntrega() {
		return calleAdicionalEntrega;
	}


	public void setCalleAdicionalEntrega(String calleAdicionalEntrega) {
		this.calleAdicionalEntrega = calleAdicionalEntrega;
	}


	public String getDepartamentoEntrega() {
		return departamentoEntrega;
	}


	public void setDepartamentoEntrega(String departamentoEntrega) {
		this.departamentoEntrega = departamentoEntrega;
	}


	public String getCodigoPostalEntrega() {
		return codigoPostalEntrega;
	}


	public void setCodigoPostalEntrega(String codigoPostalEntrega) {
		this.codigoPostalEntrega = codigoPostalEntrega;
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


	public String getPosboxEntrega() {
		return posboxEntrega;
	}


	public void setPosboxEntrega(String posboxEntrega) {
		this.posboxEntrega = posboxEntrega;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getDireccionWeb() {
		return direccionWeb;
	}


	public void setDireccionWeb(String direccionWeb) {
		this.direccionWeb = direccionWeb;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPersonaContacto() {
		return personaContacto;
	}


	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getNombreComercial() {
		return nombreComercial;
	}


	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}


	public String getDatosRegistrales() {
		return datosRegistrales;
	}


	public void setDatosRegistrales(String datosRegistrales) {
		this.datosRegistrales = datosRegistrales;
	}


	public String getCalleEmpresa() {
		return calleEmpresa;
	}


	public void setCalleEmpresa(String calleEmpresa) {
		this.calleEmpresa = calleEmpresa;
	}


	public String getNumeroEdificioEmpresa() {
		return numeroEdificioEmpresa;
	}


	public void setNumeroEdificioEmpresa(String numeroEdificioEmpresa) {
		this.numeroEdificioEmpresa = numeroEdificioEmpresa;
	}


	public String getCalleAdicionalEmpresa() {
		return calleAdicionalEmpresa;
	}


	public void setCalleAdicionalEmpresa(String calleAdicionalEmpresa) {
		this.calleAdicionalEmpresa = calleAdicionalEmpresa;
	}


	public String getDepartamentoEmpresa() {
		return departamentoEmpresa;
	}


	public void setDepartamentoEmpresa(String departamentoEmpresa) {
		this.departamentoEmpresa = departamentoEmpresa;
	}


	public String getCodigoPostalEmpresa() {
		return codigoPostalEmpresa;
	}


	public void setCodigoPostalEmpresa(String codigoPostalEmpresa) {
		this.codigoPostalEmpresa = codigoPostalEmpresa;
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


	public String getPosboxEmpresa() {
		return posboxEmpresa;
	}


	public void setPosboxEmpresa(String posboxEmpresa) {
		this.posboxEmpresa = posboxEmpresa;
	}


	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}


	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}


	public String getFaxEmpresa() {
		return faxEmpresa;
	}


	public void setFaxEmpresa(String faxEmpresa) {
		this.faxEmpresa = faxEmpresa;
	}


	public String getDireccionWebEmpresa() {
		return direccionWebEmpresa;
	}


	public void setDireccionWebEmpresa(String direccionWebEmpresa) {
		this.direccionWebEmpresa = direccionWebEmpresa;
	}


	public String getMailEmpresa() {
		return mailEmpresa;
	}


	public void setMailEmpresa(String mailEmpresa) {
		this.mailEmpresa = mailEmpresa;
	}


	public String getPersonaContactoEmpresa() {
		return personaContactoEmpresa;
	}


	public void setPersonaContactoEmpresa(String personaContactoEmpresa) {
		this.personaContactoEmpresa = personaContactoEmpresa;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public Cliente getClienteModificacion() {
		return clienteModificacion;
	}


	public void setClienteModificacion(Cliente clienteModificacion) {
		this.clienteModificacion = clienteModificacion;
	}

	

	
	
	
}
