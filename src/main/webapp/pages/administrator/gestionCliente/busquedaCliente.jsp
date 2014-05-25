<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Clientes</title>
</head>
<body>
		<%-------- BUSCAR CLIENTES ----------%>

	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabla_lista">
		<tr>
			<td width="60%" valign="middle">Gesti&oacute;n de Clientes</td>
		</tr>
	</table>
	<s:form action="BusquedaClienteAction" namespace="/" method="post">
		<fieldset>
		<legend>B&uacute;squeda de Clientes</legend>
		<table align="center">
			<tr>
				<td width="60%">
					<s:textfield name="idFiscal" label="Identificacion Fiscal" size="20" id="idFiscalBusqueda"/>
				</td>
				<td align="right">
					<s:submit type="image" src="images/buscar.gif"/>
				</td>
			</tr>
		</table>
		</fieldset>
	</s:form>
	
	<%----------- LISTAR ROLES ------------%>
	
	
	<s:div id="listadoRoles">
	<s:if test="%{rolBusqueda!=null}">
		<table  border="1" width="90%" class="recuadro">
			<tr>
						<td>Identificacion Fiscal Cliente:</td>
						<td>Nombre Cliente:</td>
						<td>Primer Apellido Cliente:</td>
						<td>Segundo Apellido Cliente:</td>
						
						<td>Identificacion Fiscal Empresa:</td>
						<td>Razón Social:</td>
						<td>Nombre de la Empresa:</td>
						
						<td></td>
					</tr>
					<tr>
							<s:if test="%{rolBusqueda.nombre!=null}">
							<td><s:property value="%{rolBusqueda.identificacionFiscal}"/></td>
							<td><s:property value="%{rolBusqueda.nombre}"/></td>
							<td><s:property value="%{rolBusqueda.apellido1}"/></td>
							<td><s:property value="%{rolBusqueda.apellido2}"/></td>
							</s:if>
							<s:if test="%{rolBusqueda.nombreComercial!=null}">
							<td><s:property value="%{rolBusqueda.identificacionFiscal}"/></td>
							<td><s:property value="%{rolBusqueda.razonSocial}"/></td>
							<td><s:property value="%{rolBusqueda.nombreComercial}"/></td>
							</s:if>
							<td>
					<s:url action="AltaClienteAction" var="ModificacionCliente">
						<s:param name="idCliente" value="0"></s:param>
					</s:url>
					<s:a href="<s:property value='#ModificacionCliente'/>">
						<img alt="editarCliente" src="<s:url value='/images/modificar_peq.jpg'/>" border="0" longdesc="Editar Cliente"/>
					</s:a>
				</td>
				<td>
					<s:url action="ModificacionClienteAction" var="borrarCliente">
						<s:param name="nombreRolSelect" value="%{nombre}"></s:param>
					</s:url>
					<a href="<s:property value='borrarCliente'/>">
						<img alt="borrarCliente" src="<s:url value='/images/eliminar_peq.jpg'/>" border="0" longdesc="Borrar Cliente"/>
					</a>
				</td>
			</tr>
		</table>
	</s:if>
	<s:else>
		<div class="errors">
    		<s:fielderror name="FalloBusquedaRoles"/>
   		</div>
	</s:else>
	</s:div>
	<s:div id="enlace_altaRol">
		<s:url action="AltaRolFormAction" var="altaRolForm">
			<s:param name="idRol" value="0" />
		</s:url> 
		<a href="<s:property value='#altaRolForm'/>"> 
			<img alt="alta" src="<s:url value='/images/alta_b.gif'/>" width="93" height="32" border="0" longdesc="Crear nuevo Rol" />
		</a>
	</s:div>
	<s:div>
		<table>
			<tr><td><a href="<s:url action='AccesoRolAction'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a></td></tr>
		</table>
	</s:div>
</body>
</html>