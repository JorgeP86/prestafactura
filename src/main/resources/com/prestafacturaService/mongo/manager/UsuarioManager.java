package com.prestafacturaService.mongo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
