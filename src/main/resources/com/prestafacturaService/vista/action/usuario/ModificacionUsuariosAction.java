package com.prestafacturaService.vista.action.usuario;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class ModificacionUsuariosAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4644318210726965409L;

private HttpServletRequest servletRequest;
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
    private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;
	
	private int idUsuario= (Integer) servletRequest.getAttribute("idUsuario");
	
	
	public String execute(){
		
		try{
			
			usuarioManager.eliminarUsuario(idUsuario);
			addActionMessage("El usuario de ha eliminado correctamente");
			
			//obtenemos la lista de usuarios ya actualizados
			Collection usuariostrasborrar=usuarioManager.obtenerUsuarios();
			servletRequest.setAttribute("usuariostrasborrar", usuariostrasborrar);
			
			
		}catch(Exception e){
			addActionError("La eliminación del usuario ha fallado");
			return INPUT;
		}
		return SUCCESS;
	}


	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}


	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
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
