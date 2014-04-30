package com.prestafacturaService.mongo.repositories.propios;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;


public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Usuario getUsuario(String username, String password){
		Query query = new Query();
	    query.addCriteria(Criteria.where("login").is(username).and("password").is(password));
		
		return mongoTemplate.findOne(query,Usuario.class);
	}
	
	public Boolean existsUsuario(String username, String password){
		Query query= new Query();
		query.addCriteria(Criteria.where("login").is(username).and("password").is(password));
		
		return mongoTemplate.exists(query, Usuario.class);
		
	}

	public List<Usuario> usuariosConRol(Rol rol) {
		Query query= new Query();
		query.addCriteria(Criteria.where("rol").is(rol));
		return mongoTemplate.find(query, Usuario.class);

	}

	public Boolean existsNombreUsuario(String nombre) {
		Query query= new Query();
		query.addCriteria(Criteria.where("login").is(nombre));
		
		return mongoTemplate.exists(query, Usuario.class);
	}

	public Usuario obtenerUsuarioByid(int idUsuario) {
		Query query= new Query();
		query.addCriteria(Criteria.where("idUsuario").is(idUsuario));
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(query, Usuario.class);
	}

	public Usuario updateUsuario(Usuario usuarioUpdate) {
		Query query= new Query();
		query.addCriteria(Criteria.where("idUsuario").is(usuarioUpdate.getIdUsuario()));
		Update update= new Update();
		update.push("nombre", usuarioUpdate.getNombre());
		update.push("apellido1", usuarioUpdate.getApellido1());
		update.push("apellido2", usuarioUpdate.getApellido2());
		update.push("departamento", usuarioUpdate.getDepartamento());
		update.push("email", usuarioUpdate.getEmail());
		update.push("login", usuarioUpdate.getLogin());
		update.push("password", usuarioUpdate.getPassword());
		update.push("rol", usuarioUpdate.getRol());
		update.push("fechaAlta", usuarioUpdate.getFechaAlta());
		
		
		return mongoTemplate.findAndModify(query, update, Usuario.class);
	}
	public Collection<Usuario> busquedaUsuario(String nombreBus, String apellido1Bus,String apellido2Bus,String departamentoBus, Rol rol){
			Query query= new Query();
	query.addCriteria(Criteria.where("nombre").is(nombreBus).and("apellido1").is(apellido1Bus)
			.and("apellido2").is(apellido2Bus).and("departamento").is(departamentoBus).and("rol").is(rol));	
			
		return mongoTemplate.find(query, Usuario.class);
	}

	public void eliminarUsuario(int idUsuario) {
		Usuario user=this.obtenerUsuarioByid(idUsuario);
		mongoTemplate.remove(user);
		
	}
	
}
