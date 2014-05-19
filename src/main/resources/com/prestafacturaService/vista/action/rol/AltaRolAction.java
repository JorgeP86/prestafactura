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

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String SUCCESSEDITAR = "successEditar";
	public static final String ERROR = "error";
	
	private static final String ROL_SEQ_KEY = "idRol";
	
	
	@Autowired
	private RolManager rolManager;
	@Autowired
	private PermisoManager permisoManager;
	@Autowired
	private RecursoManager recursoManager;
	
	private String nombreRol;
	private String descripcionRol;

	private Collection paginas;

	// Permisos
	private int altaCliente;
	private int altaDatos;
	private int altaProveedor;
	private int altaRol;
	private int altaUsuario;

	private int bajaCliente;
	private int bajaProveedor;
	private int bajaRol;
	private int bajaUsuario;

	private int consultarCliente;
	private int consultarDatos;
	private int consultarFactura;
	private int consultarFirmaElectronica;
	private int consultarInformacion;
	private int consultarRol;
	private int consultarProveedor;
	private int consultarUsuario;

	private int crearFactura;
	private int descargarFactura;

	private int editarCliente;
	private int editarProveedor;
	private int editarRol;
	private int editarUsuario;

	private int eliminarInformacion;
	private int generarFirmaElectronica;

	private int listarClientes;
	private int listarProveedores;
	private int listarRoles;
	private int listarUsuario;

	private int publicarInformacion;

	private int idRol;
	private int idpagina;

	public String execute(){
			clearFieldErrors();
		try{
			

			if(idRol==0){
				logger.info("Comprobacion si idRol==0");
				List<Permiso> listaPermisosCreada=new ArrayList<Permiso>();
				logger.info("Inicializamos la lista de permisos");
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
				if(bajaCliente!=0){
					Permiso bajaC=this.crearPermiso(bajaCliente);
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
				if(consultarCliente!=0){
					Permiso consultarC=this.crearPermiso(consultarCliente);
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
				if(editarCliente!=0){
					Permiso editarC=this.crearPermiso(editarCliente);
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
				}if( listarUsuario!=0){
					Permiso listarU=this.crearPermiso(listarUsuario);
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

				Rol rolcreado=rolManager.saveRol(rolNuevo);
				logger.info("Guardamos el Rol");

				
			}
		}catch(Exception e){
			addFieldError("invalidRolAlta",getText("rol.error"));
			return ERROR;
		}
		return SUCCESS;
	}		
			
	
		
		
		// Método que permite crear el permiso
		public Permiso crearPermiso(int seleccion) {
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

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public Collection getPaginas() {
		return paginas;
	}

	public void setPaginas(Collection paginas) {
		this.paginas = paginas;
	}

}
