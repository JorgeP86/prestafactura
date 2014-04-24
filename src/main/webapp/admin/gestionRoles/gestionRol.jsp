<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript" src="<s:url value='/js/valida.js'/>"></script>
<title>Prestafactura</title>
</head>
<script language='javascript'>
	function borrar(id){
		if(confirm("Se eliminará el rol seleccionado.¿Está seguro?")){
			
			window.location.href="./modificarRol.do?idRol="+id;
			}

	}
</script>
<body>
<%--BUSCAR ROLES --%>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabla_lista">
	<tr>
		<td width="60%" valign="middle">Gesti&oacute;n de Roles </td>
	</tr>
</table>
<s:form action="busquedaRol" namespace="/" method="post">
	<table>
		<tr>
			<td><strong>Nombre:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="text01" name="nombre" size="30" maxlength="50"/></td>
			<td><strong>Descripci&oacute;n:</strong>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="text01" name="descripcion" size="70" maxlength="80"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="6" bgcolor="#DBE2EA" class="texto1">
				<br/>
				<input name="submit" type="image" src="<s:a ">
			</td>
	</table>
</s:form>

</body>
</html>