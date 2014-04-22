package com.prestafacturaService.mongo.repositories.propios;

import java.util.List;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;


public interface UsuarioRepositoryCustom{

	Usuario getUsuario(String username, String password);
	Boolean existsUsuario(String username, String password);
	List usuariosConRol(Rol rol);
}
