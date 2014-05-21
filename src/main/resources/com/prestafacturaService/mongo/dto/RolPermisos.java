package com.prestafacturaService.mongo.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rolPermisos")
public class RolPermisos extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6294226323368048506L;
	private String nombre;
	private String descripcion;

	// Permisos
	private int altaCliente;
	private int altaDatos;
	private int altaProveedor;
	private int altaRol;
	private int altaUsuario;

	private int bajaClientes;
	private int bajaProveedor;
	private int bajaRol;
	private int bajaUsuario;

	private int consultarClientes;
	private int consultarDatos;
	private int consultarFactura;
	private int consultarFirmaElectronica;
	private int consultarInformacion;
	private int consultarRol;
	private int consultarProveedor;
	private int consultarUsuario;

	private int crearFactura;
	private int descargarFactura;

	private int editarClientes;
	private int editarProveedor;
	private int editarRol;
	private int editarUsuario;
	private int editarDatos;

	private int eliminarInformacion;
	private int generarFirmaElectronica;

	private int listarClientes;
	private int listarProveedores;
	private int listarRoles;
	private int listarUsuarios;

	private int publicarInformacion;

	private int gestionInformacion;
	private int gestionFirmaElectronica;
	private int gestionFacturasAlmacenadas;
	private int gestionFactura;
	private int gestionDatosInternos;
	private int gestionClientes;
	private int gestionProveedores;
	private int gestionRoles;
	private int gestionUsuarios;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

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

	public int getBajaClientes() {
		return bajaClientes;
	}

	public void setBajaClientes(int bajaClientes) {
		this.bajaClientes = bajaClientes;
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

	public int getConsultarClientes() {
		return consultarClientes;
	}

	public void setConsultarClientes(int consultarClientes) {
		this.consultarClientes = consultarClientes;
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

	public int getConsultarRol() {
		return consultarRol;
	}

	public void setConsultarRol(int consultarRol) {
		this.consultarRol = consultarRol;
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

	public int getEditarClientes() {
		return editarClientes;
	}

	public void setEditarClientes(int editarClientes) {
		this.editarClientes = editarClientes;
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

	public int getEditarUsuario() {
		return editarUsuario;
	}

	public void setEditarUsuario(int editarUsuario) {
		this.editarUsuario = editarUsuario;
	}

	public int getEditarDatos() {
		return editarDatos;
	}

	public void setEditarDatos(int editarDatos) {
		this.editarDatos = editarDatos;
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

	public int getListarClientes() {
		return listarClientes;
	}

	public void setListarClientes(int listarClientes) {
		this.listarClientes = listarClientes;
	}

	public int getListarProveedores() {
		return listarProveedores;
	}

	public void setListarProveedores(int listarProveedores) {
		this.listarProveedores = listarProveedores;
	}

	public int getListarRoles() {
		return listarRoles;
	}

	public void setListarRoles(int listarRoles) {
		this.listarRoles = listarRoles;
	}

	public int getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(int listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}

	public int getPublicarInformacion() {
		return publicarInformacion;
	}

	public void setPublicarInformacion(int publicarInformacion) {
		this.publicarInformacion = publicarInformacion;
	}

	public int getGestionInformacion() {
		return gestionInformacion;
	}

	public void setGestionInformacion(int gestionInformacion) {
		this.gestionInformacion = gestionInformacion;
	}

	public int getGestionFirmaElectronica() {
		return gestionFirmaElectronica;
	}

	public void setGestionFirmaElectronica(int gestionFirmaElectronica) {
		this.gestionFirmaElectronica = gestionFirmaElectronica;
	}

	public int getGestionFacturasAlmacenadas() {
		return gestionFacturasAlmacenadas;
	}

	public void setGestionFacturasAlmacenadas(int gestionFacturasAlmacenadas) {
		this.gestionFacturasAlmacenadas = gestionFacturasAlmacenadas;
	}

	public int getGestionFactura() {
		return gestionFactura;
	}

	public void setGestionFactura(int gestionFactura) {
		this.gestionFactura = gestionFactura;
	}

	public int getGestionDatosInternos() {
		return gestionDatosInternos;
	}

	public void setGestionDatosInternos(int gestionDatosInternos) {
		this.gestionDatosInternos = gestionDatosInternos;
	}

	public int getGestionClientes() {
		return gestionClientes;
	}

	public void setGestionClientes(int gestionClientes) {
		this.gestionClientes = gestionClientes;
	}

	public int getGestionProveedores() {
		return gestionProveedores;
	}

	public void setGestionProveedores(int gestionProveedores) {
		this.gestionProveedores = gestionProveedores;
	}

	public int getGestionRoles() {
		return gestionRoles;
	}

	public void setGestionRoles(int gestionRoles) {
		this.gestionRoles = gestionRoles;
	}

	public int getGestionUsuarios() {
		return gestionUsuarios;
	}

	public void setGestionUsuarios(int gestionUsuarios) {
		this.gestionUsuarios = gestionUsuarios;
	}

}
