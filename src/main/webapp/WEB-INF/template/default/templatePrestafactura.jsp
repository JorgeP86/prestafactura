<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>

    <tiles:insertAttribute name="header"/>
	<hr/>
	<table>
		<tr>
			<td>
				<s:div>Men&uacute; Gesti&oacute;n Facturas</s:div>
				<s:div><tiles:insertAttribute name="menuComun"/></s:div>
				<s:if test="usuario.getRol().getNombre==Administrador">
					<s:div>Men&uacute; Administrador</s:div>
					<s:div><tiles:insertAttribute name="menuAdministrador"/></s:div>
				</s:if>
			</td>
			<td><tiles:insertAttribute name="content"/></td>
		</tr>
		<tr>
			<tiles:insertAttribute name="footer"/>
		</tr>
	</table>
	

</body>
</html>