<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-jquery-grid-tags" prefix="sjg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript" src="<s:url value='/js/valida.js'/>"></script>
<title>Prestafactura</title>
</head>
<script language='javascript'>
	
	function borrar(id) {
		if (confirm("Se eliminará el rol seleccionado.¿Está seguro?")) {
			var param = encodeURI("<s:property value=''/>");
			window.location = ${};
			<%-- window.location.href = "/modificarRol.do?idRol=" + id;--%>
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
	<s:form action="busquedaRol" namespace="/" method="post">
		<table>
			<tr>
				<td colspan="8" bgcolor="" class="celda_gris2">B&uacute;squeda
					de Roles:</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><strong>Nombre:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" class="text01" name="nombre" size="30" maxlength="50" /></td>
				<td><strong>Descripci&oacute;n:</strong>&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" class="text01" name="descripcion" size="70"
					maxlength="80"></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6" bgcolor="#DBE2EA" class="texto1"><br /> <input
					name="submit" type="image"
					src="<s:url value='/WEB-INF/images/buscar.gif'/>" width="93"
					height="32" border="0" /> <s:url action="altaRol.action"
						var="altaRol">
						<s:param name="idRol" value="0" />
					</s:url> <a href="<s:property value='altaRol'/>"> <img alt="alta"
						src="<s:url value='/WEB-INF/image/altaRol.gif'/>" width="93"
						height="32" border="0" longdesc="Crear nuevo Rol" />
				</a></td>
				<td>&nbsp;</td>
			</tr>
		</table>

	</s:form>

	<%----------- LISTAR ROLES ------------%>

	<s:if test="!empty roles">
		<table width="95%" border="0" cellspacing="0" cellpadding="0"
			class="tabla">
			<tr>
				<td class="titListado">Se encontraron estos roles
					correspondientes al criterio de b&uacute;squeda :</td>
			</tr>
		</table>
		<sj:tabbedpanel id="tabRoles">
			<sj:tab id="tab1" target="one" label="ListadoRoles" />
			<sj:tab />
			<div id="one">
				<s:url action="accesoRolAction" var="rol" />
				<s:url action="gestionRol" var="editarRol">
					<s:param value="eliminarRol"/>
				</s:url>
				
				<sjg:grid gridModel="roles" 
						id="idRol"
						caption="roles alamcenados"
						href="%{accesoRolAction}"
						dataType="html"
						pager="true" 
						rowList="3,5,8" 
						rowNum="5"
						rownumbers="true">
					<sjg:gridColumn name="nombre" index="nombre" title="Nombre"
						formatter="string" sortable="true"></sjg:gridColumn>
					<sjg:gridColumn name="descripcion" index="descripcion"
						title="Descripcion"></sjg:gridColumn>
					<sjg:gridColumn name="editar" href="%{editarRol}"><img src="/WEB-INF/image/editar.gif" alt="editar" border="0" longdesc="Editar Roles"/></sjg:gridColumn>
					<sjg:gridColumn name="eliminar"><s:a href="javascript:borrar(idRol)"><img src="/WEB-INF/image/eliminar.gif"/></s:a></sjg:gridColumn>
				</sjg:grid>
			</div>
		</sj:tabbedpanel>
	</s:if>

</body>
</html>