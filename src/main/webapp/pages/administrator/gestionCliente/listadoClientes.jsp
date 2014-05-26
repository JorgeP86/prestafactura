<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<body>
	<s:property value="id"/>
	<%---------- BUSCAR CLIENTES -----------%>

	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabla_lista">
		<tr>
			<td width="60%" valign="middle">Gesti&oacute;n de Clientes</td>
		</tr>
	</table>
	<s:form action="busquedaClienteAction" namespace="/" method="post">
		<table>
			<tr>
				<td colspan="8" bgcolor="" class="celda_gris2">B&uacute;squeda
					de Cliente:</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="idFiscal" label="Identificacion Fiscal" size="20" id="idFiscalBusqueda"/>
				</td>
				
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6" bgcolor="#DBE2EA" class="texto1">
				<br />
				<s:submit name="Buscar" type="image" src="<s:url value='/images/buscar.gif'/>"/>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>

	</s:form>
	
	<%----------- LISTAR ROLES ------------%>

	<body>
	<s:if test="%{listaClientes!=0}"/>
			<table  border=0 width="90%" class="recuadro">
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
					<s:iterator value="clientes" status="paginasStatus" var="listaClientes">
						<tr>
							<s:if test="%{#listaClientes.nombre!=null}">
							<td><s:property value="%{#listaClientes.identificacionFiscal}"/></td>
							<td><s:property value="%{#listaClientes.nombre}"/></td>
							<td><s:property value="%{#listaClientes.apellido1}"/></td>
							<td><s:property value="%{#listaClientes.apellido2}"/></td>
							</s:if>
							<s:if test="%{#listaClientes.nombreComercial!=null}">
							<td><s:property value="%{#listaClientes.identificacionFiscal}"/></td>
							<td><s:property value="%{#listaClientes.razonSocial}"/></td>
							<td><s:property value="%{#listaClientes.nombreComercial}"/></td>
							</s:if>
							<td>
							
								<s:url action="AltaClienteAction" var="ModificacionCliente">
									<s:param name="idCliente" value="0"></s:param>
								</s:url>
								<s:a href="<s:property value='#ModificacionCliente'/>">
									<img alt="editarCliente" src="<s:url value='/images/modificar_peq.jpg'/>" width="93" height="32" border="0" longdesc="Editar Cliente"/></s:a>
							</td>
							<td>
								<s:url action="ModificacionClienteAction" var="BorrarCliente">
									<s:param name="idCliente" value="0"></s:param>
								</s:url>
								<s:a href="<s:property value='#BorrarCliente'/>">
									<img alt="borrarCliente" src="<s:url value='/images/eliminar_peq.jpg'/>" width="93" height="32" border="0" longdesc="Borrar Cliente"/></s:a>
								
							</td>
						</tr>
		
				</s:iterator>
		</table>

</body>
</html>