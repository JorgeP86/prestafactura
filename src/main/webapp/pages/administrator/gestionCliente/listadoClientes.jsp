<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/listadoClientes.css'/>"/>
<script language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></script>
<title>Prestafactura</title>
</head>
<%----------
<script language='javascript'>
	
	function borrar(id) {
		if (confirm("Se eliminará el rol seleccionado.¿Está seguro?")) {
			window.location.href = "/modificarRol.action?idRol=" + id;
		};
	};
</script>
--%>
<body>

	<%---------- BUSCAR CLIENTES -----------%>
<s:div id="busquedaCliente">
	<table>
		<tr>
			<td id="title">Gesti&oacute;n de Clientes</td>
		</tr>
	</table>
	<s:form action="busquedaClienteAction" namespace="/" method="post">
		<fieldset>
		<legend>B&uacute;squeda de Clientes</legend>
		<table>
			<tr>
				<td>
					<s:textfield name="clienteBusqueda" label="Nombre Cliente" labelposition="left" size="20" id="clienteInput"/>
					<s:textfield name="idFiscal" label="Identificacion Fiscal" labelposition="left" size="10" id="identFiscalInput"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<s:submit name="Buscar" type="image" src="images/buscar.gif"/>
				</td>
			</tr>
		</table>
		</fieldset>
	</s:form>
</s:div>
	<%----------- LISTAR CLIENTES ------------%>

<s:div id="listadoClientes">
	<s:if test="%{#listaClientes!=0}">
		<table id="table_listado">
			<tr style="background:#97c700">
				<td>Identificacion Fiscal:</td>
				<td>Nombre:</td>
				<td>Primer Apellido:</td>
				<td>Segundo Apellido:</td>
				<td>Provincia:</td>
				<td>Localidad:</td>
				<td>Razón Social:</td>
				<td>Nombre Comercial</td>
				<td colspan="2"></td>
			</tr>
			<s:iterator value="listaClientes" status="status" var="cliente">
				<s:if test="#status.even==true">
				<tr style="background: #CCCCCC">
					<s:bean name="idG"></s:bean>
					<td><s:property value="%{identificacionFiscal.identificacionFiscal}"/></td>
					<td><s:property value="%{nombre}"/></td>
					<td><s:property value="%{apellido1}"/></td>
					<td><s:property value="%{apellido2}"/></td>
					<td><s:property value="%{#cliente.direccion.provincia.provincia}"/></td>
					<td><s:property value="%{#cliente.direccion.localidad.localidad}"/></td>
					<td><s:property value="%{#cliente.entidadLegal.razonSocial}"/></td>
					<td><s:property value="%{#cliente.entidadLegal.nombreComercial}"/></td>
					<td>
						<s:url action="AltaClienteAction" var="editarCliente">
							<s:param name="idCliente" value="1"></s:param>
						</s:url>
						<s:a href="<s:property value='#editarCliente'/>">
							<img alt="editarCliente" src="<s:url value='/images/modificar_peq.jpg'/>" width="93" height="32" border="0" longdesc="Editar Cliente"/></s:a>
					</td>
					<td>
						<s:url action="ModificacionClienteAction" var="BorrarCliente">
							<s:param name="idCliente" value="0"></s:param>
						</s:url>
						<s:a href="<s:property value='#BorrarCliente'/>">
							<img alt="borrarCliente" src="<s:url value='/images/eliminar_peq.jpg'/>" width="93" height="32" border="0" longdesc="Borrar Cliente"/>
						</s:a>
					</td>
				</tr>
				</s:if>
				<s:else>
				<tr>
					<td><s:property value="%{identificacionFiscal.identificacionFiscal}"/></td>
					<td><s:property value="%{nombre}"/></td>
					<td><s:property value="%{apellido1}"/></td>
					<td><s:property value="%{apellido2}"/></td>
					<td><s:property value="%{#cliente.direccion.provincia.provincia}"/></td>
					<td><s:property value="%{#cliente.direccion.localidad.localidad}"/></td>
					<td><s:property value="%{#cliente.entidadLegal.razonSocial}"/></td>
					<td><s:property value="%{#cliente.entidadLegal.nombreComercial}"/></td>
					<td>
						<s:url action="AltaClienteAction" var="editarCliente">
							<s:param name="idCliente" value="1"></s:param>
						</s:url>
						<s:a href="<s:property value='#editarCliente'/>">
							<img alt="editarCliente" src="<s:url value='/images/modificar_peq.jpg'/>" border="0" longdesc="Editar Cliente"/></s:a>
					</td>
					<td>
						<s:url action="ModificacionClienteAction" var="BorrarCliente">
							<s:param name="idCliente" value="0"></s:param>
						</s:url>
						<s:a href="<s:property value='#BorrarCliente'/>">
							<img alt="borrarCliente" src="<s:url value='/images/eliminar_peq.jpg'/>" border="0" longdesc="Borrar Cliente"/>
						</s:a>
					</td>
				</tr>
				</s:else>
			</s:iterator>
		</table>
		<s:if test="hasActionErrors()">
   			<div class="errors">
      			<s:actionerror/>
   			</div>
		</s:if>
	</s:if>
</s:div>
<s:div id="enlace_altaCliente">
	<s:url action="AltaClienteAction" var="altaClienteForm">
		<s:param name="idRol" value="0" />
	</s:url> 
	<a href="<s:property value='#altaClienteForm'/>"> 
		<img alt="altaCliente" src="<s:url value='/images/alta_b.gif'/>" width="93" height="32" border="0" longdesc="Crear nuevo Cliente" />
	</a>
	<a href="<s:url action='home'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
</s:div>
</body>
</html>