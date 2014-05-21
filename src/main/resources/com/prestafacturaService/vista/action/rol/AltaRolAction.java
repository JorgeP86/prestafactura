package com.prestafacturaService.vista.action.rol;

import java.util.ArrayList;
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
	
	private List<String> pathList;

	private int idRol;
	

	public String execute(){
		clearFieldErrors();
		try{
			System.out.println("El valor a mostrar es:" + pathList.get(0));
			System.out.println("El valor a mostrar es:" + nombreRol);
			System.out.println("El valor a mostrar es:" + descripcionRol);
			if(idRol==0){
				if(pathList.size()!=0){
				logger.info("Comprobacion si idRol==0");
				List<Permiso> listaPermisosCreada=new ArrayList<Permiso>();
				logger.info("Inicializamos la lista de permisos vacía");
				//Altas
				
				if(pathList.contains("altaCliente")){
					Permiso altaC= this.crearPermiso("altaCliente");
					if(altaC!=null){
						listaPermisosCreada.add(altaC);
					}
				}if(pathList.contains("altaDatos")){
					Permiso altaD=this.crearPermiso("altaDatos");
					if(altaD!=null){
						listaPermisosCreada.add(altaD);
					}
				}if(pathList.contains("altaProveedor")){
					Permiso altaP=this.crearPermiso("altaProveedor");
					if(altaP!=null){
						listaPermisosCreada.add(altaP);
					}
				}if(pathList.contains("altaRol")){
					Permiso altaR=this.crearPermiso("altaRol");
					if(altaR!=null){
						listaPermisosCreada.add(altaR);
					}
				}if(pathList.contains("altaUsuario")){
					Permiso altaU=this.crearPermiso("altaUsuario");
					if(altaU!=null){
						listaPermisosCreada.add(altaU);
					}

				}
					//Bajas
				if(pathList.contains("bajaClientes")){
					Permiso bajaC=this.crearPermiso("bajaClientes");
					if(bajaC!=null){
						listaPermisosCreada.add(bajaC);
					}
				}if(pathList.contains("bajaProveedor")){
					Permiso bajaP=this.crearPermiso("bajaProveedor");
					if(bajaP!=null){
						listaPermisosCreada.add(bajaP);
					}

				}if(pathList.contains("bajaRol")){
					Permiso bajaR=this.crearPermiso("bajaRol");
					if(bajaR!=null){
						listaPermisosCreada.add(bajaR);
					}

				}if(pathList.contains("bajaUsuario!=0")){
					Permiso bajaU=this.crearPermiso("bajaUsuario");
					if(bajaU!=null){
						listaPermisosCreada.add(bajaU);
					}
				}
					//consultas
				if(pathList.contains("consultarClientes")){
					Permiso consultarC=this.crearPermiso("consultarClientes");
					if(consultarC!=null){
						listaPermisosCreada.add(consultarC);
					}
				}if(pathList.contains("consultarDatos")){
					Permiso consultarD=this.crearPermiso("consultarDatos");
					if(consultarD!=null){
						listaPermisosCreada.add(consultarD);
					}
				}if(pathList.contains("consultarFactura")){
					Permiso consultarF=this.crearPermiso("consultarFactura");
					if(consultarF!=null){
						listaPermisosCreada.add(consultarF);
					}
				}if(pathList.contains("consultarFirmaElectronica")){
					Permiso consultarFE=this.crearPermiso("consultarFirmaElectronica");
					if(consultarFE!=null){
						listaPermisosCreada.add(consultarFE);
					}
				}if(pathList.contains("consultarInformacion")){
					Permiso consultarI=this.crearPermiso("consultarInformacion");
					if(consultarI!=null){
						listaPermisosCreada.add(consultarI);
					}
				}if(pathList.contains("consultarRol")){
					Permiso consultarR=this.crearPermiso("consultarRol");
					if(consultarR!=null){
						listaPermisosCreada.add(consultarR);
					}
				}if(pathList.contains("consultarProveedor")){
					Permiso consultarP=this.crearPermiso("consultarProveedor");
					if(consultarP!=null){
						listaPermisosCreada.add(consultarP);
					}
				}if(pathList.contains("consultarUsuario")){
					Permiso consultarUs=this.crearPermiso("consultarUsuario");
					if(consultarUs!=null){
						listaPermisosCreada.add(consultarUs);
					}
				}
					//Otros
				if(pathList.contains("crearFactura")){
					Permiso crearF=this.crearPermiso("crearFactura");
					if(crearF!=null){
						listaPermisosCreada.add(crearF);
					}
				}if(pathList.contains("descargarFactura")){
					Permiso descargarF=this.crearPermiso("descargarFactura");
					if(descargarF!=null){
						listaPermisosCreada.add(descargarF);
					}
				}
					//Editar
				if(pathList.contains("editarClientes")){
					Permiso editarC=this.crearPermiso("editarClientes");
					if(editarC!=null){
						listaPermisosCreada.add(editarC);
					}
				}if(pathList.contains("editarProveedor")){
					Permiso editarP=this.crearPermiso("editarProveedor");
					if(editarP!=null){
						listaPermisosCreada.add(editarP);
					}
				}if(pathList.contains("editarRol")){
					Permiso editarR=this.crearPermiso("editarRol");
					if(editarR!=null){
						listaPermisosCreada.add(editarR);
					}
				}if(pathList.contains("editarUsuario")){
					Permiso editarU=this.crearPermiso("editarUsuario");
					if(editarU!=null){
						listaPermisosCreada.add(editarU);
					}
				}if(pathList.contains("editarDatos")){
					Permiso editarDa=this.crearPermiso("editarDatos");
					if(editarDa!=null){
						listaPermisosCreada.add(editarDa);
					}
				}
					//Otros2
				if(pathList.contains("eliminarInformacion")){
					Permiso eliminarI=this.crearPermiso("eliminarInformacion");
					if(eliminarI!=null){
						listaPermisosCreada.add(eliminarI);
					}
				}if(pathList.contains("generarFirmaElectronica")){
					Permiso generarFe=this.crearPermiso("generarFirmaElectronica");
					if(generarFe!=null){
						listaPermisosCreada.add(generarFe);
					}
				}if( pathList.contains("publicarInformacion")){
					Permiso publicarI=this.crearPermiso("publicarInformacion");
					if(publicarI!=null){
						listaPermisosCreada.add(publicarI);
					}
				}
					//listar
				if(pathList.contains("listarClientes")){
					Permiso listarC=this.crearPermiso("listarClientes");
					if(listarC!=null){
						listaPermisosCreada.add(listarC);
					}
				}if(pathList.contains("listarProveedores")){
					Permiso listarP=this.crearPermiso("listarProveedores");
					if(listarP!=null){
						listaPermisosCreada.add(listarP);
					}
				}if(pathList.contains("listarRoles")){
					Permiso listarR=this.crearPermiso("listarRoles");
					if(listarR!=null){
						listaPermisosCreada.add(listarR);
					}
				}if( pathList.contains("listarUsuarios")){
					Permiso listarU=this.crearPermiso("listarUsuarios");
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
				
			}
		}catch(Exception e){
			addFieldError("invalidRolAlta",getText("rol.error"));
			return ERROR;
		}
		return SUCCESS;
	}		

		// Método que permite crear el permiso
		private Permiso crearPermiso(String path) {
			logger.info("Comienza la operacion crear permiso");

			Permiso permiso = new Permiso();
			
				// obtenemos la pág seleccionada en el combox
				Recurso pagina = recursoManager.obtenerPaginaBypath(path);
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

		public List<String> getPathList() {
			return pathList;
		}

		public void setPathList(List<String> pathList) {
			this.pathList = pathList;
		}

		public int getIdRol() {
			return idRol;
		}

		public void setIdRol(int idRol) {
			this.idRol = idRol;
		}
		

	

		

}