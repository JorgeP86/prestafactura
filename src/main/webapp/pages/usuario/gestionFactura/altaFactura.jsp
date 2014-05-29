<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <sj:head jquerytheme="start"/>
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
				<sj:datepicker id="1" name="fechaExpedicion" displayFormat="dd-mm-yy" label="Fecha de Expedicion"/>
			</td>
			<td>
				<sj:datepicker id="2" name="fechaOperacion" displayFormat="dd-mm-yy" label="Fecha de Operacion"/>
			</td>	
			</tr>
			<tr>
			<td>Periodo de Facturación:</td>
				<td>
				<sj:datepicker id="3" name="fechaInicio" displayFormat="dd-mm-yy" label="Fecha Inicio"/>
				</td>
				<td width="100%">
					<sj:datepicker id="4" name="fechaFin" displayFormat="dd-mm-yy" label="Fecha Fin"/>
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
				<td width="100%">
					<sj:datepicker id="5" name="fechaTipoCambio" displayFormat="dd-mm-yy" label="Fecha Tipo Cambio" labelposition="left"/>
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