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
	<%---------- BUSCAR ROLES -----------%>

	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabla_lista">
		<tr>
			<td width="60%" valign="middle">Gesti&oacute;n de Roles</td>
		</tr>
	</table>
	<s:form action="busquedaRolAction" namespace="/" method="post">
		<table>
			<tr>
				<td colspan="8" bgcolor="" class="celda_gris2">B&uacute;squeda
					de Roles:</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="nombreRol" label="Nombre Rol" size="20" id="nombreRolBusqueda"/>
				</td>
				<td>
					<s:textfield name="descripcionRol" label="Descripcion Rol" size="30" id="descripcionRolBusqueda"/>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6" bgcolor="#DBE2EA" class="texto1">
				<br />
				<s:submit name="Buscar" type="image" src="<s:url value='/images/buscar.gif'/>"/>
				<s:url action="AltaRolAction" var="altaRol">
					<s:param name="idRol" value="0" />
				</s:url> 
				<a href="<s:property value='#altaRol'/>"> 
					<img alt="alta" src="<s:url value='/images/alta_b.gif'/>" width="93" height="32" border="0" longdesc="Crear nuevo Rol" />
				</a>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>

	</s:form>
	
	<%----------- LISTAR ROLES ------------%>

	<body>
	<s:if test="%{listaRoles.size!=0}"/>
			<table  border=0 width="90%" class="recuadro">
					<tr>
						<td>Nombre del Rol:</td>
						<td>Descripcion del Rol:</td>
						<td></td>
					</tr>
					<s:iterator value="roles" status="paginasStatus" var="listaroles">
						<tr>
							<td><s:property value="%{#listaroles.nombre}"/></td>
							<td><s:property value="%{#listaroles.descripcion}"/></td>
							<td>
							
								<s:url action="AltaRolAction" var="ModificacionRol">
									<s:param name="idRol" value="0"></s:param>
								</s:url>
								<s:a href="<s:property value='#ModificacionRol'/>">
									<img alt="editarRol" src="<s:url value='/images/modificar_peq.jpg'/>" width="93" height="32" border="0" longdesc="Editar Rol"/></s:a>
							</td>
							<td>
								<s:url action="ModificacionRolAction" var="ModificacionRol">
									<s:param name="idRol" value="0"></s:param>
								</s:url>
								<s:a href="<s:property value='#ModificacionRol'/>">
									<img alt="borrarRol" src="<s:url value='/images/eliminar_peq.jpg'/>" width="93" height="32" border="0" longdesc="Borrar Rol"/></s:a>
								
							</td>
						</tr>
		
				</s:iterator>
		</table>

</body>
</html>