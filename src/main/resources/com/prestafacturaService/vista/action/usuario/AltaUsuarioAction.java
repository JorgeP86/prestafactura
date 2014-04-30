package com.prestafacturaService.vista.action.usuario;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class AltaUsuarioAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2284495396765182580L;
	private static final Logger logger = Logger.getLogger(AltaUsuarioAction.class);
	
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	public static final String SUCCESSB = "successB";
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String login;
	private String password;
	private String email;
	private String departamento;
    private String nombreRol;
    
    private Usuario usuarioCreado;
    private Usuario usuarioModificado;
    private Integer idUsuario;

	@Autowired
    private RolManager rolManager;
	@Autowired
	private UsuarioManager usuarioManager;
    
    
	public String execute(){
		clearFieldErrors();
	try{
		
		if(idUsuario==0){ //Alta
			//Comprobamos que no existe el Usuario con el mismo password y login
			logger.info("Comenzando alta, comprueba si existe el usuario para crearlo");
			if(usuarioManager.existeUsuario(login, password)
					|| usuarioManager.existeNombreUsuario(login)){
				Rol rolUsuario=rolManager.ObtenerRolByName(nombreRol);
				Usuario usuarioNuevo=new Usuario();
				usuarioNuevo.setIdUsuario(new Integer(UUID.randomUUID().toString()));
				usuarioNuevo.setNombre(nombre);
				usuarioNuevo.setApellido1(apellido1);
				usuarioNuevo.setApellido2(apellido2);
				usuarioNuevo.setDepartamento(departamento);
				usuarioNuevo.setEmail(email);
				usuarioNuevo.setLogin(login);
				usuarioNuevo.setPassword(password);
				usuarioNuevo.setRol(rolUsuario);
				usuarioNuevo.setFechaAlta(new Date());
		
				Usuario usuarioCreado=usuarioManager.saveUsuario(usuarioNuevo);
				 logger.info("Creado el usuario Nuevo");
				this.setUsuarioCreado(usuarioCreado);
				return SUCCESS;
		
			}else{
				addActionError("El usuario ya existe");
				return INPUT;
			}
			
		}if(idUsuario>0){ //Modificación
			logger.info("Comienza operacion modificar");
			if(usuarioManager.existeUsuario(login, password)
					|| usuarioManager.existeNombreUsuario(login)){
				Usuario usuario=usuarioManager.obtenerUsuarioByid(idUsuario);
				Rol rolUsuario=rolManager.ObtenerRolByName(nombreRol);
				Usuario usuarioUpdate=new Usuario();
				usuarioUpdate.setIdUsuario(idUsuario);
				usuarioUpdate.setNombre(nombre);
				usuarioUpdate.setApellido1(apellido1);
				usuarioUpdate.setApellido2(apellido2);
				usuarioUpdate.setDepartamento(departamento);
				usuarioUpdate.setEmail(email);
				usuarioUpdate.setLogin(login);
				usuarioUpdate.setPassword(password);
				usuarioUpdate.setRol(rolUsuario);
				usuarioUpdate.setFechaAlta(new Date());
				
				Usuario usuarioModificado=usuarioManager.updateUsuario(usuarioUpdate);
				logger.info("Usuario modificado");
				this.setUsuarioModificado(usuarioModificado);
				return SUCCESS;
				
				
				
			}else{
				addActionError("El usuario ya existe");
				return INPUT;
			}
			
		}
		
		} catch (Exception e){
			addFieldError("invalidUsuarioAlta","El usuario no se ha creado correctamente");
			return INPUT;
		}
	addActionError("Continuar");
	return SUCCESSB;
	
}
	
	
	 public void validate() {
		 if(nombre==null || nombre.trim().equals("")){
			 addFieldError("nombreUsuarioAlta",getText("nombreUsuarioAlta.Invalid"));
		 } 
		 if(apellido1==null || apellido1.trim().equals("")){
			 addFieldError("apellido1UsuarioAlta",getText("apellido1UsuarioAlta.Invalid"));
		 } 
		 if(apellido2==null || apellido2.trim().equals("")){
			 addFieldError("apellido2UsuarioAlta",getText("apellido2UsuarioAlta.Invalid"));
		 } 
		 if(login==null || login.trim().equals("")){
			 addFieldError("loginUsuarioAlta",getText("loginUsuarioAlta.Invalid"));
		 }
		 if(password==null || password.trim().equals("")){
			 addFieldError("passwordUsuarioAlta",getText("passwordUsuarioAlta.Invalid"));
		 } 
		 if(email==null || email.trim().equals("")){
			 addFieldError("emailUsuarioAlta",getText("emailUsuarioAlta.Invalid"));
		 }
		 if(departamento==null || departamento.trim().equals("")){
			 addFieldError("departamentoUsuarioAlta",getText("departamentoUsuarioAlta.Invalid"));
		 } 
		 if(nombreRol==null || nombreRol.trim().equals("")){
			 addFieldError("(nombreRolUsuarioAlta",getText("nombreRolUsuarioAlta.Invalid"));
		 }
		 
	 }
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


	public Usuario getUsuarioCreado() {
		return usuarioCreado;
	}


	public void setUsuarioCreado(Usuario usuarioCreado) {
		this.usuarioCreado = usuarioCreado;
	}


	public Usuario getUsuarioModificado() {
		return usuarioModificado;
	}


	public void setUsuarioModificado(Usuario usuarioModificado) {
		this.usuarioModificado = usuarioModificado;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	


	
	
	

}
