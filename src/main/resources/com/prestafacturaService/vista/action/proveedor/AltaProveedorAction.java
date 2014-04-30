package com.prestafacturaService.vista.action.proveedor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.DetallesContacto;
import com.prestafacturaService.mongo.dto.Direccion;
import com.prestafacturaService.mongo.dto.EntidadLegal;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.manager.ProveedorManager;

public class AltaProveedorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AltaProveedorAction.class);

	@Autowired
	private ProveedorManager proveedorManager;
	
	
	private static final String ERROR = "error";
	private static final String SUCCESS = "success";
	
	private Integer idProveedor;
	
	private IdentificacionFiscal idFiscal;
	private String idDeFigura;
	private String nombre;
	private String apellido2;
	private String apellido1;
	private EntidadLegal entidadLegal;
	private DetallesContacto detallesContacto;
	private Direccion direccion;
	
	private Proveedor resProveedor;
	private Proveedor proveedorModificado;
	
	
	
	public String execute(){
		clearFieldErrors();
		try{
			if(idProveedor==0){  //ALTA
				logger.info("Comienza operacion alta Proveedor");
				
				if(proveedorManager.existProveedor(idFiscal)){
					logger.info("Comprobacion usuario no repetido");
					
					Proveedor proveedorNuevo=new Proveedor();
					if(this.nombre!=null || this.nombre.trim().equals("")){
						proveedorNuevo.setNombre(nombre);
						proveedorNuevo.setApellido1(apellido1);
						proveedorNuevo.setApellido2(apellido2);
						proveedorNuevo.setDireccion(direccion);
						proveedorNuevo.setIdentificacionFiscal(idFiscal);
					}if(this.detallesContacto!=null){
							proveedorNuevo.setDetallesContacto(detallesContacto);
					}if(this.entidadLegal!=null){
						proveedorNuevo.setEntidadLegal(entidadLegal);
						proveedorNuevo.setIdentificacionFiscal(idFiscal);
					}
					
					resProveedor=proveedorManager.saveProveedor(proveedorNuevo);
					addActionMessage("El Proveedor se ha creado correctamente");
					logger.info("Creacion PROVEEDOR");
				}
				
			}if(idProveedor>0){
				
				Proveedor proveedorSelec= proveedorManager.obtenerProveedorByid(idProveedor);
				
				if(this.nombre!=null || this.nombre.trim().equals("")){
					proveedorSelec.setNombre(nombre);
					proveedorSelec.setApellido1(apellido1);
					proveedorSelec.setApellido2(apellido2);
					proveedorSelec.setDireccion(direccion);
					proveedorSelec.setIdentificacionFiscal(idFiscal);
				}if(this.detallesContacto!=null){
					proveedorSelec.setDetallesContacto(detallesContacto);
				}if(this.entidadLegal!=null){
					proveedorSelec.setEntidadLegal(entidadLegal);
					proveedorSelec.setIdentificacionFiscal(idFiscal);
				}
			
			proveedorModificado=proveedorManager.UpdateProveedor(proveedorSelec);
			
			}
			
			
		}catch(Exception e){
			
		}
		return null;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Proveedor getResProveedor() {
		return resProveedor;
	}

	public void setResProveedor(Proveedor resProveedor) {
		this.resProveedor = resProveedor;
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
