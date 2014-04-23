package com.prestafacturaService.vista.action.usuario;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class TratarUsuariosAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1427604303248130420L;

	
private HttpServletRequest servletRequest;
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	@Autowired
	private UsuarioManager usuarioManager;
	
	private int idUsuario;
	
	public String execute(){
		
		try{
			//Definimos si se ha elegido alta o modificacion
			servletRequest.setAttribute("idUsuario", idUsuario);
			
			if(idUsuario>0){
				Usuario usuario= usuarioManager.obtenerUsuarioByid(idUsuario);
				servletRequest.setAttribute("UsuarioModificacion", usuario);
			}
			
			
		}catch(Exception e){
			addActionError("Fallo al tratar el Usuario");
			return ERROR;
		}
		return SUCCESS;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
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
