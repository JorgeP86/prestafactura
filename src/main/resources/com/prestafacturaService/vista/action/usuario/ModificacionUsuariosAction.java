package com.prestafacturaService.vista.action.usuario;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class ModificacionUsuariosAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4644318210726965409L;

	private static final Logger logger = Logger.getLogger(ModificacionUsuariosAction.class);
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	@Autowired
	private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;

	private Integer idUsuario;
	private Collection<Usuario> usuariosTrasBorrar;

	public String execute() {

		try {
			
			usuarioManager.eliminarUsuario(idUsuario);
			logger.info("eliminacion usuario por id");
			addActionMessage("El usuario de ha eliminado correctamente");

			// obtenemos la lista de usuarios ya actualizados
			Collection<Usuario> usuariostrasborrar = usuarioManager.obtenerUsuarios();
			this.setUsuariosTrasBorrar(usuariostrasborrar);
			logger.info("obtener la lista actualizada despues de borrar un usuario");
			
		} catch (Exception e) {
			addActionError("La eliminación del usuario ha fallado");
			return INPUT;
		}
		return SUCCESS;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Collection<Usuario> getUsuariosTrasBorrar() {
		return usuariosTrasBorrar;
	}

	public void setUsuariosTrasBorrar(Collection<Usuario> usuariosTrasBorrar) {
		this.usuariosTrasBorrar = usuariosTrasBorrar;
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
