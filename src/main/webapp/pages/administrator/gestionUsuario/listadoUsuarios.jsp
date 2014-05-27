<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/listadoUsuariosRoles.css'/>"/>
<script language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></script>
<title>Prestafactura</title>
</head>

<script language='javascript'>
	
	function borrar(id) {
		if (confirm("Se eliminará el usuario seleccionado.¿Está seguro?")) {
			window.location.href = "/modificarUsuario.action?idUsuario=" + id;
		};
	};
</script>

<body>

	<%-------- BUSCAR USUARIOS ----------%>
<s:div id="busquedaUsuariosRoles">
	<table>
		<tr>
			<td valign="middle">Gesti&oacute;n de Usuario</td>
		</tr>
	</table>
	<s:form action="BusquedaUsuarioAction" namespace="/" method="post">
		<fieldset>
		<legend>B&uacute;squeda de Usuarios</legend>
		<table align="center">
			<tr>
				<td>
					<s:textfield name="nombreUsuario" label="Nombre Usuario" labelposition="left" size="20"/>
					<s:textfield name="rol" label="Nombre Rol del Usuario" labelposition="left" size="20"/>
				</td>
				<td align="right">
					<s:submit type="image" src="images/buscar.gif"/>
				</td>
			</tr>
		</table>
		</fieldset>
	</s:form>
</s:div>
	<%----------- LISTAR USUARIOS ------------%>

	<s:div id="listadoUsuariosRoles">
	<s:if test="%{#usuariosAcceso!=0}">
		<table id="table_listado">
			<tr style="background:#97c700">
				<td>Nombre del Usuario:</td>
				<td>Login:</td>
				<td>Departamento:</td>
				<td>Rol:</td>
				<td colspan="2"></td>
			</tr>
			<s:iterator value="usuariosAcceso" status="status" var="listaroles">
				<s:if test="#status.even==true">
				<tr style="background: #CCCCCC">
					<td><s:property value="%{nombre}"/></td>
					<td><s:property value="%{login}"/></td>
					<td><s:property value="%{departamento}"/></td>
					<td><s:property value="%{rol.nombre}"/>
					<td>		
						<s:url action="AltaUsuarioAction" var="ModificacionUsuario">
							<s:param name="idUsuario" value="0"></s:param>
						</s:url>
						<s:a href="<s:property value='#ModificacionUsuario'/>">
							<img alt="editarUsuario" src="<s:url value='/images/modificar_peq.jpg'/>" border="0" longdesc="Editar Usuario"/></s:a>
					</td>
					<td>
						<s:url action="ModificacionUsuarioAction" var="modificacionUsuario">
							<s:param name="nombreUsuarioSelect" value="%{nombre}"></s:param>
						</s:url>
						 
						<a href="<s:property value='#modificacionUsuario'/>">
							<img alt="borrarUsuario" src="<s:url value='/images/eliminar_peq.jpg'/>" border="0" longdesc="Eliminar Usuario"/>
						</a>
					</td>
				</tr>
				</s:if>
				<s:else>
				<tr>
					<td><s:property value="%{nombre}"/></td>
					<td><s:property value="%{login}"/></td>
					<td><s:property value="%{departamento}"/></td>
					<td><s:property value="%{rol.nombre}"/>
					<td>
						<s:url action="AltaUsuarioAction" var="ModificacionUsuario">
							<s:param name="idUsuario" value="0"></s:param>
						</s:url>
						<s:a href="<s:property value='#ModificacionUsuario'/>">
							<img alt="editarUsuario" src="<s:url value='/images/modificar_peq.jpg'/>" border="0" longdesc="Editar Usuario"/></s:a>
					</td>
					<td>
						<s:url action="ModificacionUsuarioAction" var="modificacionUsuario">
							<s:param name="nombreUsuarioSelect" value="%{nombre}"></s:param>
						</s:url>
						 
						<a href="<s:property value='#modificacionUsuario'/>">
							<img alt="borrarUsuario" src="<s:url value='/images/eliminar_peq.jpg'/>" border="0" longdesc="Eliminar Usuario"/>
						</a>
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
	<s:div id="enlace_altaUsuarioRol">
		<s:url action="AltaUsuarioFormAction" var="altaUsuarioForm">
			<s:param name="idRol" value="0" />
		</s:url> 
		<a href="<s:property value='#altaUsuarioForm'/>"> 
			<img alt="altaUsuario" src="<s:url value='/images/alta_b.gif'/>" width="93" height="32" border="0" longdesc="Crear nuevo Usuario" />
		</a>
	</s:div>
</body>
</html>