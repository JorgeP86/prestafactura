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
<body>

<s:if test="%{#session.usuario!= null}">
	<table>
		<tr>
			<td>Gesti&oacute;n de Roles</td>
		</tr>
	</table>
<s:form action="AltaRolAction" namespace="/" method="post" styleId="formulario">
	<fieldset>
	<legend>Alta Nuevo Cliente</legend>
	<table width="90%">
		<tr>
			<td colspan="1">
				<s:textfield name="nombreCliente" label="Nombre Cliente:"  size="30" id="nombreCliente"/>
			</td>
			<td colspan="1">
				<s:textfield name="apellidoPCliente" label="Primer Apellido:"  size="30" id="apellidoPCliente"/>
			</td>
			<td colspan="1">
				<s:textfield name="apellidoSCliente" label="Segundo Apellido:"  size="30" id="apellidoSCliente"/>
			</td>
			<td colspan="1">
				<s:textfield name="identificacionFiscal" label="Identificación Fiscal:"  size="30" id="identificacionFiscal"/>
			</td>
		</tr>
		<tr>
			<td>Direccion:</td>
			<td colspan="1">
				<s:textfield name="calle" label="Domicilio:"  size="30" id="calle"/>
			</td>
			<td colspan="1">
				<s:textfield name="numeroEdificio" label="Numero Edificio:"  size="30" id="numeroEdificio"/>
			</td>
			<td colspan="1">
				<s:textfield name="departamento" label="Departamento:"  size="30" id="departamento"/>
			</td>
		</tr>
			<tr>
			<td colspan="1">
				<s:textfield name="Provincia:" label="Provincia:"  id="provincia"/>
			</td>
			<td colspan="1">
				<s:textfield name="Localidad" label="Localidad:"   id="localidad"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPostal" label="Codigo Postal:"  size="30"  id="codigoPostal"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPais" label="Pais:"   id="codigoPais"/>
			</td>
			<td colspan="1">
				<s:textfield name="posbox" label="Posbox:"  size="30"  id="posbox"/>
			</td>
			<td colspan="1">
				<s:textfield name="calleAdicional" label="Calle Adicional:"  size="30"  id="calleAdicional"/>
			</td>
		</tr>
		
		
			<tr>
			<td>Direccion de Entrega:</td>
			<td colspan="1">
				<s:textfield name="calleEntrega" label="Domicilio:"  size="30" id="calleEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="numeroEdificioEntrega" label="Numero Edificio:"  size="30" id="numeroEdificioEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="departamentoEntrega" label="Departamento:"  size="30" id="departamentoEntrega"/>
			</td>
			</tr>
			<tr>
			<td colspan="1">
				<s:textfield name="provinciaEntrega" label="Provincia:"  id="provinciaEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="localidadEntrega" label="Localidad:"   id="localidadEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield label="Codigo Postal:"  size="30"  id="codigoPostalEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPaisEntrega" label="Pais:"   id="codigoPaisEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="posboxEntrega" label="Posbox:"  size="30"  id="posboxEntrega"/>
			</td>
			<td colspan="1">
				<s:textfield name="calleAdicionalEntrega" label="Calle Adiciona:"  size="30"  id="calleAdicionalEntrega"/>
			</td>
		</tr>
		<tr>
			<td>Detalles de Contacto del Cliente:</td>
			<td colspan="1">
				<s:textfield name="personaContacto" label="Persona de Contacto:"  size="30"  id="personaContacto"/>
			</td>
			<td colspan="1">
				<s:textfield name="telefono" label="Teléfono:"  size="30"  id="telefono"/>
			</td>
			<td colspan="1">
				<s:textfield name="mail" label="E-mail:"  size="30"  id="mail"/>
			</td>
			<td colspan="1">
				<s:textfield name="fax" label="fax:"  size="30"  id="fax"/>
			</td>
			<td colspan="1">
				<s:textfield name="direccionWeb" label="Dirección Web:"  size="30"  id="direccionWeb"/>
			</td>
		</tr>
		<tr>
			<td>Entidad Legal</td>
			<td colspan="1">
				<s:textfield name="razonSocial" label="Raón Social:"  size="30"  id="razonSocial"/>
			</td>
			<td colspan="1">
				<s:textfield name="nombreComercial" label="Nombre Comercial:"  size="30"  id="nombreComercial"/>
			</td>
			<td colspan="1">
				<s:textfield name="datosRegistrales" label="Datos Registrales:"  size="30"  id="datosRegistrales"/>
			</td>
		</tr>
		<tr>
			<td>Direccion de la Empresa</td>
			<td colspan="1">
				<s:textfield name="calleEmpresa" label="Domicilio:"  size="30" id="calleEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="numeroEdificioEmpresa" label="Numero Edificio:"  size="30" id="numeroEdificioEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="departamentoEmpresa" label="Departamento:"  size="30" id="departamentoEmpresa"/>
			</td>
		</tr>
			<tr>
			<td colspan="1">
				<s:textfield name="provinciaEmpresa" label="Provincia:"  id="provinciaEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="localidadEmpresa" label="Localidad:"   id="localidadEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPostalEmpresa" label="Codigo Postal:"  size="30"  id="codigoPostalEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="codigoPaisEmpresa" label="Pais:"   id="codigoPaisEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="posboxEmpresa" label="Posbox:"  size="30"  id="posboxEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="calleAdicionalEmpresa" label="Calle Adiciona:"  size="30"  id="calleAdicionalEmpresa"/>
			</td>
		</tr>
		<tr>
			<td>Detalles de Contacto de la Empresa:</td>
			<td colspan="1">
				<s:textfield name="personaContactoEmpresa" label="Persona de Contacto:"  size="30"  id="personaContactoEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="telefonoEmpresa" label="Teléfono:"  size="30"  id="telefonoEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="mailEmpresa" label="E-mail:"  size="30"  id="mailEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="faxEmpresa" label="fax:"  size="30"  id="faxEmpresa"/>
			</td>
			<td colspan="1">
				<s:textfield name="direccionWebEmpresa" label="Dirección Web:"  size="30"  id="direccionWebEmpresa"/>
			</td>	
			</tr>
	</table>
	<s:div>
		<s:fielderror name="invalidClienteAlta">
		</s:fielderror>
	</s:div>
	</fieldset>	
	
	<table>
		<tr>
			<td>
				<s:url action="AltaClienteAction" var="altaCliente">
					<s:param name="idCliente" value="0"></s:param>
				</s:url>
				<s:submit action="%{#altaCliente}" type="image" src="/images/alta_b.gif">
				
				</s:submit>
				<a href="<s:property value='#altaCliente'/>">			
				<img alt="alta" src="<s:url value='/images/alta_b.gif'/>" width="93" height="32" border="0" longdesc="Alta"/></a>
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