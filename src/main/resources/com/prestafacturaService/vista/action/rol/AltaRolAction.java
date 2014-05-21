package com.prestafacturaService.vista.action.rol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.PermisoManager;
import com.prestafacturaService.mongo.manager.RecursoManager;
import com.prestafacturaService.mongo.manager.RolManager;


public class AltaRolAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6555855280536309585L;

	private static final Logger logger = Logger.getLogger(AltaRolAction.class);

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	
	@Autowired
	private RolManager rolManager;
	@Autowired
	private PermisoManager permisoManager;
	@Autowired
	private RecursoManager recursoManager;
	
	private String nombreRol;
	private String descripcionRol;

	private Collection<Recurso> paginas;

	// Permisos
	private int altaCliente;
	private int altaDatos;
	private int altaProveedor;
	private int altaRol;
	private int altaUsuario;
	
	private int bajaClientes;
	private int bajaProveedor;
	private int bajaRol;
	private int bajaUsuario;

	private int consultarClientes;
	private int consultarDatos;
	private int consultarFactura;
	private int consultarFirmaElectronica;
	private int consultarInformacion;
	private int consultarRol;
	private int consultarProveedor;
	private int consultarUsuario;

	private int crearFactura;
	private int descargarFactura;

	private int editarClientes;
	private int editarProveedor;
	private int editarRol;
	private int editarUsuario;
	private int editarDatos;
	

	private int eliminarInformacion;
	private int generarFirmaElectronica;

	private int listarClientes;
	private int listarProveedores;
	private int listarRoles;
	private int listarUsuarios;
	
	private int publicarInformacion;
	
	private int gestionInformacion;
	private int gestionFirmaElectronica;
	private int gestionFacturasAlmacenadas;
	private int gestionFactura;
	private int gestionDatosInternos;
	private int gestionClientes;
	private int gestionProveedores;
	private int gestionRoles;
	private int gestionUsuarios;
	
	private int idRol;
	private int idpagina;

	public String execute(){
			clearFieldErrors();
		try{
			System.out.println("El valor a mostrar es:" + altaCliente);
			System.out.println("El valor a mostrar es:" + altaDatos);
			System.out.println("El valor a mostrar es:" + altaProveedor);
			System.out.println("El valor a mostrar es:" + altaRol);
			System.out.println("El valor a mostrar es:" + altaUsuario);
			System.out.println("El valor a mostrar es:" + consultarClientes);
			System.out.println("El valor a mostrar es:" + descargarFactura);
			System.out.println("El valor a mostrar es:" + nombreRol);
			System.out.println("El valor a mostrar es:" + descripcionRol);
			if(idRol==0){
				logger.info("Comprobacion si idRol==0");
				List<Permiso> listaPermisosCreada=new ArrayList<Permiso>();
				logger.info("Inicializamos la lista de permisos vacía");
				//Altas
				if(altaCliente!=0){
					Permiso altaC= this.crearPermiso(altaCliente);
					if(altaC!=null){
						listaPermisosCreada.add(altaC);
					}
				}if(altaDatos!=0){
					Permiso altaD=this.crearPermiso(altaDatos);
					if(altaD!=null){
						listaPermisosCreada.add(altaD);
					}
				}if(altaProveedor!=0){
					Permiso altaP=this.crearPermiso(altaProveedor);
					if(altaP!=null){
						listaPermisosCreada.add(altaP);
					}
				}if(altaRol!=0){
					Permiso altaR=this.crearPermiso(altaRol);
					if(altaR!=null){
						listaPermisosCreada.add(altaR);
					}
				}if(altaUsuario!=0){
					Permiso altaU=this.crearPermiso(altaUsuario);
					if(altaU!=null){
						listaPermisosCreada.add(altaU);
					}

				}
					//Bajas
				if(bajaClientes!=0){
					Permiso bajaC=this.crearPermiso(bajaClientes);
					if(bajaC!=null){
						listaPermisosCreada.add(bajaC);
					}
				}if(bajaProveedor!=0){
					Permiso bajaP=this.crearPermiso(bajaProveedor);
					if(bajaP!=null){
						listaPermisosCreada.add(bajaP);
					}

				}if(bajaRol!=0){
					Permiso bajaR=this.crearPermiso(bajaRol);
					if(bajaR!=null){
						listaPermisosCreada.add(bajaR);
					}

				}if(bajaUsuario!=0){
					Permiso bajaU=this.crearPermiso(bajaUsuario);
					if(bajaU!=null){
						listaPermisosCreada.add(bajaU);
					}
				}
					//consultas
				if(consultarClientes!=0){
					Permiso consultarC=this.crearPermiso(consultarClientes);
					if(consultarC!=null){
						listaPermisosCreada.add(consultarC);
					}
				}if(consultarDatos!=0){
					Permiso consultarD=this.crearPermiso(consultarDatos);
					if(consultarD!=null){
						listaPermisosCreada.add(consultarD);
					}
				}if(consultarFactura!=0){
					Permiso consultarF=this.crearPermiso(consultarFactura);
					if(consultarF!=null){
						listaPermisosCreada.add(consultarF);
					}
				}if(consultarFirmaElectronica!=0){
					Permiso consultarFE=this.crearPermiso(consultarFirmaElectronica);
					if(consultarFE!=null){
						listaPermisosCreada.add(consultarFE);
					}
				}if(consultarInformacion!=0){
					Permiso consultarI=this.crearPermiso(consultarInformacion);
					if(consultarI!=null){
						listaPermisosCreada.add(consultarI);
					}
				}if(consultarRol!=0){
					Permiso consultarR=this.crearPermiso(consultarRol);
					if(consultarR!=null){
						listaPermisosCreada.add(consultarR);
					}
				}if(consultarProveedor!=0){
					Permiso consultarP=this.crearPermiso(consultarProveedor);
					if(consultarP!=null){
						listaPermisosCreada.add(consultarP);
					}
				}if(consultarUsuario!=0){
					Permiso consultarUs=this.crearPermiso(consultarUsuario);
					if(consultarUs!=null){
						listaPermisosCreada.add(consultarUs);
					}
				}
					//Otros
				if(crearFactura!=0){
					Permiso crearF=this.crearPermiso(crearFactura);
					if(crearF!=null){
						listaPermisosCreada.add(crearF);
					}
				}if(descargarFactura!=0){
					Permiso descargarF=this.crearPermiso(descargarFactura);
					if(descargarF!=null){
						listaPermisosCreada.add(descargarF);
					}
				}
					//Editar
				if(editarClientes!=0){
					Permiso editarC=this.crearPermiso(editarClientes);
					if(editarC!=null){
						listaPermisosCreada.add(editarC);
					}
				}if(editarProveedor!=0){
					Permiso editarP=this.crearPermiso(editarProveedor);
					if(editarP!=null){
						listaPermisosCreada.add(editarP);
					}
				}if(editarRol!=0){
					Permiso editarR=this.crearPermiso(editarRol);
					if(editarR!=null){
						listaPermisosCreada.add(editarR);
					}
				}if(editarUsuario!=0){
					Permiso editarU=this.crearPermiso(editarUsuario);
					if(editarU!=null){
						listaPermisosCreada.add(editarU);
					}
				}if(editarDatos!=0){
					Permiso editarDa=this.crearPermiso(editarDatos);
					if(editarDa!=null){
						listaPermisosCreada.add(editarDa);
					}
				}
					//Otros2
				if(eliminarInformacion!=0){
					Permiso eliminarI=this.crearPermiso(eliminarInformacion);
					if(eliminarI!=null){
						listaPermisosCreada.add(eliminarI);
					}
				}if(generarFirmaElectronica!=0){
					Permiso generarFe=this.crearPermiso(generarFirmaElectronica);
					if(generarFe!=null){
						listaPermisosCreada.add(generarFe);
					}
				}if( publicarInformacion!=0){
					Permiso publicarI=this.crearPermiso(publicarInformacion);
					if(publicarI!=null){
						listaPermisosCreada.add(publicarI);
					}
				}
					//listar
				if(listarClientes!=0){
					Permiso listarC=this.crearPermiso(listarClientes);
					if(listarC!=null){
						listaPermisosCreada.add(listarC);
					}
				}if(listarProveedores!=0){
					Permiso listarP=this.crearPermiso(listarProveedores);
					if(listarP!=null){
						listaPermisosCreada.add(listarP);
					}
				}if( listarRoles!=0){
					Permiso listarR=this.crearPermiso(listarRoles);
					if(listarR!=null){
						listaPermisosCreada.add(listarR);
					}
				}if( listarUsuarios!=0){
					Permiso listarU=this.crearPermiso(listarUsuarios);
					if(listarU!=null){
						listaPermisosCreada.add(listarU);
					}
				}//fin if
				
				logger.info("Terminamos de crear los permisos y añadirlos a la lista");

				Rol rolNuevo= new Rol();
				logger.info("Inicializamos el rol");

				if(nombreRol!=null && nombreRol.trim().length()>0){
					rolNuevo.setNombre(nombreRol);
					logger.info("Le añades el nombre");

				}if(descripcionRol!=null && descripcionRol.trim().length()>0){
					rolNuevo.setDescripcion(descripcionRol);
					logger.info("Le añades el descripcion");

				}if(listaPermisosCreada.size()!=0){
					rolNuevo.setPermisos(listaPermisosCreada);
					logger.info("Le añades la lista de permisos");
				}
				logger.info("El objeto Rol creado");

				Rol rolcreado = rolManager.saveRol(rolNuevo);
				logger.info("Guardamos el Rol");
				System.out.println("El rol a mostrar es:" + rolcreado.getDescripcion());

				
			}
		}catch(Exception e){
			addFieldError("invalidRolAlta",getText("rol.error"));
			return ERROR;
		}
		return SUCCESS;
	}		

		// Método que permite crear el permiso
		private Permiso crearPermiso(int seleccion) {
			logger.info("Comienza la operacion crear permiso");

			Permiso permiso = new Permiso();
			
				// obtenemos la pág seleccionada en el combox
				Recurso pagina = recursoManager.obtenerPaginaById(new Integer(
						seleccion));
				logger.info("obtenemos la pág seleccionada en el combox");

				// creamos un permiso con esa pag 
		
				permiso.setRecurso(pagina);
				permisoManager.altaPermiso(permiso);
					logger.info("Damos de alta el permiso");
					return permiso;
		}

		public RolManager getRolManager() {
			return rolManager;
		}

		public void setRolManager(RolManager rolManager) {
			this.rolManager = rolManager;
		}

		public PermisoManager getPermisoManager() {
			return permisoManager;
		}

		public void setPermisoManager(PermisoManager permisoManager) {
			this.permisoManager = permisoManager;
		}

		public RecursoManager getRecursoManager() {
			return recursoManager;
		}

		public void setRecursoManager(RecursoManager recursoManager) {
			this.recursoManager = recursoManager;
		}

		public String getNombreRol() {
			return nombreRol;
		}

		public void setNombreRol(String nombreRol) {
			this.nombreRol = nombreRol;
		}

		public String getDescripcionRol() {
			return descripcionRol;
		}

		public void setDescripcionRol(String descripcionRol) {
			this.descripcionRol = descripcionRol;
		}

		public Collection<Recurso> getPaginas() {
			return paginas;
		}

		public void setPaginas(Collection<Recurso> paginas) {
			this.paginas = paginas;
		}

		public int getAltaCliente() {
			return altaCliente;
		}

		public void setAltaCliente(int altaCliente) {
			this.altaCliente = altaCliente;
		}

		public int getAltaDatos() {
			return altaDatos;
		}

		public void setAltaDatos(int altaDatos) {
			this.altaDatos = altaDatos;
		}

		public int getAltaProveedor() {
			return altaProveedor;
		}

		public void setAltaProveedor(int altaProveedor) {
			this.altaProveedor = altaProveedor;
		}

		public int getAltaRol() {
			return altaRol;
		}

		public void setAltaRol(int altaRol) {
			this.altaRol = altaRol;
		}

		public int getAltaUsuario() {
			return altaUsuario;
		}

		public void setAltaUsuario(int altaUsuario) {
			this.altaUsuario = altaUsuario;
		}

		public int getBajaClientes() {
			return bajaClientes;
		}

		public void setBajaClientes(int bajaClientes) {
			this.bajaClientes = bajaClientes;
		}

		public int getBajaProveedor() {
			return bajaProveedor;
		}

		public void setBajaProveedor(int bajaProveedor) {
			this.bajaProveedor = bajaProveedor;
		}

		public int getBajaRol() {
			return bajaRol;
		}

		public void setBajaRol(int bajaRol) {
			this.bajaRol = bajaRol;
		}

		public int getBajaUsuario() {
			return bajaUsuario;
		}

		public void setBajaUsuario(int bajaUsuario) {
			this.bajaUsuario = bajaUsuario;
		}

		public int getConsultarClientes() {
			return consultarClientes;
		}

		public void setConsultarClientes(int consultarClientes) {
			this.consultarClientes = consultarClientes;
		}

		public int getConsultarDatos() {
			return consultarDatos;
		}

		public void setConsultarDatos(int consultarDatos) {
			this.consultarDatos = consultarDatos;
		}

		public int getConsultarFactura() {
			return consultarFactura;
		}

		public void setConsultarFactura(int consultarFactura) {
			this.consultarFactura = consultarFactura;
		}

		public int getConsultarFirmaElectronica() {
			return consultarFirmaElectronica;
		}

		public void setConsultarFirmaElectronica(int consultarFirmaElectronica) {
			this.consultarFirmaElectronica = consultarFirmaElectronica;
		}

		public int getConsultarInformacion() {
			return consultarInformacion;
		}

		public void setConsultarInformacion(int consultarInformacion) {
			this.consultarInformacion = consultarInformacion;
		}

		public int getConsultarRol() {
			return consultarRol;
		}

		public void setConsultarRol(int consultarRol) {
			this.consultarRol = consultarRol;
		}

		public int getConsultarProveedor() {
			return consultarProveedor;
		}

		public void setConsultarProveedor(int consultarProveedor) {
			this.consultarProveedor = consultarProveedor;
		}

		public int getConsultarUsuario() {
			return consultarUsuario;
		}

		public void setConsultarUsuario(int consultarUsuario) {
			this.consultarUsuario = consultarUsuario;
		}

		public int getCrearFactura() {
			return crearFactura;
		}

		public void setCrearFactura(int crearFactura) {
			this.crearFactura = crearFactura;
		}

		public int getDescargarFactura() {
			return descargarFactura;
		}

		public void setDescargarFactura(int descargarFactura) {
			this.descargarFactura = descargarFactura;
		}

		public int getEditarClientes() {
			return editarClientes;
		}

		public void setEditarClientes(int editarClientes) {
			this.editarClientes = editarClientes;
		}

		public int getEditarProveedor() {
			return editarProveedor;
		}

		public void setEditarProveedor(int editarProveedor) {
			this.editarProveedor = editarProveedor;
		}

		public int getEditarRol() {
			return editarRol;
		}

		public void setEditarRol(int editarRol) {
			this.editarRol = editarRol;
		}

		public int getEditarUsuario() {
			return editarUsuario;
		}

		public void setEditarUsuario(int editarUsuario) {
			this.editarUsuario = editarUsuario;
		}

		public int getEditarDatos() {
			return editarDatos;
		}

		public void setEditarDatos(int editarDatos) {
			this.editarDatos = editarDatos;
		}

		public int getEliminarInformacion() {
			return eliminarInformacion;
		}

		public void setEliminarInformacion(int eliminarInformacion) {
			this.eliminarInformacion = eliminarInformacion;
		}

		public int getGenerarFirmaElectronica() {
			return generarFirmaElectronica;
		}

		public void setGenerarFirmaElectronica(int generarFirmaElectronica) {
			this.generarFirmaElectronica = generarFirmaElectronica;
		}

		public int getListarClientes() {
			return listarClientes;
		}

		public void setListarClientes(int listarClientes) {
			this.listarClientes = listarClientes;
		}

		public int getListarProveedores() {
			return listarProveedores;
		}

		public void setListarProveedores(int listarProveedores) {
			this.listarProveedores = listarProveedores;
		}

		public int getListarRoles() {
			return listarRoles;
		}

		public void setListarRoles(int listarRoles) {
			this.listarRoles = listarRoles;
		}

		public int getListarUsuarios() {
			return listarUsuarios;
		}

		public void setListarUsuarios(int listarUsuarios) {
			this.listarUsuarios = listarUsuarios;
		}

		public int getPublicarInformacion() {
			return publicarInformacion;
		}

		public void setPublicarInformacion(int publicarInformacion) {
			this.publicarInformacion = publicarInformacion;
		}

		public int getGestionInformacion() {
			return gestionInformacion;
		}

		public void setGestionInformacion(int gestionInformacion) {
			this.gestionInformacion = gestionInformacion;
		}

		public int getGestionFirmaElectronica() {
			return gestionFirmaElectronica;
		}

		public void setGestionFirmaElectronica(int gestionFirmaElectronica) {
			this.gestionFirmaElectronica = gestionFirmaElectronica;
		}

		public int getGestionFacturasAlmacenadas() {
			return gestionFacturasAlmacenadas;
		}

		public void setGestionFacturasAlmacenadas(int gestionFacturasAlmacenadas) {
			this.gestionFacturasAlmacenadas = gestionFacturasAlmacenadas;
		}

		public int getGestionFactura() {
			return gestionFactura;
		}

		public void setGestionFactura(int gestionFactura) {
			this.gestionFactura = gestionFactura;
		}

		public int getGestionDatosInternos() {
			return gestionDatosInternos;
		}

		public void setGestionDatosInternos(int gestionDatosInternos) {
			this.gestionDatosInternos = gestionDatosInternos;
		}

		public int getGestionClientes() {
			return gestionClientes;
		}

		public void setGestionClientes(int gestionClientes) {
			this.gestionClientes = gestionClientes;
		}

		public int getGestionProveedores() {
			return gestionProveedores;
		}

		public void setGestionProveedores(int gestionProveedores) {
			this.gestionProveedores = gestionProveedores;
		}

		public int getGestionRoles() {
			return gestionRoles;
		}

		public void setGestionRoles(int gestionRoles) {
			this.gestionRoles = gestionRoles;
		}

		public int getGestionUsuarios() {
			return gestionUsuarios;
		}

		public void setGestionUsuarios(int gestionUsuarios) {
			this.gestionUsuarios = gestionUsuarios;
		}

		public int getIdRol() {
			return idRol;
		}

		public void setIdRol(int idRol) {
			this.idRol = idRol;
		}

		public int getIdpagina() {
			return idpagina;
		}

		public void setIdpagina(int idpagina) {
			this.idpagina = idpagina;
		}
	

}
