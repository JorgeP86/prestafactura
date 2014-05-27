<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></SCRIPT>
<title>Gesti&oacute;n Roles</title>
</head>
<script language='javascript'>
	
	function aceptar(){
			
			if(trim(document.getElementById('formulario').nombre.value)=="")
				
					alert('Debe rellenar el nombre del Rol.');
			else
					document.forms['frc'].submit();			
	}

</script>
<body>

<s:if test="%{#session.usuario!= null}">
	<table>
		<tr>
			<td>Gesti&oacute;n de Roles</td>
		</tr>
	</table>
<s:form action="AltaClienteAction" name="frc" namespace="/" method="post" styleId="formulario">
	
	<fieldset>
	<legend>Alta Nuevo Cliente</legend>
	<table border="1" width="90%">
		<tr>
			<td width="200px">
				<s:textfield name="nombreCliente" label="Nombre Cliente"  size="20" id="nombreCliente"/>
			</td>
			<td width="100px">
				<s:textfield name="apellidoPCliente" label="Primer Apellido"  size="20" id="apellidoPCliente"/>
			</td>
			<td width="100px">
				<s:textfield name="apellidoSCliente" label="Segundo Apellido"  size="20" id="apellidoSCliente"/>
			</td>
			<td width="100px">
				<s:textfield name="identificacionFiscal" label="Identificación Fiscal"  size="20" id="identificacionFiscal"/>
			</td>
			
		</tr>
		<tr></tr>	
	</table>
	</fieldset>
	
	
	<fieldset>
	<legend>Direccion</legend>
		<table width="90%">
		<tr>
			<td colspan="1">
				<s:textfield name="calle" label="Domicilio"  size="30" id="calle"/>
			</td>
			<td colspan="1">
				<s:textfield name="numeroEdificio" label="Numero Edificio"  size="30" id="numeroEdificio"/>
			</td>
			<td colspan="1">
				<s:textfield name="departamento" label="Departamento"  size="30" id="departamento"/>
			</td>
		</tr>
			<tr>
			<td colspan="1">
				<s:select label="Selecciona Provincia"  headerKey="1"
  				headerValue="-- Please Select --" name="provincia" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>
			</td>
			<td colspan="1">
				<s:select label="Selecciona Localidad" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidad" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPostal" label="Codigo Postal"  size="30"  id="codigoPostal"/>
			</td>
		</tr>
		<tr>
			<td colspan="1">
				<s:select label="Selecciona País" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPais" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>
			</td>
			<td colspan="1">
				<s:textfield name="posbox" label="Posbox"  size="30"  id="posbox"/>
			</td>
			<td colspan="1">
				<s:textfield name="calleAdicional" label="Calle Adicional"  size="30"  id="calleAdicional"/>
			</td>
		</tr>
	</table>
	</fieldset>	
	
	<fieldset>
	<legend>Direccion de Entrega</legend>	
	<table>
			<tr>
			<td colspan="1">
				<s:textfield name="calleEntrega" label="Domicilio"  size="30" id="calleEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="numeroEdificioEntrega" label="Numero Edificio"  size="30" id="numeroEdificioEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="departamentoEntrega" label="Departamento"  size="30" id="departamentoEntrega"/>
			</td>
			</tr>
			<tr>
			<td colspan="1">
				<s:select label="Selecciona Provincia"  headerKey="1"
  				headerValue="-- Please Select --" name="provinciaEntrega" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>			
  			</td>
			<td colspan="1">
				<s:select label="Selecciona Localidad" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidadEntrega" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPostalEntrega" label="Codigo Postal"  size="30"  id="codigoPostalEntrega"/>
			</td>
		</tr>
		<tr>
			<td colspan="1">
				<s:select label="Selecciona País" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPaisEntrega" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>			
			</td>
			<td colspan="1">
				<s:textfield name="posboxEntrega" label="Posbox"  size="10"  id="posboxEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="calleAdicionalEntrega" label="Calle Adicional"  size="30"  id="calleAdicionalEntrega"/>
			</td>
		</tr>
		<tr></tr>
		</table>
		</fieldset>
		
		<fieldset>
		<legend>Detalles de Contacto del Cliente</legend>
		<table>	
		<tr>
			<td colspan="1">
				<s:textfield name="personaContacto" label="Persona de Contacto"  size="30"  id="personaContacto"/>
			</td>
			<td colspan="1">
				<s:textfield name="telefono" label="Teléfono"  size="30"  id="telefono"/>
			</td>
			<td colspan="1">
				<s:textfield name="mail" label="E-mail"  size="30"  id="mail"/>
			</td>
			<td colspan="1">
				<s:textfield name="fax" label="fax"  size="30"  id="fax"/>
			</td>
			<td colspan="1">
				<s:textfield name="direccionWeb" label="Dirección Web"  size="30"  id="direccionWeb"/>
			</td>
		</tr>
		<tr></tr>
		</table>
		</fieldset>
		
		<fieldset>
		<legend>Entidad Legal</legend>
		<table>
		<tr>
			<td colspan="1">
				<s:textfield name="razonSocial" label="Razón Social"  size="30"  id="razonSocial"/>
			</td>
			<td colspan="1">
				<s:textfield name="nombreComercial" label="Nombre Comercial"  size="30"  id="nombreComercial"/>
			</td>
			<td colspan="1">
				<s:textfield name="datosRegistrales" label="Datos Registrales"  size="30"  id="datosRegistrales"/>
			</td>
		</tr>
		<tr></tr>
		</table>
		</fieldset>
		
		<fieldset>
		<legend>Direccion de la Empresa</legend>
		<table>
		<tr>
			<td colspan="1">
				<s:textfield name="calleEmpresa" label="Domicilio"  size="30" id="calleEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="numeroEdificioEmpresa" label="Numero Edificio"  size="30" id="numeroEdificioEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="departamentoEmpresa" label="Departamento:"  size="30" id="departamentoEmpresa"/>
			</td>
		</tr>
			<tr>
			<td colspan="1">
				<s:select label="Selecciona Provincia"  headerKey="1"
  				headerValue="-- Please Select --" name="provinciaEmpresa" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>			
  			</td>
			<td colspan="1">
				<s:select label="Selecciona Localidad" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidadEmpresa" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPostalEmpresa" label="Codigo Postal"  size="30"  id="codigoPostalEmpresa"/>
			</td>
		</tr>
		<tr>
			<td colspan="1">
				<s:select label="Selecciona País" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPaisEmpresa" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>
			</td>
			<td colspan="1">
				<s:textfield name="posboxEmpresa" label="Posbox"  size="30"  id="posboxEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="calleAdicionalEmpresa" label="Calle Adicional"  size="30"  id="calleAdicionalEmpresa"/>
			</td>
		</tr>
		</table>
		</fieldset>
		
		<fieldset>
		<legend>Detalles de Contacto de la Empresa</legend>
		<table>
			<tr>
			<td colspan="1">
				<s:textfield name="personaContactoEmpresa" label="Persona de Contacto:"  size="30"  id="personaContactoEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="telefonoEmpresa" label="Teléfono"  size="30"  id="telefonoEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="mailEmpresa" label="E-mail"  size="30"  id="mailEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="faxEmpresa" label="fax"  size="30"  id="faxEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="direccionWebEmpresa" label="Dirección Web"  size="30"  id="direccionWebEmpresa"/>
			</td>	
			</tr>
			<s:div>
		<s:fielderror name="invalidClienteAlta">
		</s:fielderror>
	</s:div>
		</table>
	</fieldset>

	<table>
		<tr>
			<td>
			
				<s:hidden name="idCliente" value="0"></s:hidden>	
				<s:submit type="button" value="altaCliente" src='/mages/alta_b.gif'/>			
			 </td>
			 <td>
			 	<a href="<s:url action='home'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
			 </td>
		</tr>
	</table>
	




</s:form>
</s:if>


</body>
</html>