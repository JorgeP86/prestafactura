package com.prestafacturaService.vista.action.rol;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String SUCCESSEDITAR = "successEditar";
	public static final String ERROR = "error";

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
			//Comprobamos que no existe un rol con ese nombre
			Boolean existsNombreRol= rolManager.existsNombreRol(nombreRol);
			if(existsNombreRol){
				addFieldError("invalidNombreRolAlta","El nombre del Rol ya existe");
			}else{
				Rol rol= new Rol();
				  rol.setIdrol(new Integer(UUID.randomUUID().toString()));
				if(nombreRol!=null && nombreRol.trim().length()>0){
					rol.setNombre(nombreRol);
				}if(descripcionRol!=null && descripcionRol.trim().length()>0){
					rol.setDescripcion(descripcionRol);
				}
			
					//Altas
				if(altaCliente!=0){
					this.crearPermiso(altaCliente,rol);
				}if(altaDatos!=0){
					this.crearPermiso(altaDatos,rol);
				}if(altaProveedor!=0){
					this.crearPermiso(altaProveedor,rol);
				}if(altaRol!=0){
					this.crearPermiso(altaRol,rol);
				}if(altaUsuario!=0){
					this.crearPermiso(altaUsuario,rol);
				}
					//Bajas
				if(bajaCliente!=0){
					this.crearPermiso(bajaCliente,rol);
				}if(bajaProveedor!=0){
					this.crearPermiso(bajaProveedor,rol);
				}if(bajaRol!=0){
					this.crearPermiso(bajaRol,rol);
				}if(bajaUsuario!=0){
					this.crearPermiso(bajaUsuario,rol);
				}
					//consultas
				if(consultarCliente!=0){
					this.crearPermiso(consultarCliente,rol);
				}if(consultarDatos!=0){
					this.crearPermiso(consultarDatos,rol);
				}if(consultarFactura!=0){
					this.crearPermiso(consultarFactura,rol);
				}if(consultarFirmaElectronica!=0){
					this.crearPermiso(consultarFirmaElectronica,rol);
				}if(consultarInformacion!=0){
					this.crearPermiso(consultarInformacion,rol);
				}if(consultarRol!=0){
					this.crearPermiso(consultarRol,rol);
				}if(consultarProveedor!=0){
					this.crearPermiso(consultarProveedor,rol);
				}if(consultarUsuario!=0){
					this.crearPermiso(consultarUsuario,rol);
				}
					//Otros
				if(crearFactura!=0){
					this.crearPermiso(crearFactura,rol);
				}if(descargarFactura!=0){
					this.crearPermiso(descargarFactura,rol);
				}
					//Editar
				if(editarCliente!=0){
					this.crearPermiso(editarCliente,rol);
				}if(editarProveedor!=0){
					this.crearPermiso(editarProveedor,rol);
				}if(editarRol!=0){
					this.crearPermiso(editarRol,rol);
				}if(editarUsuario!=0){
					this.crearPermiso(editarUsuario,rol);
				}
					//Otros2
				if(eliminarInformacion!=0){
					this.crearPermiso(eliminarInformacion,rol);
				}if(generarFirmaElectronica!=0){
					this.crearPermiso(generarFirmaElectronica,rol);
				}if( publicarInformacion!=0){
					this.crearPermiso(publicarInformacion,rol);
				}
					//listar
				if(listarClientes!=0){
					this.crearPermiso(listarClientes,rol);
				}if(listarProveedores!=0){
					this.crearPermiso(listarProveedores,rol);
				}if( listarRoles!=0){
					this.crearPermiso(listarRoles,rol);
				}if( listarUsuario!=0){
					this.crearPermiso(listarUsuario,rol);
				}
				addFieldError("AltaPermisoOK", "AltaPermisoOK");
				
			}
		}else if(idRol>0){ //Modificación
			Rol rol= rolManager.ObtenerRolByidRol(idRol);
			
			if(nombreRol!=null && nombreRol.trim().length()>0){
				rol.setNombre(nombreRol);
			}if(descripcionRol!=null && descripcionRol.trim().length()>0){
				rol.setDescripcion(descripcionRol);
			}
			
			Rol rolmodificado=rolManager.UpdateRol(rol);
			
			//Eliminación o creación de permisos
			//Altas
			if(this.altaCliente!=0){
				this.crearPermiso(altaCliente, rolmodificado);	
			}if(this.altaCliente==0){
				idpagina=0;
				this.eliminarPermiso(idpagina,rolmodificado);
			}if(this.altaDatos!=0){
				this.crearPermiso(altaDatos, rolmodificado);
			}if(this.altaDatos==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}if(this.altaProveedor!=0){
				this.crearPermiso(altaProveedor, rolmodificado);
			}if(this.altaProveedor==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}if(this.altaRol!=0){
				this.crearPermiso(altaRol, rolmodificado);
			}if(this.altaRol==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}if(this.altaUsuario!=0){
				this.crearPermiso(altaUsuario, rolmodificado);
			}if(this.altaUsuario==0){
				idpagina=0;
				this.crearPermiso(idpagina, rolmodificado);
			}
			
			//bajas
			
			if(this.bajaCliente!=0){
				this.crearPermiso(bajaCliente, rolmodificado);
			}if(this.bajaCliente==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}if(this.bajaProveedor!=0){
				this.crearPermiso(bajaProveedor, rolmodificado);
			}if(this.bajaProveedor==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}if(this.bajaRol!=0){
				this.crearPermiso(bajaRol, rolmodificado);
			}if(this.bajaRol==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}if(this.bajaUsuario!=0){
				this.crearPermiso(bajaUsuario, rolmodificado);
			}if(this.bajaUsuario==0){
				idpagina=0;
				this.eliminarPermiso(idpagina, rolmodificado);
			}
			
			//consulta
			
		if(this.consultarCliente!=0){
			this.crearPermiso(consultarCliente, rolmodificado);
		}if(this.consultarCliente==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarDatos!=0){
			this.crearPermiso(consultarDatos, rolmodificado);
		}if(this.consultarDatos==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarFactura!=0){
			this.crearPermiso(consultarFactura, rolmodificado);
		}if(this.consultarFactura==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarFirmaElectronica!=0){
			this.crearPermiso(consultarFirmaElectronica, rolmodificado);
		}if(this.consultarFirmaElectronica==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarInformacion!=0){
			this.crearPermiso(consultarInformacion, rolmodificado);
		}if(this.consultarInformacion==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarProveedor!=0){
			this.crearPermiso(consultarProveedor, rolmodificado);
		}if(this.consultarProveedor==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarRol!=0){
			this.crearPermiso(consultarRol, rolmodificado);
		}if(this.consultarRol==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.consultarUsuario!=0){
			this.crearPermiso(consultarUsuario, rolmodificado);
		}if(this.consultarUsuario==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}
		
		//Otros
		if(this.crearFactura!=0){
			this.crearPermiso(crearFactura, rolmodificado);
		}if(this.crearFactura==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.descargarFactura!=0){
			this.crearPermiso(descargarFactura, rolmodificado);
		}if(this.descargarFactura==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}
		
		//editar
		if(this.editarCliente!=0){
			this.crearPermiso(editarCliente, rolmodificado);
		}if(this.editarCliente==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.editarProveedor!=0){
			this.crearPermiso(editarProveedor, rolmodificado);
		}if(this.editarProveedor==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.editarRol!=0){
			this.crearPermiso(editarRol, rolmodificado);
		}if(this.editarRol==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.editarUsuario!=0){
			this.crearPermiso(editarUsuario, rolmodificado);
		}if(this.editarUsuario==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}
		//varios
		if(this.eliminarInformacion!=0){
			this.crearPermiso(eliminarInformacion, rolmodificado);
		}if(this.eliminarInformacion==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.generarFirmaElectronica!=0){
			this.crearPermiso(generarFirmaElectronica, rolmodificado);
		}if(this.generarFirmaElectronica==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}	
		
		//listar
		if(this.listarClientes!=0){
			this.crearPermiso(listarClientes, rolmodificado);
		}if(this.listarClientes==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.listarProveedores!=0){
			this.crearPermiso(listarProveedores, rolmodificado);
		}if(this.listarProveedores==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.listarRoles!=0){
			this.crearPermiso(listarRoles, rolmodificado);
		}if(this.listarRoles==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}if(this.listarUsuario!=0){
			this.crearPermiso(listarUsuario, rolmodificado);
		}if(this.listarUsuario==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}
		
		//pulicar
		if(this.publicarInformacion!=0){
			this.crearPermiso(publicarInformacion, rolmodificado);
		}if(this.publicarInformacion==0){
			idpagina=0;
			this.eliminarPermiso(idpagina, rolmodificado);
		}
		
		
		addFieldError("EditarPermisoOK", "EditarPermisoOK");
		return SUCCESSEDITAR;	
			
		}		
		//Obtenemos las paginas para mostrarlas	
			paginas=recursoManager.obtenerPaginas();
			
	} catch (Exception e){
			addFieldError("invalidRolAlta",getText("rol.error"));
			return ERROR;
	}
	
		
		this.setPaginas(paginas);
		addActionMessage("Se ha creado el Rol correctamente");	
	return SUCCESS;
}

	private void eliminarPermiso(int idpag, Rol rol) {
		Permiso permiso = null;
		Recurso pagina = null;
		List lista = null;
		try {
			pagina = recursoManager.obtenerPaginaById(idpag);
			// comprobamos si hay un permiso con esa pág para este rol
			lista = permisoManager.buscarPermisoConPagRol(pagina, rol);
			// Comprobamos si la lista no es vacía es que existe y debemos
			// eleminarlo
			if (lista.size() != 0) {
				permiso = (Permiso) lista.get(0);
				permisoManager.bajaPermiso(permiso);
			}
		} catch (Exception e) {
			addFieldError("eliminarPermiso", getText("permiso.eliminar"));
		}
	}

	// Método que permite crear el permiso
	public void crearPermiso(int seleccion, Rol rol) {
		Permiso permiso = new Permiso();
		List permisos = null;
		try {
			// obtenemos la pág seleccionada en el combox
			Recurso pagina = recursoManager.obtenerPaginaById(new Integer(
					seleccion));
			// creamos un permiso con esa pag y el rol
			// comprobamos si existia o no anteriormente

			permisos = permisoManager.buscarPermisoConPagRol(pagina, rol);
			if (permisos.size() == 0) {
				permiso.setRecurso(pagina);
				permiso.setRol(rol);
				Map<Recurso, Rol> mapa = new HashMap<Recurso, Rol>();
				mapa.put(pagina, rol);
				permiso.setPermisos(mapa);
				permisoManager.altaPermiso(permiso);
			}
		} catch (Exception e) {
			addFieldError("InvalidPermiso", getText("permiso.Invalid"));

		}
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
