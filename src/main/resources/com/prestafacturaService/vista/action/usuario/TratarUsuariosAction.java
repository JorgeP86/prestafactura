package com.prestafacturaService.vista.action.usuario;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class TratarUsuariosAction extends ActionSupport {

	private static final long serialVersionUID = 1427604303248130420L;

	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	@Autowired
	private UsuarioManager usuarioManager;

	private Integer idUsuario;
	private Usuario usuarioModificacion;

	public String execute() {

		try {
			// Definimos si se ha elegido alta o modificacion

			if (idUsuario > 0) {
				Usuario usuario = usuarioManager.obtenerUsuarioByid(idUsuario);
				this.setUsuarioModificacion(usuario);
			}

		} catch (Exception e) {
			addActionError("Fallo al tratar el Usuario");
			return ERROR;
		}
		return SUCCESS;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
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
