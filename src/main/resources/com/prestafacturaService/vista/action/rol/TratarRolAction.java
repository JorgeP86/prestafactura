package com.prestafacturaService.vista.action.rol;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Permiso;
import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.manager.PermisoManager;
import com.prestafacturaService.mongo.manager.RecursoManager;
import com.prestafacturaService.mongo.manager.RolManager;



public class TratarRolAction extends ActionSupport {

	private static final long serialVersionUID = -1843765847169709920L;
	
	private static final Logger logger = Logger.getLogger(TratarRolAction.class);

	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	public static final String SUCCESSEDITAR = "successEditar";
	

	@Autowired
	private RolManager rolManager;
	@Autowired
	private RecursoManager recursoManager;
	@Autowired
	private PermisoManager permisoManager;
	
	private Integer idRol;
	private Rol rolTratar;
	private Collection<Permiso> permisoTratar;
	private Collection<Recurso> resultTratar;
	
	
	public String execute(){
	 	
    	boolean es=false;
    	
    	

		try{
			//Rescatamos las páginas que determinan los permisos existentes
			resultTratar=recursoManager.obtenerPaginas();
			
			 logger.info("Obtener paginas");

			//Definimos si se ha elegido alta o modificacion
			
			if(idRol> 0){
				//ObtenerRol
				Rol rol=rolManager.ObtenerRolByidRol(idRol);
				 logger.info("Obtener rol");
				 
				//obtenemos los permisos
				Collection permisos=permisoManager.ObtenerPermisosRol(rol);
				 logger.info("Obtener los permisos");

				//Marcamos las paginas activas
				Iterator it=permisos.iterator();
	    		while(it.hasNext()){
	    			es=false;
	    			Permiso permiso= (Permiso)it.next();
	    			Iterator itt=resultTratar.iterator();
		    			while(itt.hasNext() && !es){
		    				Recurso pag=(Recurso) itt.next();
		    				if(pag.getIdpagina()==permiso.getRecurso().getIdpagina()){
		    					resultTratar.remove(pag);
				    			pag.setEnc(true);
				    			resultTratar.add(pag);
					    		es=true;
		    				}
		    			}
	    		}
	    		logger.info("Marcamos las paginas activas");
	    		this.setPermisoTratar(permisos);
	    		this.setRolTratar(rol);
	    		logger.info("devolvemos los permisos y rol");
	    	
	    		return SUCCESSEDITAR;
			}
			this.setResultTratar(resultTratar);
			 logger.info("Resultados los permisos");

			
		} catch (Exception e) {
			addActionError("Fallo al eliminar el Rol");
			return ERROR;
		}
		return SUCCESS;
	}

	

	public Collection<Recurso> getResultTratar() {
		return resultTratar;
	}



	public void setResultTratar(Collection<Recurso> resultTratar) {
		this.resultTratar = resultTratar;
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



	public Integer getIdRol() {
		return idRol;
	}



	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}



	public Rol getRolTratar() {
		return rolTratar;
	}



	public void setRolTratar(Rol rolTratar) {
		this.rolTratar = rolTratar;
	}



	public Collection<Permiso> getPermisoTratar() {
		return permisoTratar;
	}



	public void setPermisoTratar(Collection<Permiso> permisoTratar) {
		this.permisoTratar = permisoTratar;
	}

	
	
	
	
}
