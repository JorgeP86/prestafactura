package com.prestafacturaService.vista.action.cliente;

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
import com.prestafacturaService.mongo.manager.ProvinciaManager;

public class AltaClienteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteManager clienteManager;
	@Autowired
	private ProvinciaManager provinciaManager;
	
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
	
	public String execute(){
		clearFieldErrors();
		try{
			
			if(idCliente==0){ //Alta
				if(clienteManager.existCliente(identificacionFiscal)){
					
				//Creacion Identificacion Fiscal
					IdentificacionFiscal idFiscal= new IdentificacionFiscal();
					idFiscal.setIdentificacionFiscal(identificacionFiscal);
					
					//Obtener la Provincia y la localidad Cliente
					Provincia provinciaCliente=provinciaManager.obtenerProvinciaByName(provincia);
					Localidad localidadCliente=new Localidad();
					for(Localidad l:provinciaCliente.getLocalidades()){
						if(l.getLocalidad().equals(localidad)){
							localidadCliente=l;
						}
					}
					//Obtener el codigo del pais
					CodigoPais codigoPaisCliente=new CodigoPais();
					codigoPaisCliente.setCodigoPais(codigoPais);
					
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
					
					
					
				//Crear los detalles de contacto
					DetallesContacto dcCliente=new DetallesContacto();
					dcCliente.setDireccionWeb(direccionWeb);
					dcCliente.setFax(fax);
					dcCliente.setMail(mail);
					dcCliente.setPersonaContacto(personaContacto);
					dcCliente.setTelefono(telefono);
			
				//Creación de la dirección de Entrega
					
		
					Provincia pEntrega=provinciaManager.obtenerProvinciaByName(provinciaEntrega);
					Localidad lEntrega=new Localidad();
					for(Localidad l:pEntrega.getLocalidades()){
						if(l.getLocalidad().equals(localidadEntrega)){
							lEntrega=l;
						}
					}
								//Creacion del codigoPais
					CodigoPais cpaisEntrega= new CodigoPais();
					cpaisEntrega.setCodigoPais(codigoPaisEntrega);
					
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
					
				
					
				//Creacion Entidad Legal
					
			
					
					Provincia pEmpresa=provinciaManager.obtenerProvinciaByName(provinciaEmpresa);
					Localidad lEmpresa=new Localidad();
					for(Localidad l:pEmpresa.getLocalidades()){
						if(l.getLocalidad().equals(localidadEmpresa)){
							lEmpresa=l;
						}
					}
					
					//Creacion del codigoPais
					CodigoPais cpaisEmpresa= new CodigoPais();
					cpaisEmpresa.setCodigoPais(codigoPaisEntrega);
					
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
					
					
					DetallesContacto dContactoEmpresa=new DetallesContacto();
					dContactoEmpresa.setDireccionWeb(direccionWebEmpresa);
					dContactoEmpresa.setFax(faxEmpresa);
					dContactoEmpresa.setMail(mailEmpresa);
					dContactoEmpresa.setPersonaContacto(personaContactoEmpresa);
					dContactoEmpresa.setTelefono(telefonoEmpresa);
					
					
					
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
					
					
					
				//Creación del Cliente
					Cliente clienteNuevo=new Cliente();
					clienteNuevo.setIdentificacionDeFigura("Cliente");
					
					//Si el cliente es una persona se crea el objeto sólo con sus datos
					if(nombreCliente!=null || !nombreCliente.trim().equals("")){
						clienteNuevo.setNombre(nombreCliente);
						clienteNuevo.setApellido1(apellidoPCliente);
						clienteNuevo.setApellido2(apellidoSCliente);
						clienteNuevo.setIdentificacionFiscal(idFiscal);
						clienteNuevo.setDireccion(diCliente);
						clienteNuevo.setDirEntrega(diEntrega);
						//Si detalles Contacto se ha rellenado
						if(this.telefono!=null || !telefono.trim().equals("") &&
							this.fax!=null || !fax.trim().equals("") &&
							this.direccionWeb!=null || !direccionWeb.trim().equals("") &&
							this.mail!=null || !mail.trim().equals("") &&
							this.personaContacto!=null || !personaContacto.trim().equals("")){
							clienteNuevo.setDetallesContacto(dcCliente);
						}
						
						
						//Si es una empresa se cre la entidadLegal en el cliente
					}if(nombreComercial!=null && !nombreComercial.trim().equals("")){
						clienteNuevo.setEntidadLegal(eLCliente);
						clienteNuevo.setIdentificacionFiscal(idFiscal);
						clienteNuevo.setDirEntrega(diEntrega);
					}
					
					//GuardarCliente
					
					clienteManager.guardarCliente(clienteNuevo);
					addActionMessage("El Cliente se ha creado correctamente");
					
					
				}if(idCliente>0){ //Modificacion
					
				}
					
				}if(idCliente<0){//eliminación
			}
			return SUCCESS;
		}catch(Exception e){
			addActionError("El usuario ya existe");
		}
		
		
		return SUCCESS;
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


}
