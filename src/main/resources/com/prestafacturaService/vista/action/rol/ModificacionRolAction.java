package com.prestafacturaService.vista.action.rol;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class ModificacionRolAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 909700589759645941L;
	
	private static final Logger logger = Logger.getLogger(ModificacionRolAction.class);

	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	private String nombreRolSelect;
	
	@Autowired
	private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;
	
	public String execute(){
		try{
			Rol rol=rolManager.ObtenerRolByName(nombreRolSelect);
			logger.info("Obtener rol por Nombre");

			//Comprobamos que no existe al menos un usuario asignado a ese rol
    		//pues si existe no daremos posibilidad de eliminarlo ante de quitar
    		//la relación
			List<Usuario> usuarios = usuarioManager.usuariosConRol(rol);
			logger.info("Obtener usuarios por rol");
			System.out.println(usuarios.get(0).getNombre());
			if(usuarios.size()!=0){
				addActionError("No se puede eliminar ese Rol porque tiene al menos un Usuario asociado.");
				return ERROR;
			}else{
				rolManager.bajaRol(rol);
				logger.info("Borrado el rol");
				addActionError("Operación de borrar correcta");
			}

		} catch (Exception e) {
			addActionError("Fallo al eliminar el Rol");
			return ERROR;
		}
		
		return SUCCESS;
	}

	public String getNombreRolSelect() {
		return nombreRolSelect;
	}


	public void setNombreRolSelect(String nombreRolSelect) {
		this.nombreRolSelect = nombreRolSelect;
	}

	public RolManager getRolManager() {
		return rolManager;
	}

	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}

	public UsuarioManager getUsuarioManager() {
		return usuarioManager;
	}

	public void setUsuarioManager(UsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}

	
}
