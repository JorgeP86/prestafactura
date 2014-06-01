<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <sj:head jquerytheme="start"/>
 <sj:head jqueryui="true" jquerytheme="redmond"/>
<!--<script type="text/javascript" src="jquery-1.2.6.min.js"></script>  -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></SCRIPT>
<title>Alta Factura</title>
</head>
<script language='javascript'>
	
	function aceptar(){
			
			if(trim(document.getElementById('formulario').nombre.value)=="")
				
					alert('Debe rellenar el nombre del Rol.');
			else
					document.forms['frm'].submit();			
	}
	
	
</script>
<body>
<s:if test="%{#session.usuario != null}">
	<table>
		<tr>
			<td>Alta Factura</td>
		</tr>
	</table>

<s:form action="AltaFactura" name="frm" namespace="/" method="post" id="altaFactura" theme="simple">

	<fieldset>
	<legend>Datos Generales Factura</legend>
	<table width="100%">
		<tr>
			<td><label>Numero de Factura</label>
				<s:textfield name="facturaID"  value="" size="30" />
			</td>
			<td>
			<label>Tipo de Factura</label>
			<s:select label="Tipo de Factura" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="tipoFactura" list="#{'Simplificada','Correctiva'}" />
			</td>
			<td><label>Coste Contable</label>
				<s:textfield name="costeContable" label="Coste Contable" value="" size="30" />
			</td>
		</tr>
	</table>
	</fieldset>
	
	<fieldset>
	<legend>Datos de Emision</legend>
	<table width="90%">
		<tr>
			<td>
				<label>Fecha Expedición</label>
				<sj:datepicker id="1" name="fechaExpedicion" displayFormat="dd-mm-yy" theme="simple" />
			</td>
		</tr>
		<tr>
			<td>
			<label>Fecha de Operacion</label>
				<sj:datepicker id="2" name="fechaOperacion" displayFormat="dd-mm-yy" theme="simple"/>	
			</td>
		</tr>
		<tr>
			<td>Periodo de Facturación:</td>
		</tr>
		<tr>		
				<td><label>Fecha de Inicio</label>
				<sj:datepicker id="3" name="fechaInicio" displayFormat="dd-mm-yy" theme="simple"/>
				</td>
		</tr>
		<tr>
				<td><label>Fecha de Fin</label>
					<sj:datepicker id="4" name="fechaFin" displayFormat="dd-mm-yy" theme="simple"/>
				</td>
		</tr>
		<tr>
		</tr>
			<tr>
				<td><label>Moneda de Impuesto</label>
					<s:textfield name="monedaIfact" label="Moneda de Impuesto" value="" size="30" />
				</td>
			
				<td><label>Moneda de Operación</label>
					<s:textfield name="monedaOfact" label="Moneda de Operación" value="" size="30" />
				</td>
				<td><label>Lenguaje</label>
					<s:textfield name="lengua" label="Lenguaje" value="" size="30"/>
				</td>
			<tr>
			</tr>
			<tr>
				<td><label>Porcentaje del Tipo de Cambio</label>
					<s:textfield name="porcentajeTC" label="Porcentaje del Tipo de Cambio" value="" size="30"/>
				</td>
			</tr>
			<tr>
				<td><label>Fecha Tipo de Cambio</label>
					<sj:datepicker id="5" name="fechaTipoCambio" displayFormat="dd-mm-yy" label="Fecha Tipo Cambio" theme="simple"/>
				</td>
			</tr>
		</table>
		</fieldset>
		
	<fieldset>
		<legend>Dirección de Entrega</legend>
		<table width="90%">
		<tr>
			<td><label>Calle de Entrega</label>
				<s:textfield name="calleEntrega" label="Calle de Entrega" value="" size="30"/>
			</td>
			<td><label>Número</label>
				<s:textfield name="numeroEdificioEntrega" label="Número" value="" size="30" />
			</td>
			<td><label>Departamento</label>
				<s:textfield name="departamentoEntrega" label="Departamento" value="" size="30"/>
			</td>
		</tr>
		<tr>
			<td><label>Código Postal</label>
				<s:textfield name="codigoPostalEntrega" label="Código Postal" value="" size="30"/>
			</td>
		</tr>
		<tr>
			<td><label>PostBox</label>
				<s:textfield name="postBoxEntrega" label="PostBox" value="" size="30" />
			</td>
			<td><label>Calle Adicional</label>
				<s:textfield name="calleAdicionalEntrega" label="Calle Adicional" value="" size="30" />
			</td>
		</tr>
		<tr>
			<td><label>Provincia</label>
				<s:select label="Provincia" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="provincia" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>
			</td>
		
			<td><label>Localidad</label>
				<s:select label="Localidad" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidad" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
		
			<td><label>País</label>
				<s:select label="País" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPais" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>
			</td>
		</tr>		
			</table>
		</fieldset>
		


	<script language='javascript'>
		 $.subscribe('rowselect', function(event,data) { 
		  var grid = event.originalEvent.grid; 
		  var sel_id = grid.jqGrid('getGridParam', 'selrow'); 
		  var fiscal = grid.jqGrid('getCell', sel_id, 'identificacionFiscal.identificacionFiscal'); 
		  alert(fiscal); });
 	</script>
 	
 	<s:hidden name="identificacionFiscal" value="fiscal"/> 
 	
 

	<h3>Elegir el cliente para facturar:</h3>
	<s:url id="remoteurl" action="CargarDatosFormFacturaTablaAction" namespace="/" />
	<sjg:grid id="gridtable"
        caption="Cliente"
        dataType="json"
        href="%{remoteurl}"
        pager="true"
        gridModel="gridModel"
        rowList="10,15,20"
        rowNum="10"
        rownumbers="true"
        onSelectRowTopics="rowselect" >
        
        <sjg:gridColumn name="identificacionFiscal.identificacionFiscal" index="identificacionFiscal" title="Identificacion Fiscal" sortable="false"/>
        <sjg:gridColumn name="nombre" index="nombre" title="Nombre Cliente" sortable="true"/>
        <sjg:gridColumn name="apellido1" index="apellido1" title="Apellido" sortable="false"/>
        <sjg:gridColumn name="entidadLegal.nombreComercial" index="nombreComercial" title="Nombre Comercial" sortable="false"/>
    </sjg:grid>
			
		
		
	
	
	<s:div id="buttons">
	<table>
		<tr>
			<td>
				<s:hidden name="idFactura" value="0"></s:hidden>	
				<s:submit type="image" value="altaFactura" src='images/alta_b.gif'/>			
			 </td>
			 <td>
			 	<a href="<s:url action='home'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
			 </td>
		</tr>
	</table>
		
	</s:div>
	
</s:form>

</s:if>
</body>
</html>