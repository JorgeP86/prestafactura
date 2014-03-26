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
	
	public Usuario getUsuario(Usuario user){
		//UsuarioRepository m = ctx.getBean(UsuarioRepository.class);
		//return m.findOne(user.getID());
		return new Usuario();//usuarioRepository.findOne(user.getID());	
	}
	
	public List<Usuario> obtenerUsuarios(){
		return usuarioRepository.findAll();
	}
}
