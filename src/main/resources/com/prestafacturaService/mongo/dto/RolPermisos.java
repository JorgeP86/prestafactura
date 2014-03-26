package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="rolPermisos")
public class RolPermisos extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6294226323368048506L;
	private String nombre;
	private String descripcion;
	
	private int altaUsuario;
	private int bajaUsuario;
	private int editarUsuario;
	private int consultarUsuario;
	private int listarUsuario;
	
	
	private int altaRol;
	private int bajaRol;
	private int editarRol;
	private int consultaRol;	
	private int listarRoles;
	
	
	private int	altaProveedor;
	private int	bajaProveedor;
	private int	editarProveedor;
	private int	consultarProveedor;
	private int	listarProveedor;
	
	
	private int	altaCliente;
	private int	bajaCliente;
	private int	editarCliente;
	private int	consultarCliente;
	private int	listarCliente;
	
	private int	altaDatos;
	private int	consultarDatos;
	private int	editarDatos;
	
	private int	consultarInformacion;
	private int	eliminarInformacion;
	private int	publicarInformacion;
	
	private int	crearFactura;
	
	private int	consultarFactura;
	private int	descargarFactura;
	
	private int	generarFirmaElectronica;
	private int	consultarFirmaElectronica;
	
	public int getAltaCliente() {
		return altaCliente;
	}
	public void setAltaCliente(int altaCliente) {
		this.altaCliente = altaCliente;
	}
	public int getAltaDatos() {
		return altaDatos;
	}
	public void setAltaDatos(int altaDatos) {
		this.altaDatos = altaDatos;
	}
	public int getAltaProveedor() {
		return altaProveedor;
	}
	public void setAltaProveedor(int altaProveedor) {
		this.altaProveedor = altaProveedor;
	}
	public int getAltaRol() {
		return altaRol;
	}
	public void setAltaRol(int altaRol) {
		this.altaRol = altaRol;
	}
	public int getAltaUsuario() {
		return altaUsuario;
	}
	public void setAltaUsuario(int altaUsuario) {
		this.altaUsuario = altaUsuario;
	}
	public int getBajaCliente() {
		return bajaCliente;
	}
	public void setBajaCliente(int bajaCliente) {
		this.bajaCliente = bajaCliente;
	}
	public int getBajaProveedor() {
		return bajaProveedor;
	}
	public void setBajaProveedor(int bajaProveedor) {
		this.bajaProveedor = bajaProveedor;
	}
	public int getBajaRol() {
		return bajaRol;
	}
	public void setBajaRol(int bajaRol) {
		this.bajaRol = bajaRol;
	}
	public int getBajaUsuario() {
		return bajaUsuario;
	}
	public void setBajaUsuario(int bajaUsuario) {
		this.bajaUsuario = bajaUsuario;
	}
	public int getConsultarCliente() {
		return consultarCliente;
	}
	public void setConsultarCliente(int consultarCliente) {
		this.consultarCliente = consultarCliente;
	}
	public int getConsultarDatos() {
		return consultarDatos;
	}
	public void setConsultarDatos(int consultarDatos) {
		this.consultarDatos = consultarDatos;
	}
	public int getConsultarFactura() {
		return consultarFactura;
	}
	public void setConsultarFactura(int consultarFactura) {
		this.consultarFactura = consultarFactura;
	}
	public int getConsultarFirmaElectronica() {
		return consultarFirmaElectronica;
	}
	public void setConsultarFirmaElectronica(int consultarFirmaElectronica) {
		this.consultarFirmaElectronica = consultarFirmaElectronica;
	}
	public int getConsultarInformacion() {
		return consultarInformacion;
	}
	public void setConsultarInformacion(int consultarInformacion) {
		this.consultarInformacion = consultarInformacion;
	}
	public int getConsultaRol() {
		return consultaRol;
	}
	public void setConsultaRol(int consultaRol) {
		this.consultaRol = consultaRol;
	}
	public int getConsultarProveedor() {
		return consultarProveedor;
	}
	public void setConsultarProveedor(int consultarProveedor) {
		this.consultarProveedor = consultarProveedor;
	}
	
	public int getConsultarUsuario() {
		return consultarUsuario;
	}
	public void setConsultarUsuario(int consultarUsuario) {
		this.consultarUsuario = consultarUsuario;
	}
	public int getCrearFactura() {
		return crearFactura;
	}
	public void setCrearFactura(int crearFactura) {
		this.crearFactura = crearFactura;
	}
	public int getDescargarFactura() {
		return descargarFactura;
	}
	public void setDescargarFactura(int descargarFactura) {
		this.descargarFactura = descargarFactura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEditarCliente() {
		return editarCliente;
	}
	public void setEditarCliente(int editarCliente) {
		this.editarCliente = editarCliente;
	}
	public int getEditarDatos() {
		return editarDatos;
	}
	public void setEditarDatos(int editarDatos) {
		this.editarDatos = editarDatos;
	}
	public int getEditarProveedor() {
		return editarProveedor;
	}
	public void setEditarProveedor(int editarProveedor) {
		this.editarProveedor = editarProveedor;
	}
	public int getEditarRol() {
		return editarRol;
	}
	public void setEditarRol(int editarRol) {
		this.editarRol = editarRol;
	}

	public int getEliminarInformacion() {
		return eliminarInformacion;
	}
	public void setEliminarInformacion(int eliminarInformacion) {
		this.eliminarInformacion = eliminarInformacion;
	}
	public int getGenerarFirmaElectronica() {
		return generarFirmaElectronica;
	}
	public void setGenerarFirmaElectronica(int generarFirmaElectronica) {
		this.generarFirmaElectronica = generarFirmaElectronica;
	}
	public int getListarCliente() {
		return listarCliente;
	}
	public void setListarCliente(int listarCliente) {
		this.listarCliente = listarCliente;
	}
	public int getListarProveedor() {
		return listarProveedor;
	}
	public void setListarProveedor(int listarProveedor) {
		this.listarProveedor = listarProveedor;
	}
	public int getListarRoles() {
		return listarRoles;
	}
	public void setListarRoles(int listarRoles) {
		this.listarRoles = listarRoles;
	}
	public int getListarUsuario() {
		return listarUsuario;
	}
	public void setListarUsuario(int listarUsuario) {
		this.listarUsuario = listarUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPublicarInformacion() {
		return publicarInformacion;
	}
	public void setPublicarInformacion(int publicarInformacion) {
		this.publicarInformacion = publicarInformacion;
	}
	public int getEditarUsuario() {
		return editarUsuario;
	}
	public void setEditarUsuario(int editarUsuario) {
		this.editarUsuario = editarUsuario;
	}
	

}
