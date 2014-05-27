package com.prestafacturaService.vista.action.usuario;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class AccesoUsuarioAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -548536444855489980L;

	private static final Logger logger = Logger.getLogger(AccesoUsuarioAction.class);
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";

	@Autowired
	private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;

	private Collection<Usuario> usuariosAcceso;
	private Collection<Rol> rolesAcceso;

	public String execute() {
		clearFieldErrors();

		try {
			Collection<Usuario> usuarios = usuarioManager.obtenerUsuarios();
			Collection<Rol> roles = rolManager.ObtenerRoles();
			logger.info("Se obtiene los usuarios y roles de base de datos");
			this.setRolesAcceso(roles);
			this.setUsuariosAcceso(usuarios);

		} catch (Exception e) {
			addActionError("Fallo al realizar la busqueda de los usuarios");
			return ERROR;
		}
		return SUCCESS;

	}

	public Collection<Usuario> getUsuariosAcceso() {
		return usuariosAcceso;
	}

	public void setUsuariosAcceso(Collection<Usuario> usuariosAcceso) {
		this.usuariosAcceso = usuariosAcceso;
	}

	public Collection<Rol> getRolesAcceso() {
		return rolesAcceso;
	}

	public void setRolesAcceso(Collection<Rol> rolesAcceso) {
		this.rolesAcceso = rolesAcceso;
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
