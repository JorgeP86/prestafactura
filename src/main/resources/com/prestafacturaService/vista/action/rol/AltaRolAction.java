package com.prestafacturaService.vista.action.rol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.PermisoManager;
import com.prestafacturaService.mongo.manager.RecursoManager;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.SecuenceManager;

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
	@Autowired
	private SecuenceManager secuenceManager;
	
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
			//Comprobamos que no existe un rol con ese nombre
			Boolean existsNombreRol= false; // rolManager.existsNombreRol(nombreRol);
			logger.info("Comprobacion si existe el rol");

			if(existsNombreRol){
				addFieldError("invalidNombreRolAlta","El nombre del Rol ya existe");
			}else{
				Rol rol= new Rol();
				//secuenceManager.CreateSecuence();
				//Integer secuence=secuenceManager.NextSequenceId(ROL_SEQ_KEY);
				//System.out.print(secuence.toString());
				// rol.setIdrol(secuence);
				if(nombreRol!=null && nombreRol.trim().length()>0){
					rol.setNombre(nombreRol);
				}if(descripcionRol!=null && descripcionRol.trim().length()>0){
					rol.setDescripcion(descripcionRol);
				}
				List<Permiso> listaPermisosCreada=new ArrayList<Permiso>();
				
				
				Rol rolcreado=rolManager.saveRol(rol);
				logger.info("Creacion del Rol, guardado en BD");

				//Obtenemos el identificador del Rol
			
				
				 //Altas
					if(altaCliente!=0){
						Permiso altaC= this.crearPermiso(altaCliente,rolcreado);
						if(altaC!=null){
							listaPermisosCreada.add(altaC);
						}
					}if(altaDatos!=0){
						Permiso altaD=this.crearPermiso(altaDatos,rolcreado);
						if(altaD!=null){
							listaPermisosCreada.add(altaD);
						}
					}if(altaProveedor!=0){
						Permiso altaP=this.crearPermiso(altaProveedor,rolcreado);
						if(altaP!=null){
							listaPermisosCreada.add(altaP);
						}
					}if(altaRol!=0){
						Permiso altaR=this.crearPermiso(altaRol,rolcreado);
						if(altaR!=null){
							listaPermisosCreada.add(altaR);
						}
					}if(altaUsuario!=0){
						Permiso altaU=this.crearPermiso(altaUsuario,rolcreado);
						if(altaU!=null){
							listaPermisosCreada.add(altaU);
						}

					}
						//Bajas
					if(bajaCliente!=0){
						Permiso bajaC=this.crearPermiso(bajaCliente,rolcreado);
						if(bajaC!=null){
							listaPermisosCreada.add(bajaC);
						}
					}if(bajaProveedor!=0){
						Permiso bajaP=this.crearPermiso(bajaProveedor,rolcreado);
						if(bajaP!=null){
							listaPermisosCreada.add(bajaP);
						}

					}if(bajaRol!=0){
						Permiso bajaR=this.crearPermiso(bajaRol,rolcreado);
						if(bajaR!=null){
							listaPermisosCreada.add(bajaR);
						}

					}if(bajaUsuario!=0){
						Permiso bajaU=this.crearPermiso(bajaUsuario,rolcreado);
						if(bajaU!=null){
							listaPermisosCreada.add(bajaU);
						}
					}
						//consultas
					if(consultarCliente!=0){
						Permiso consultarC=this.crearPermiso(consultarCliente,rolcreado);
						if(consultarC!=null){
							listaPermisosCreada.add(consultarC);
						}
					}if(consultarDatos!=0){
						Permiso consultarD=this.crearPermiso(consultarDatos,rolcreado);
						if(consultarD!=null){
							listaPermisosCreada.add(consultarD);
						}
					}if(consultarFactura!=0){
						Permiso consultarF=this.crearPermiso(consultarFactura,rolcreado);
						if(consultarF!=null){
							listaPermisosCreada.add(consultarF);
						}
					}if(consultarFirmaElectronica!=0){
						Permiso consultarFE=this.crearPermiso(consultarFirmaElectronica,rolcreado);
						if(consultarFE!=null){
							listaPermisosCreada.add(consultarFE);
						}
					}if(consultarInformacion!=0){
						Permiso consultarI=this.crearPermiso(consultarInformacion,rolcreado);
						if(consultarI!=null){
							listaPermisosCreada.add(consultarI);
						}
					}if(consultarRol!=0){
						Permiso consultarR=this.crearPermiso(consultarRol,rolcreado);
						if(consultarR!=null){
							listaPermisosCreada.add(consultarR);
						}
					}if(consultarProveedor!=0){
						Permiso consultarP=this.crearPermiso(consultarProveedor,rolcreado);
						if(consultarP!=null){
							listaPermisosCreada.add(consultarP);
						}
					}if(consultarUsuario!=0){
						Permiso consultarUs=this.crearPermiso(consultarUsuario,rolcreado);
						if(consultarUs!=null){
							listaPermisosCreada.add(consultarUs);
						}
					}
						//Otros
					if(crearFactura!=0){
						Permiso crearF=this.crearPermiso(crearFactura,rolcreado);
						if(crearF!=null){
							listaPermisosCreada.add(crearF);
						}
					}if(descargarFactura!=0){
						Permiso descargarF=this.crearPermiso(descargarFactura,rolcreado);
						if(descargarF!=null){
							listaPermisosCreada.add(descargarF);
						}
					}
						//Editar
					if(editarCliente!=0){
						Permiso editarC=this.crearPermiso(editarCliente,rolcreado);
						if(editarC!=null){
							listaPermisosCreada.add(editarC);
						}
					}if(editarProveedor!=0){
						Permiso editarP=this.crearPermiso(editarProveedor,rolcreado);
						if(editarP!=null){
							listaPermisosCreada.add(editarP);
						}
					}if(editarRol!=0){
						Permiso editarR=this.crearPermiso(editarRol,rolcreado);
						if(editarR!=null){
							listaPermisosCreada.add(editarR);
						}
					}if(editarUsuario!=0){
						Permiso editarU=this.crearPermiso(editarUsuario,rolcreado);
						if(editarU!=null){
							listaPermisosCreada.add(editarU);
						}
					}
						//Otros2
					if(eliminarInformacion!=0){
						Permiso eliminarI=this.crearPermiso(eliminarInformacion,rolcreado);
						if(eliminarI!=null){
							listaPermisosCreada.add(eliminarI);
						}
					}if(generarFirmaElectronica!=0){
						Permiso generarFe=this.crearPermiso(generarFirmaElectronica,rolcreado);
						if(generarFe!=null){
							listaPermisosCreada.add(generarFe);
						}
					}if( publicarInformacion!=0){
						Permiso publicarI=this.crearPermiso(publicarInformacion,rolcreado);
						if(publicarI!=null){
							listaPermisosCreada.add(publicarI);
						}
					}
						//listar
					if(listarClientes!=0){
						Permiso listarC=this.crearPermiso(listarClientes,rolcreado);
						if(listarC!=null){
							listaPermisosCreada.add(listarC);
						}
					}if(listarProveedores!=0){
						Permiso listarP=this.crearPermiso(listarProveedores,rolcreado);
						if(listarP!=null){
							listaPermisosCreada.add(listarP);
						}
					}if( listarRoles!=0){
						Permiso listarR=this.crearPermiso(listarRoles,rolcreado);
						if(listarR!=null){
							listaPermisosCreada.add(listarR);
						}
					}if( listarUsuario!=0){
						Permiso listarU=this.crearPermiso(listarUsuario,rolcreado);
						if(listarU!=null){
							listaPermisosCreada.add(listarU);
						}
		}
		
	
					 logger.info("Obtenermos el rol creado");
						Rol rolupdate= rolManager.ObtenerRolByName(nombreRol);
						logger.info("Le añadimos la lista de permisos creada");
						rolupdate.setPermisos(listaPermisosCreada);
						logger.info("Lo modificamos para guardar los permisos");
						Rol rolconPermisos=rolManager.UpdateRol(rolupdate);
						
						return SUCCESS;

		}		
			
			//Obtenemos las paginas para mostrarlas	
			paginas=recursoManager.obtenerPaginas();
			logger.info("Obtener las paginas para editarlas");
		}			
	} catch (Exception e){
			addFieldError("invalidRolAlta",getText("rol.error"));
			return ERROR;
	}

		return ERROR;
}

	private void eliminarPermiso(int idpag, Rol rol) {
		 logger.info("Comienza la operacion eliminar permiso");

		Permiso permiso = null;
		Recurso pagina = null;
		List lista = null;
		
			pagina = recursoManager.obtenerPaginaById(idpag);
			// comprobamos si hay un permiso con esa pág para este rol
			 logger.info("Obtener la pagina por id");

			lista = permisoManager.buscarPermisoConPagRol(pagina, rol);
			// Comprobamos si la lista no es vacía es que existe y debemos
			// eleminarlo
			 logger.info("comprobamos si hay un permiso con esa pág para este rol");

			if (lista.size() != 0) {
				permiso = (Permiso) lista.get(0);
				permisoManager.bajaPermiso(permiso);
				 logger.info("eliminamos el permiso");

			}
		
	}

	// Método que permite crear el permiso
	public Permiso crearPermiso(int seleccion, Rol rol) {
		 logger.info("Comienza la operacion crear permiso");

		Permiso permiso = new Permiso();
		List permisos = null;
		
			// obtenemos la pág seleccionada en el combox
			Recurso pagina = recursoManager.obtenerPaginaById(new Integer(
					seleccion));
			 logger.info("obtenemos la pág seleccionada en el combox");

			// creamos un permiso con esa pag y el rol
			// comprobamos si existia o no anteriormente

			permisos = permisoManager.buscarPermisoConPagRol(pagina, rol);
			 logger.info("obtenemos el permiso con pagina y rol");

			if (permisos.size() == 0) {
				permiso.setRecurso(pagina);
				permiso.setRol(rol);
				Map<Recurso, Rol> mapa = new HashMap<Recurso, Rol>();
				mapa.put(pagina, rol);
				permiso.setPermisos(mapa);
				permisoManager.altaPermiso(permiso);
				 logger.info("Damos de alta el permiso");

			}
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
