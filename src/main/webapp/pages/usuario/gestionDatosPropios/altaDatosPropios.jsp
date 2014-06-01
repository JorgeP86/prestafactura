<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/altaCliente.css'/>"/>
<SCRIPT language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></SCRIPT>
<title>Gesti&oacute;n Datos Propios</title>
</head>
<script language='javascript'>
	
	function aceptar(){
			
			if(trim(document.getElementById('formulario').nombre.value)=="")
				
					alert('Debe rellenar los datos');
			else
					document.forms['frc'].submit();			
	}

</script>
<body>
<s:div id="alta_DatosPropios">
<s:if test="%{#session.usuario!= null}">
<s:div id="title_form">
	<table>
		<tr>
			<td><h3>Alta Datos Propios</h3></td>
		</tr>
	</table>
</s:div>

<s:form action="AltaDatosPropiosAction" name="frc" namespace="/" method="post" styleId="formulario">
	<s:div id="alta_form">
	<s:div id="datosPropios">
	<fieldset>
	<legend>Datos Propios</legend>
	<table>
		<tr>
			<td>
				<s:textfield name="nombre" label="Nombre/Empresa" labelposition="left" size="20" id="nombre"/>
			</td>
			<td>
				<s:textfield name="identificacionFiscal" label="Identificación Fiscal" labelposition="left" size="10" id="identificacionFiscal"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="apellidoP" label="Primer Apellido" labelposition="left" size="20" id="apellidoP"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="apellidoS" label="Segundo Apellido" labelposition="left" size="20" id="apellidoS"/>
			</td>
		</tr>	
	</table>
	</fieldset>
	</s:div>
	<s:div id="direccion">
	<fieldset>
	<legend>Direccion</legend>
		<table>
		<tr>
			<td>
				<s:textfield name="calle" label="Domicilio" labelposition="left" size="30" id="calle"/>
			</td>
			<td>
				<s:textfield name="numeroEdificio" label="Numero Edificio" labelposition="left" size="5" id="numeroEdificio"/>
			</td>
			<td>
				<s:textfield name="departamento" label="Departamento" labelposition="left" size="10" id="departamento"/>
			</td>
		</tr>
			<tr>
			<td>
				<s:select label="Provincia" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="provincia" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>
			</td>
			<td>
				<s:select label="Localidad" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidad" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td>
				<s:textfield name="codigoPostal" label="Codigo Postal" labelposition="left" size="10"  id="codigoPostal"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:select label="País" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPais" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>
			</td>
			<td>
				<s:textfield name="posbox" label="Posbox" labelposition="left" size="5"  id="posbox"/>
			</td>
			<td>
				<s:textfield name="calleAdicional" label="Calle Adicional" labelposition="left" size="20"  id="calleAdicional"/>
			</td>
		</tr>
	</table>
	</fieldset>	
	</s:div>
	<s:div id="direccionEntrega">
	<fieldset>
	<legend>Direccion de Entrega</legend>	
	<table>
			<tr>
			<td>
				<s:textfield name="calleEntrega" label="Domicilio" labelposition="left" size="30" id="calleEntrega"/>
			</td>
			<td>
				<s:textfield name="numeroEdificioEntrega" label="Numero Edificio" labelposition="left" size="30" id="numeroEdificioEntrega"/>
			</td>
			<td>
				<s:textfield name="departamentoEntrega" label="Departamento" labelposition="left" size="30" id="departamentoEntrega"/>
			</td>
			</tr>
			<tr>
			<td>
				<s:select label="Provincia" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="provinciaEntrega" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>			
  			</td>
			<td>
				<s:select label="Localidad" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidadEntrega" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td>
				<s:textfield name="codigoPostalEntrega" label="Codigo Postal" labelposition="left" size="30"  id="codigoPostalEntrega"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:select label="País" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPaisEntrega" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>			
			</td>
			<td>
				<s:textfield name="posboxEntrega" label="Posbox" labelposition="left" size="10"  id="posboxEntrega"/>
			</td>
			<td>
				<s:textfield name="calleAdicionalEntrega" label="Calle Adicional" labelposition="left" size="30"  id="calleAdicionalEntrega"/>
			</td>
		</tr>
		<tr></tr>
		</table>
		</fieldset>
		</s:div>
		<s:div id="detallesContacto">
		<fieldset>
		<legend>Detalles de Contacto del Cliente</legend>
		<table>	
		<tr>
			<td>
				<s:textfield name="personaContacto" label="Persona de Contacto" labelposition="left" size="10"  id="personaContacto"/>
			</td>
			<td>
				<s:textfield name="telefono" label="Teléfono" labelposition="left" size="10"  id="telefono"/>		
			</td>
			<td>
				<s:textfield name="fax" label="fax" labelposition="left" size="10"  id="fax"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="mail" label="E-mail" labelposition="left" size="10"  id="mail"/>
			</td>
			<td>
				<s:textfield name="direccionWeb" label="Dirección Web" labelposition="left" size="10"  id="direccionWeb"/>
			</td>
		</tr>
		<tr></tr>
		</table>
		</fieldset>
		</s:div>
		<s:div id="entidadLegal">
		<fieldset>
		<legend>Entidad Legal</legend>
		<table>
		<tr>
			<td>
				<s:textfield name="razonSocial" label="Razón Social" labelposition="left" size="20"  id="razonSocial"/>
			</td>
			<td>
				<s:textfield name="nombreComercial" label="Nombre Comercial" labelposition="left" size="20"  id="nombreComercial"/>
			</td>
			<td>
				<s:textfield name="datosRegistrales" label="Datos Registrales" labelposition="left" size="30"  id="datosRegistrales"/>
			</td>
		</tr>
		<tr></tr>
		</table>
		</fieldset>
		</s:div>
		<s:div id="direccionEmpresa">
		<fieldset>
		<legend>Direccion de la Empresa</legend>
		<table>
		<tr>
			<td>
				<s:textfield name="calleEmpresa" label="Domicilio" labelposition="left" size="30" id="calleEmpresa"/>
			</td>
			<td>
				<s:textfield name="numeroEdificioEmpresa" label="Numero Edificio" labelposition="left" size="10" id="numeroEdificioEmpresa"/>
			</td>
			<td>
				<s:textfield name="departamentoEmpresa" label="Departamento" labelposition="left" size="10" id="departamentoEmpresa"/>
			</td>
		</tr>
			<tr>
			<td>
				<s:select label="Provincia" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="provinciaEmpresa" list="listProvincias" listValue="%{provincia}" value="%{provincia}" listKey="%{provincia}" key="%{provincia}"/>			
  			</td>
			<td>
				<s:select label="Localidad" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listLocalidades" 
				listValue="%{localidad}" name="localidadEmpresa" value="%{localidad}" listKey="%{localidad}" key="%{localidad}"/>
			</td>
			<td>
				<s:textfield name="codigoPostalEmpresa" label="Codigo Postal" labelposition="left" size="10"  id="codigoPostalEmpresa"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:select label="Selecciona País" labelposition="left" headerKey="1" headerValue="-- Please Select --"  list="listPais" 
				listValue="%{codigoPais}" name="codigoPaisEmpresa" value="%{codigoPais}" listKey="%{codigoPais}" key="%{codigoPais}"/>
			</td>
			<td>
				<s:textfield name="posboxEmpresa" label="Posbox" labelposition="left" size="10"  id="posboxEmpresa"/>
			</td>
			<td>
				<s:textfield name="calleAdicionalEmpresa" label="Calle Adicional" labelposition="left" size="30"  id="calleAdicionalEmpresa"/>
			</td>
		</tr>
		</table>
		</fieldset>
		</s:div>
		<s:div id="detallesContactoEmpresa">
		<fieldset>
		<legend>Detalles de Contacto de la Empresa</legend>
		<table>
			<tr>
				<td>
					<s:textfield name="personaContactoEmpresa" label="Persona de Contacto" labelposition="left" size="20"  id="personaContactoEmpresa"/>
				</td>
				<td>
					<s:textfield name="telefonoEmpresa" label="Teléfono" labelposition="left" size="10"  id="telefonoEmpresa"/>
				</td>
				<td>
					<s:textfield name="faxEmpresa" label="fax" labelposition="left" size="10"  id="faxEmpresa"/>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="mailEmpresa" label="E-mail" labelposition="left" size="20"  id="mailEmpresa"/>
				</td>
				<td>
					<s:textfield name="direccionWebEmpresa" label="Dirección Web" labelposition="left" size="20"  id="direccionWebEmpresa"/>
				</td>
			</tr>
			<s:fielderror name="invalidDatosPropiosAlta">
			</s:fielderror>
		</table>
	</fieldset>
	</s:div>
	</s:div>
	<s:div id="buttons">
	<table>
		<tr>
			<td>
				<s:hidden name="idDatosPropios" value="0"/>	
				<s:submit type="image" value="altaCliente" src='images/alta_b.gif'/>			
			</td>
			<td>
				<a href="<s:url action='home'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
			</td>
		</tr>
	</table>
	</s:div>
</s:form>
</s:if>
</s:div>

</body>
</html>