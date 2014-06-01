package com.prestafacturaService.vista.action.factura;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.manager.ClienteManager;

public class CargarDatosFormFacturaTablaAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(CargarDatosFormFacturaTablaAction.class);

	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String SUCCESS = "success";
	
	private String fechaExpedicion;
	private String fechaOperacion;
	private String fechaInicio; // periodo de facturacion
	private String fechaFin;
	private String fechaTipoCambio;
		
	@Autowired
	private ClienteManager clienteManager;
	
	//CARGA DE DATOS PARA TABLA JQUERY
	 
    //Lista de resultados
    private List<Cliente> gridModel;
    
    //Lista temporal
    private List<Cliente> myclient;
    //Número de filas que queremos tener dentro del grid - atributo "rowNum" del grid
    private Integer rows = 0;
    
    //Página actual. Por defecto el grid lo pone en 1
    private Integer page = 0;
    
    //Orden - asc o desc
    private String sord;
    
    //Índice de la fila - i.e. click del usuario para ordenar
    private String sidx;
    
    //campo de búsqueda
    private String searchField;
    
    //cadena de búsqueda
    
    private String searchString;
    
    //La operación de búsqueda ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    private String searchOper;
    
    //Páginas totales
    private Integer total = 0;
    
    //todos los registros
    private Integer records = 0;
    
    private boolean loadonce = false;

    
    
    public String execute() {

		try {
			//Número de registros
			 setRecords(clienteManager.countClient());
			 //Calcula HASTA qué registro será la consulta, suponiendo que rows=10....
	         int to = (getRows() * getPage());//.....la primera vez to=10  (10*1)
	         //Calcula DESDE qué registro se hará la consulta...
	         int from = to - getRows();//....from=0  (10-10)
	         //si la variable "to" sobrepasa el número de registros
	         //disponible, entonces le ponemos ese valor máximo de registros.
	         if(to>getRecords())to=getRecords();
	         
	         //Utilizamos este List temporal para almacenar 
	         //cada Objeto Cliente (Registro) que devolvió la consulta
	         myclient = (List<Cliente>) clienteManager.obtenerClientes();
	         //Le pasamos ese List lleno al List "gridModel", que es el que finalmente ocupará el JQGrid para dibujar la tabla..
	         setGridModel(myclient);
	       //calcula el total de páginas que genera la consulta
	         total = (int) Math.ceil((double) getRecords() / (double) getRows());
			
				logger.info("Obtenido los datos para cargar el formulario_AltaFactura");
			
				
		} catch (Exception e) {
					addActionError("Fallo al obtener datos para el formulario AltaFactura");
					return ERROR;
				}
				return SUCCESS;

		}
    
    
    
    
    public String getJSON(){
        return execute();
}

	//carga de metodos set/get tabla


	public List<Cliente> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Cliente> gridModel) {
		this.gridModel = gridModel;
	}

	public List<Cliente> getMyclient() {
		return myclient;
	}

	public void setMyclient(List<Cliente> myclient) {
		this.myclient = myclient;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	  public void setRecords(Integer records) {
        this.records = records;
        if (this.records > 0 && this.rows > 0) {
      	  this.total = (int) Math.ceil((double) this.records / (double) this.rows);
        } else {
      	  this.total = 0;
        }
	  }

	public boolean isLoadonce() {
		return loadonce;
	}

	public void setLoadonce(boolean loadonce) {
		this.loadonce = loadonce;
	}
	
	
	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getFechaTipoCambio() {
		return fechaTipoCambio;
	}


	public void setFechaTipoCambio(String fechaTipoCambio) {
		this.fechaTipoCambio = fechaTipoCambio;
	}
	

	public String getFechaExpedicion() {
		return fechaExpedicion;
	}


	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}


	public String getFechaOperacion() {
		return fechaOperacion;
	}


	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public ClienteManager getClienteManager() {
		return clienteManager;
	}

	public void setClienteManager(ClienteManager clienteManager) {
		this.clienteManager = clienteManager;
	}



}

