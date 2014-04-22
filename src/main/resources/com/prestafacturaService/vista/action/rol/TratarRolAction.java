package com.prestafacturaService.vista.action.rol;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.PermisoManager;
import com.prestafacturaService.mongo.manager.RecursoManager;
import com.prestafacturaService.mongo.manager.RolManager;



public class TratarRolAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = -1843765847169709920L;

	
	private HttpServletRequest servletRequest;
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	public static final String SUCCESSEDITAR = "successEditar";
	

	@Autowired
	private RolManager rolManager;
	@Autowired
	private RecursoManager recursoManager;
	@Autowired
	private PermisoManager permisoManager;
	
	public String execute(){
	 	
    	boolean es=false;
    	Collection result=null;
    	

		try{
			//Rescatamos las páginas que determinan los permisos existentes
			Collection paginas=recursoManager.obtenerPaginas();
			//Definimos si se ha elegido alta o modificacion
			int idRol=(Integer) servletRequest.getAttribute("idRol");
			if(idRol> 0){
				//ObtenerRol
				Rol rol=rolManager.ObtenerRolByidRol(idRol);
				//obtenemos los permisos
				Collection permisos=permisoManager.ObtenerPermisosRol(rol);
				//Marcamos las paginas activas
				Iterator it=permisos.iterator();
	    		while(it.hasNext()){
	    			es=false;
	    			Permiso permiso= (Permiso)it.next();
	    			Iterator itt=result.iterator();
		    			while(itt.hasNext() && !es){
		    				Recurso pag=(Recurso) itt.next();
		    				if(pag.getIdpagina()==permiso.getRecurso().getIdpagina()){
				    			result.remove(pag);
				    			pag.setEnc(true);
		    					result.add(pag);
					    		es=true;
		    				}
		    			}
	    		}
	    		servletRequest.setAttribute("rol", rol);
	    		servletRequest.setAttribute("permisos", permisos);
	    		return SUCCESSEDITAR;
			}
			servletRequest.setAttribute("paginas", result);
			
		} catch (Exception e) {
			addActionError("Fallo al eliminar el Rol");
			return ERROR;
		}
		return SUCCESS;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public RolManager getRolManager() {
		return rolManager;
	}

	public void setRolManager(RolManager rolManager) {
		this.rolManager = rolManager;
	}

	public RecursoManager getRecursoManager() {
		return recursoManager;
	}

	public void setRecursoManager(RecursoManager recursoManager) {
		this.recursoManager = recursoManager;
	}

	public PermisoManager getPermisoManager() {
		return permisoManager;
	}

	public void setPermisoManager(PermisoManager permisoManager) {
		this.permisoManager = permisoManager;
	}

	
	
	
	
}
