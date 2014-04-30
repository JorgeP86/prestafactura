package com.prestafacturaService.mongo.manager;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.repositories.UsuarioRepository;


@Service
public class UsuarioManager {
	
	//private static ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario saveUsuario(Usuario user){
		return usuarioRepository.save(user);
	}

	public Usuario getUsuario(String nombre, String password){
		return usuarioRepository.getUsuario(nombre, password);
		 //usuarioRepository.findOne(user.getID());	
	}
	
	public List<Usuario> obtenerUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Boolean existeUsuario(String nombre, String password){
		return usuarioRepository.existsUsuario(nombre, password);
	}

	public List<Usuario> usuariosConRol(Rol rol) {
		// TODO Auto-generated method stub
		return usuarioRepository.usuariosConRol(rol);
	}

	public boolean existeNombreUsuario(String nombre) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsNombreUsuario(nombre);
	}

	public Usuario obtenerUsuarioByid(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.obtenerUsuarioByid(idUsuario);
	}

	public Usuario updateUsuario(Usuario usuarioUpdate) {
		// TODO Auto-generated method stub
		return usuarioRepository.updateUsuario(usuarioUpdate);
	}

	public Collection<Usuario> busquedaUsuario(String nombreBus, String apellido1Bus,
			String apellido2Bus, String departamentoBus, Rol rol) {
		// TODO Auto-generated method stub
		return usuarioRepository.busquedaUsuario(nombreBus, apellido1Bus,apellido2Bus,
				departamentoBus, rol);
	}

	public void eliminarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		usuarioRepository.eliminarUsuario(idUsuario);
	}
}
