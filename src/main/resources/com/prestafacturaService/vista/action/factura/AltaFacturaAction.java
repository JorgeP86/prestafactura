package com.prestafacturaService.vista.action.factura;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cabecera;
import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.dto.Cuenta;
import com.prestafacturaService.mongo.dto.DatosAdicionales;
import com.prestafacturaService.mongo.dto.DatosEmisionFact;
import com.prestafacturaService.mongo.dto.DatosPago;
import com.prestafacturaService.mongo.dto.Detalle;
import com.prestafacturaService.mongo.dto.Direccion;
import com.prestafacturaService.mongo.dto.Factura;
import com.prestafacturaService.mongo.dto.Fechas;
import com.prestafacturaService.mongo.dto.FiguraFactura;
import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.MetodoPago;
import com.prestafacturaService.mongo.dto.Moneda;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.dto.TipoCambio;
import com.prestafacturaService.mongo.manager.CodigoPaisManager;
import com.prestafacturaService.mongo.manager.MonedaManager;
import com.prestafacturaService.mongo.manager.ProvinciaManager;

public class AltaFacturaAction extends ActionSupport implements
		ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";

	private static final Logger logger = Logger
			.getLogger(AltaFacturaAction.class);

	private HttpServletRequest servletRequest;

	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private ProvinciaManager provinciaManager;
	@Autowired
	private CodigoPaisManager codigoPaisManager;

	// Cabecera
	private String facturaID;
	private String tipoFactura;
	private String costeContable;
	// Datos de Emisión
	private Date fechaExpedicion;
	private Date fechaOperacion;
	private Date fechaInicio; // periodo de facturacion
	private Date fechaFin;
	private String monedaIfact; // moneda de Impuesto
	private String monedaOfact; // moneda de Operacion
	private String lengua;
	private String porcentajeTC;// Tipo de Cambio
	private Date fechaTipoCambio;// Tipo de Cambio
	private String calleEntrega;// DireccionEntrega
	private String numeroEdificioEntrega;// DireccionEntrega
	private String calleAdicionalEntrega;// DireccionEntrega
	private String departamentoEntrega;// DireccionEntrega
	private String codigoPostalEntrega;// DireccionEntrega
	private String localidadEntrega;// DireccionEntrega
	private String provinciaEntrega;// DireccionEntrega
	private String codigoPaisEntrega;// DireccionEntrega
	private String postBoxEntrega;// DireccionEntrega
	
//Datos de Pago
	private Date fechaVencimiento;
	private Double importeVencimiento;
	private String metodoDePago;
	private Integer codigoCanalPago;
	private String refPago;
	private String infoAdicional;
	private String ibanNumeroCuenta;
	private String codigoEntidadFinanciera;
	private String codigoOficina;
	private String callePago;
	private String numeroEdificioPago;
	private String calleAdicionalPago;
	private String departamentoPago;
	private String codigoPostalPago;
	private String provinciaPago;
	private String localidadPago;
	private String codigoPaisPago;
	private String postBoxPago;
	
	//return today date
		public Date getTodayDate(){
	 
			return new Date();
		}
		
		
	
	public String execute(){
		
	try{	

//Cabecera
		Cabecera cabecerafactura=new Cabecera();
		logger.info("Creado el objeto cabecerafactura vacio");
		cabecerafactura.setFacturaID(facturaID);
		cabecerafactura.setTipoFactura(tipoFactura);
		cabecerafactura.setCosteContable(new Double(costeContable));
		logger.info("Creado el objeto cabecerafactura relleno");

//Datos de Emision
		DatosEmisionFact datosEmision= new DatosEmisionFact();
		logger.info("Creado el objeto datosEmision vacio");
		datosEmision.setFechaExpedicion(fechaExpedicion);
		datosEmision.setFechaOperacion(fechaOperacion);
		Fechas periodoFacturacion= new Fechas();
		periodoFacturacion.setFechaInicio(fechaInicio);
		periodoFacturacion.setFechaFin(fechaFin);
		datosEmision.setPeriodoFacturacion(periodoFacturacion);
		Moneda monedaImpuesto=monedaManager.ObtenerMoneda(monedaIfact);
		datosEmision.setMonedaImpuesto(monedaImpuesto);
		Moneda monedaOperacion=monedaManager.ObtenerMoneda(monedaOfact);
		datosEmision.setMonedaOperacion(monedaOperacion);
		datosEmision.setLengua(lengua);
		TipoCambio tipoCambio= new TipoCambio();
		tipoCambio.setPorcentaje(new Double(porcentajeTC));
		tipoCambio.setFechaTipoCambio(fechaTipoCambio);
		Direccion direccionEntrega= new Direccion();
		direccionEntrega.setTipodireccion("Entrega");
		direccionEntrega.setCalle(calleEntrega);
		direccionEntrega.setDepartamento(departamentoEntrega);
		direccionEntrega.setNumeroEdificio(numeroEdificioEntrega);
		direccionEntrega.setCodigoPostal(codigoPostalEntrega);
		if(calleAdicionalEntrega!=null ||calleAdicionalEntrega.trim().equals("")){
			direccionEntrega.setCalleAdicional(calleAdicionalEntrega);
		}
		CodigoPais codigoPaisEn=codigoPaisManager.ObtenerCodigoPais(codigoPaisEntrega);
		direccionEntrega.setCodigoPais(codigoPaisEn);
		direccionEntrega.setPostBox(postBoxEntrega);
		Provincia provinciaEnt=provinciaManager.obtenerProvinciaByName(provinciaEntrega);
		direccionEntrega.setProvincia(provinciaEnt);
		Localidad loc=new Localidad();
		for(Localidad p:provinciaEnt.getLocalidades()){
			if(p.equals(localidadEntrega)){
				loc=p;
			}	
		}
		direccionEntrega.setLocalidad(loc);
		logger.info("Creado el objeto datosEmision relleno");
		
//FiguraFactura
		Set<FiguraFactura> figuraFactura=new HashSet<FiguraFactura>();
		logger.info("Se crea la lista FiguraFactura vacio");

		if(servletRequest.getSession().getAttribute("figuraFacCliente")!=null){
			logger.info("Se ha comprobado que la figuraFacCliente es !=null");	
			FiguraFactura figuraCliente=(FiguraFactura)servletRequest.getSession().getAttribute("figuraFacCliente");
			figuraFactura.add(figuraCliente);
			logger.info("Se añade la figuraCliente a la lista");
		}
		if(servletRequest.getSession().getAttribute("figuraFacDatosP")!=null){
			logger.info("Se ha comprobado que la figuraFacDatosP es !=null");	
			FiguraFactura figuraDatosPropios=(FiguraFactura) servletRequest.getSession().getAttribute("figuraFacDatosP");
			figuraFactura.add(figuraDatosPropios);
			logger.info("Se añade la figuraDatosPropios a la lista");
		}

		
//Datos de Pago
		Direccion direccionPago= new Direccion();
		direccionPago.setTipodireccion("Direccion_Pago");
		direccionPago.setCalle(callePago);
		direccionPago.setCalleAdicional(calleAdicionalPago);
		direccionPago.setDepartamento(departamentoPago);
		direccionPago.setNumeroEdificio(numeroEdificioPago);
		direccionPago.setPostBox(postBoxPago);
		direccionPago.setCodigoPostal(codigoPostalPago);
		Provincia provinciaP=provinciaManager.obtenerProvinciaByName(provinciaPago);
		direccionPago.setProvincia(provinciaP);
		Localidad lop=new Localidad();
		for(Localidad l:provinciaP.getLocalidades()){
			if(l.equals(localidadPago));
			lop=l;
		}
		direccionPago.setLocalidad(lop);
		CodigoPais codPaisp= codigoPaisManager.ObtenerCodigoPais(codigoPaisPago);
		direccionPago.setCodigoPais(codPaisp);
		logger.info("Creado el objeto direccionPago");

		
		Cuenta cuentaPago= new Cuenta();
		cuentaPago.setCodigoEntidadFinanciera(codigoEntidadFinanciera);
		cuentaPago.setCodigoOficina(codigoOficina);
		cuentaPago.setIbanNumeroCuenta(ibanNumeroCuenta);
		cuentaPago.setDireccion(direccionPago);
		logger.info("Creado objeto CuentaPago");
		
		MetodoPago metodop= new MetodoPago();
		metodop.setNombre(metodoDePago);
		logger.info("Creado el objeto MetodoPago");
		
		DatosPago datosPago=new DatosPago();
		datosPago.setImporteVencimiento(importeVencimiento);
		datosPago.setFechaVencimiento(fechaVencimiento);
		datosPago.setCodigoCanalPago(codigoCanalPago);
		datosPago.setInfoAdicional(infoAdicional);
		datosPago.setRefPago(refPago);
		datosPago.setCuenta(cuentaPago);
		datosPago.setMetodoPago(metodop);
		logger.info("Creado el objeto DatosPago");
		

//Crear Detalles
		
		Set<Detalle> detalles= new HashSet();
		servletRequest.getSession().setAttribute("detalles", detalles);
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		Factura nuevaFactura= new Factura();
		logger.info("Creado el objeto nuevaFactura vacio");
		nuevaFactura.setCabecera(cabecerafactura);
		nuevaFactura.setDatosEmisionFact(datosEmision);
		nuevaFactura.setFiguraFactura(figuraFactura);
		if(servletRequest.getSession().getAttribute("DatosAdicionales")!=null){
			DatosAdicionales datosadic=(DatosAdicionales) servletRequest.getSession().getAttribute("DatosAdicionales");
			nuevaFactura.setDatosAdicionales(datosadic);
		}
		nuevaFactura.setDatosPago(datosPago);
		
		
		
		
		
		
		
		
		
	}catch (Exception e){

		 addActionError("Fallo al realizar el alta de la Factura");
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

	public MonedaManager getMonedaManager() {
		return monedaManager;
	}

	public void setMonedaManager(MonedaManager monedaManager) {
		this.monedaManager = monedaManager;
	}

	

	public ProvinciaManager getProvinciaManager() {
		return provinciaManager;
	}

	public void setProvinciaManager(ProvinciaManager provinciaManager) {
		this.provinciaManager = provinciaManager;
	}

	public CodigoPaisManager getCodigoPaisManager() {
		return codigoPaisManager;
	}

	public void setCodigoPaisManager(CodigoPaisManager codigoPaisManager) {
		this.codigoPaisManager = codigoPaisManager;
	}

	public String getFacturaID() {
		return facturaID;
	}

	public void setFacturaID(String facturaID) {
		this.facturaID = facturaID;
	}

	public String getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getMonedaIfact() {
		return monedaIfact;
	}

	public void setMonedaIfact(String monedaIfact) {
		this.monedaIfact = monedaIfact;
	}

	public String getMonedaOfact() {
		return monedaOfact;
	}

	public void setMonedaOfact(String monedaOfact) {
		this.monedaOfact = monedaOfact;
	}

	public String getLengua() {
		return lengua;
	}

	public void setLengua(String lengua) {
		this.lengua = lengua;
	}


	public Date getFechaTipoCambio() {
		return fechaTipoCambio;
	}

	public void setFechaTipoCambio(Date fechaTipoCambio) {
		this.fechaTipoCambio = fechaTipoCambio;
	}

	public String getCalleEntrega() {
		return calleEntrega;
	}

	public void setCalleEntrega(String calleEntrega) {
		this.calleEntrega = calleEntrega;
	}

	public String getNumeroEdificioEntrega() {
		return numeroEdificioEntrega;
	}

	public void setNumeroEdificioEntrega(String numeroEdificioEntrega) {
		this.numeroEdificioEntrega = numeroEdificioEntrega;
	}

	public String getCalleAdicionalEntrega() {
		return calleAdicionalEntrega;
	}

	public void setCalleAdicionalEntrega(String calleAdicionalEntrega) {
		this.calleAdicionalEntrega = calleAdicionalEntrega;
	}

	public String getDepartamentoEntrega() {
		return departamentoEntrega;
	}

	public void setDepartamentoEntrega(String departamentoEntrega) {
		this.departamentoEntrega = departamentoEntrega;
	}

	public String getCodigoPostalEntrega() {
		return codigoPostalEntrega;
	}

	public void setCodigoPostalEntrega(String codigoPostalEntrega) {
		this.codigoPostalEntrega = codigoPostalEntrega;
	}

	public String getLocalidadEntrega() {
		return localidadEntrega;
	}

	public void setLocalidadEntrega(String localidadEntrega) {
		this.localidadEntrega = localidadEntrega;
	}

	public String getProvinciaEntrega() {
		return provinciaEntrega;
	}

	public void setProvinciaEntrega(String provinciaEntrega) {
		this.provinciaEntrega = provinciaEntrega;
	}

	public String getCodigoPaisEntrega() {
		return codigoPaisEntrega;
	}

	public void setCodigoPaisEntrega(String codigoPaisEntrega) {
		this.codigoPaisEntrega = codigoPaisEntrega;
	}

	public String getPostBoxEntrega() {
		return postBoxEntrega;
	}

	public void setPostBoxEntrega(String postBoxEntrega) {
		this.postBoxEntrega = postBoxEntrega;
	}

}
