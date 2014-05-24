package com.prestafacturaService.vista.action.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.manager.PermisoManager;
import com.prestafacturaService.mongo.manager.RolManager;
import com.prestafacturaService.mongo.manager.UsuarioManager;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	
	private static final long serialVersionUID = -2596761911912878030L;
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	private static final String SuccessU = "successU";
	private static final String SuccessA = "successA";
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	
    @Autowired
    private UsuarioManager usuarioManager;
    @Autowired
	private PermisoManager permisoManager;
    @Autowired
	private RolManager rolManager;
	
	List<Permiso> perm = new ArrayList<Permiso>();
    Map<String, String> p=new HashMap<String, String>();
    private Rol rol;
    boolean gUsuarios=false,gFactura=false,gRoles=false,gProveedores=false,gDatosInternos=false,gClientes=false, gFirmaElectronica=false,gInformacion=false, gFacturasAlmacenadas=false;

	private HttpServletRequest servletRequest;
	private String username;
	private String password;


	private Boolean validUser(String nameUser, String passUser){
		logger.info("Operacion validar user");

		Boolean existeUsuario=usuarioManager.existeUsuario(nameUser, passUser);
		if(existeUsuario){
			Usuario user= usuarioManager.getUsuario(nameUser, passUser);
			if(user.getLogin().equals(nameUser)&& user.getPassword().equals(passUser)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public String execute(){
		clearFieldErrors();
		
		if(username!=null && password!=null && validUser(username,password)){
			logger.info("Realizada validacion user");

			Usuario u = usuarioManager.getUsuario(username,password);
			servletRequest.getSession().setAttribute("usuario", u);
			logger.info("Guardado el usuario en session");

			rol = u.getRol();
			perm=permisoManager.ObtenerPermisosByRol(rol);
			logger.info("Obtener los permisos del rol");

			Iterator<Permiso> it = perm.iterator();
	       	while(it.hasNext()){
	       		Permiso permiso=(Permiso) it.next();
	   	         
	   	         //Modulo Usuario
	   	         if(permiso.getRecurso().getPath().equals("altaUsuario")){
	   	        	 p.put("altaUsuario", "altaUsuario");
	   	        	 gUsuarios=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("bajaUsuario")){
	   	        	 p.put("bajaUsuario", "bajaUsuario");
	   	        	 gUsuarios=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("editarUsuario")){
	   	        	 p.put("editarUsuario", "editarUsuario");
	   	        	 gUsuarios=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("bajaUsuario")){
	   	        	 p.put("consultarUsuario", "consultarUsuario");
	   	        	 gUsuarios=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("listarUsuario")){
	   	        	 p.put("listarUsuario", "listarUsuarios");
	   	        	 gUsuarios=true;
	   	         }
	   	         
	   	         //M�dulo Roles
	   	         if(permiso.getRecurso().getPath().equals("altaRol")){
	   	        	 p.put("altaRol","altaRol");
	   	        	 gRoles=true;
	   	         } if(permiso.getRecurso().getPath().equals("bajaRol")){
	   	        	 p.put("bajaRol","bajaRol");
	   	        	 gRoles=true;
	   	         } if(permiso.getRecurso().getPath().equals("consultarRol")){
	   	        	 p.put("consultarRol","consultarRol");
	   	        	 gRoles=true;
	   	         } if(permiso.getRecurso().getPath().equals("editarRol")){
	   	        	 p.put("editarRol","editarRol");
	   	        	 gRoles=true;
	   	         } if(permiso.getRecurso().getPath().equals("listarRoles")){
	   	        	 p.put("listarRol","listarRol");
	   	        	 gRoles=true;
	   	         }
	   	         
	   	         //M�dulo Clientes
	   	         if(permiso.getRecurso().getPath().equals("altaCliente")){
	   	        	 p.put("altaCliente", "altaCliente");
	   	        	 gClientes=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("bajaClientes")){
	   	        	 p.put("bajaCliente", "bajaCliente");
	   	        	 gClientes=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("consultarClientes")){
	   	        	 p.put("consultarCliente", "consultarCliente");
	   	        	 gClientes=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("editarClientes")){
	   	        	 p.put("editarCliente", "editarCliente");
	   	        	 gClientes=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("listarClientes")){
	   	        	 p.put("listarCliente", "listarCliente");
	   	        	 gClientes=true;
	   	         }
	   	         
	   	         //M�dulo Proveedores
	   	         if(permiso.getRecurso().getPath().equals("altaProveedor")){
	   	        	 p.put("altaProveedores", "altaProveedores");
	   	        	 gProveedores=true;
	   	      	   }
	   	         if(permiso.getRecurso().getPath().equals("bajaProveedor")){
	   	        	 p.put("bajaProveedores", "bajaProveedores");
	   	        	 gProveedores=true;
	   	      	   }
	   	         if(permiso.getRecurso().getPath().equals("editarProveedor")){
	   	        	 p.put("editaProveedores", "editarProveedores");
	   	        	 gProveedores=true;
	   	      	   }
	   	         if(permiso.getRecurso().getPath().equals("consultarProveedor")){
	   	        	 p.put("consultarProveedores", "consultarProveedores");
	   	        	 gProveedores=true;
	   	      	   }
	   	         if(permiso.getRecurso().getPath().equals("listarProveedores")){
	   	        	 p.put("listarProveedores", "listarProveedores");
	   	        	 gProveedores=true;
	   	      	   }
	   	         
	   	         //M�dulo Factura
	   	         
	   	         if(permiso.getRecurso().getPath().equals("crearFactura")){
	   	        	 p.put("crearFactura", "crearFactura");
	   	        	 gFactura=true;
	   	         }
	       	
	   	         //M�dulo Datos Internos
	   	         if(permiso.getRecurso().getPath().equals("altaDatos")){
	   	        	 p.put("altaDatos", "altaDatos");
	   	        	 gDatosInternos=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("editarDatos")){
	   	        	 p.put("editarDatos", "editarDatos");
	   	        	 gDatosInternos=true;
	   	        }
	   	         if(permiso.getRecurso().getPath().equals("consultarDatos")){
	   	        	 p.put("consultarDatos", "consultarDatos");
	   	        	 gDatosInternos=true;
	   	         }
	   	         
	   	         //M�dulo Informaci�n
	   	         if(permiso.getRecurso().getPath().equals("consultarInformacion")){
	   	        	 p.put("consultarInformacion", "consultarInformacion");
	   	        	 gInformacion=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("eliminarInformacion")){
	   	        	 p.put("eliminarInformacion", "eliminarInformacion");
	   	        	 gInformacion=true;
		    	     }
	   	         if(permiso.getRecurso().getPath().equals("publicarInformacion")){
	   	        	 p.put("publicarInformacion", "publicarInformacion");
	   	        	 gInformacion=true;
		    	     }
	   	         //Modulo Factura Almacenadas
	   	         if(permiso.getRecurso().getPath().equals("consultarFactura")){
	   	        	 p.put("consultarFactura","consultarFactura");
	   	        	 gFacturasAlmacenadas=true;
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("descargarFactura")){
	   	        	 p.put("descargarFactura","descargarFactura");
	   	        	 gFacturasAlmacenadas=true;
	   	         }
	   	         //Firma Electronica
	   	         if(permiso.getRecurso().getPath().equals("generarFirmaElectronica")){
	   	        	 p.put("generarFirmaElectronica", "generarFirmaElectronica");
	   	        	 gFirmaElectronica=true;
	   	        	    	        	 
	   	         }
	   	         if(permiso.getRecurso().getPath().equals("consultarFirmaElectronica")){
	   	        	 p.put("consultarFirmaElectronica", "consultarFirmaElectronica");
	   	        	 gFirmaElectronica=true;
	   	         }
	   	         
	   	       
	   	         
	      	 }
	       	 
	       	servletRequest.getSession().setAttribute("permisos", p);
			logger.info("Guardado los permisos del rol en session");

	       	if((gClientes || gDatosInternos || gFactura || gFacturasAlmacenadas || 
	       			gFirmaElectronica || gInformacion || gProveedores )&& (!gUsuarios && !gRoles)){
				return SuccessU;
	       	}if(gUsuarios || gRoles){
				return SuccessA;
	       	}
		}else{
			addFieldError("invalid","Usuario o Password incorrecto");
		}
		return INPUT;
	}
	
	
	
	 public void validate() {
		 if(username==null || username.trim().equals("")){
			 addFieldError("userNameVacio",getText("username.Invalid"));
		 }
		 if(password==null || password.trim().equals("")){
			 addFieldError("passwordVacio",getText("password.Invalid"));
		 }
		 
	 }

	
	
	public void setPermisoManager(PermisoManager permisoManager) {
		this.permisoManager = permisoManager;
	}
	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}


	

	

}