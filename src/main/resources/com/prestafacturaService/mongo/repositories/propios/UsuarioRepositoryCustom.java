package com.prestafacturaService.mongo.repositories.propios;

import java.util.Collection;
import java.util.List;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;


public interface UsuarioRepositoryCustom{

	Usuario getUsuario(String username, String password);
	Boolean existsUsuario(String username, String password);
	List usuariosConRol(Rol rol);
	Boolean existsNombreUsuario(String nombre);
	Usuario obtenerUsuarioByid(int idUsuario);
	Usuario updateUsuario(Usuario usuarioUpdate);
	Collection busquedaUsuario(String nombreBus, String apellido1Bus,String apellido2Bus,String departamentoBus, Rol rol);
	void eliminarUsuario(int idUsuario);
}
