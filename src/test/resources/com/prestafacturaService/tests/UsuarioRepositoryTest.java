package com.prestafacturaService.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.PermisoManager;
import com.prestafacturaService.mongo.manager.RecursoManager;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml","Test-applicationContext.xml"})
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioManager usuarioManager;
	@Autowired
	private RolManager rolManager;
	@Autowired
	private PermisoManager permisoManager;
	@Autowired
	private RecursoManager recursoManager;
	@Autowired
	private MongoTemplate template;
	
	@Before
	public void setUp(){
		
		template.dropCollection("permiso");
		template.createCollection("permiso");
		template.dropCollection("rol");
		template.createCollection("rol");
		template.dropCollection("usuario");
		template.createCollection("usuario"); 
		
		Recurso recurso = new Recurso();
		
		recurso = recursoManager.obtenerPaginaBypath("altaUsuario");

		Rol rol = new Rol();
		rol.setNombre("Administrador");
		rol.setDescripcion("descripcion");
		rolManager.saveRol(rol);
		
		Permiso permiso = new Permiso();
		permiso.setRecurso(recurso);
		permiso.setRol(rol);
		permisoManager.savePermiso(permiso);
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Jorge");
		usuario.setEmail("jorge@gmail.com");
		usuario.setPassword("jorge");
		usuario.setApellido1("Pareja");
		usuario.setApellido2("Parra");
		usuario.setDepartamento("departamento");
		usuario.setFechaAlta(new Date());
		usuario.setLogin("JorgeP86");
		usuario.setRol(rol);
		
		usuarioManager.saveUsuario(usuario);
	}
	
	@Test
	public void testUsuario() {		
		List<Usuario> usuarios = usuarioManager.obtenerUsuarios();
		Usuario usuario = usuarios.get(0);
		assertUsuario(usuarios, usuario.getNombre());
		System.out.println(usuario.toString());
	}
	
	@Test
	public void testGetUsuario(){
		String nombre = "JorgeP86";
		String password = "jorge";
		Usuario usuario = usuarioManager.getUsuario(nombre, password);
		assertNotNull(usuario);
	}
	
	@After
	public void tearDown(){
	}
	
	private static void assertUsuario(List<Usuario> usuarios, String nombre){
		assertNotNull(usuarios);
		assertEquals("Mistmatch usuario nombre", nombre, usuarios.get(0).getNombre());
	}
}
