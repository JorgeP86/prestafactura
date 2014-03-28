package com.prestafacturaService.vista.action.usuario;

import java.util.Collection;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class AccesoUsuarioAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2284495396765182580L;
	private UsuarioManager usuarioManager;
	private RolManager rolManager;
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	public String execute (){

		Collection<Usuario> resultado = usuarioManager.obtenerUsuarios();
		Collection<Rol> roles=rolManager.ObtenerRoles();
		
		ActionContext.getContext().getSession().put("roles", roles);

		return SUCCESS;
	}

	public void setUsuarioManager(UsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}

	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}
	
	
	
	

}
