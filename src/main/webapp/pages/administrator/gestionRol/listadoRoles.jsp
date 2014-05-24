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

<script language='javascript'>
	
	function borrar(id) {
		if (confirm("Se eliminará el rol seleccionado.¿Está seguro?")) {
			window.location.href = "/modificarRol.action?idRol=" + id;
		};
	};
</script>

<body>

	<%-------- BUSCAR ROLES ----------%>

	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="tabla_lista">
		<tr>
			<td width="60%" valign="middle">Gesti&oacute;n de Roles</td>
		</tr>
	</table>
	<s:form action="busquedaRolAction" namespace="/" method="post">
		<fieldset>
		<legend>B&uacute;squeda de Roles</legend>
		<table align="center">
			<tr>
				<td width="60%">
					<s:textfield name="nombreRol" label="Nombre Rol" size="20" id="nombreRolBusqueda"/>
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
	<s:if test="%{#roles!=0}">
			<table  border="1" width="90%" class="recuadro">
					<tr>
						<td>Nombre del Rol:</td>
						<td>Descripcion del Rol:</td>
						<td colspan="2"></td>
					</tr>
					<s:iterator value="roles" status="paginasStatus" var="listaroles">
						<tr>
							<td><s:property value="%{nombre}"/></td>
							<td><s:property value="%{descripcion}"/></td>
							<td>
							
								<s:url action="AltaRolAction" var="ModificacionRol">
									<s:param name="idRol" value="0"></s:param>
								</s:url>
								<s:a href="<s:property value='#ModificacionRol'/>">
									<img alt="editarRol" src="<s:url value='/images/modificar_peq.jpg'/>" border="0" longdesc="Editar Rol"/></s:a>
							</td>
							<td>
								
								<s:url action="ModificacionRolAction" var="modificacionRol">
									<s:param name="nombreRolSelect" value="%{nombre}"></s:param>
								</s:url>
								 
								<a href="<s:property value='#modificacionRol'/>">
									<img alt="borrarRol" src="<s:url value='/images/eliminar_peq.jpg'/>" border="0" longdesc="Borrar Rol"/>
								</a>
								
							</td>
						</tr>
				</s:iterator>
			</table>
			<s:if test="hasActionErrors()">
   				<div class="errors">
      				<s:actionerror/>
   				</div>
			</s:if>
		</s:if>
	</s:div>
	<s:div id="enlace_altaRol">
		<s:url action="AltaRolFormAction" var="altaRolForm">
			<s:param name="idRol" value="0" />
		</s:url> 
		<a href="<s:property value='#altaRolForm'/>"> 
			<img alt="alta" src="<s:url value='/images/alta_b.gif'/>" width="93" height="32" border="0" longdesc="Crear nuevo Rol" />
		</a>
	</s:div>
</body>
</html>