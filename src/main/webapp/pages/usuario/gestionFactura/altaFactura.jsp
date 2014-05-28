<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<s:form action="AltaFactura" name="frm" namespace="/" method="post" id="altaFactura">

	<fieldset>
	<legend>Datos Generales Factura</legend>
	<table width="90%">
		<tr>
			<td>
				<s:textfield name="facturaID" label="Numero de Factura" value="" size="30"/>
			</td>
			<td>
			<s:select label="Tipo de Factura" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="tipoFactura" list="#{'Simplificada','Correctiva'}" />
			</td>
			<td>
				<s:textfield name="costeContable" label="Coste Contable" value="" size="30"/>
			</td>
		</tr>
	</table>
	</fieldset>
	
	<fieldset>
	<legend>Datos de Emision</legend>
	<table width="90%">
		<tr>
			<td>	
				<sx:datetimepicker name="fechaExpedicion" label="Fecha Expedición" 
				displayFormat="dd-MMM-yyyy" value="%{'todayDate'}"/>
			</td>
			<td>
				<sx:datetimepicker name="fechaOperacion" label="Fecha Operación" 
				displayFormat="dd-MMM-yyyy" value="%{'todayDate'}"/>
			</td>	
			</tr>
			<tr>
			<td>Periodo de Facturación:</td>
				<td>
					<sx:datetimepicker name="fechaInicio" label="Fecha Inicio" 
					displayFormat="dd-MMM-yyyy" value="%{'todayDate'}"/>
				</td>
				<td>
					<sx:datetimepicker name="fechaFin" label="Fecha Fin" 
					displayFormat="dd-MMM-yyyy" value="%{'todayDate'}"/>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="monedaIfact" label="Moneda de Impuesto" value="" size="30"/>
				</td>
				<td>
					<s:textfield name="monedaOfact" label="Moneda de Operación" value="" size="30"/>
				</td>
				<td>
					<s:textfield name="lengua" label="Lenguaje" value="" size="30"/>
				</td>
				<td>
					<s:textfield name="porcentajeTC" label="Porcentaje del Tipo de Cambio" value="" size="30"/>
				</td>
				<td>
					<sx:datetimepicker name="fechaTipoCambio" label="Fecha Tipo del Cambio" 
					displayFormat="dd-MMM-yyyy" value="%{'todayDate'}"/>
				</td>
			</tr>
		</table>
		</fieldset>
		
	<fieldset>
		<legend>Dirección de Entrega</legend>
		<table width="90%">
		<tr>
			<td>
				<s:textfield name="calleEntrega" label="Calle de Entrega" value="" size="30"/>
			</td>
			<td>
				<s:textfield name="numeroEdificioEntrega" label="Número" value="" size="30"/>
			</td>
			<td>
				<s:textfield name="departamentoEntrega" label="Departamento" value="" size="30"/>
			</td>
			<td>
				<s:textfield name="codigoPostalEntrega" label="Código Postal" value="" size="30"/>
			</td>
			<td>
				<s:textfield name="postBoxEntrega" label="PostBox" value="" size="30"/>
			</td>
			<td>
				<s:textfield name="calleAdicionalEntrega" label="Calle Adicional" value="" size="30"/>
			</td>
			<td>
				<s:select label="Provincia" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="provincia" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>
			</td>
			<td>
				<s:select label="Localidad" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidad" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td>
			<td>
				<s:select label="País" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPais" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>
			</td>
			</tr>		
			</table>
		</fieldset>
		
		
		
	
	
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