<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error eliminar rol</title>
</head>
<body>
	<h2><strong>Error ELIMINANDO un rol</strong></h2>
	<br/>
	<b>El rol que desea eliminar está asociado a un usuario</b>
	<br/>
	<p><strong>Nota: Elimina el/los usuarios asociados a este rol antes</strong></p>
	
	<table align="right">
		<tr>
			<td>
				<a href="<s:url action='AccesoRolAction'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
			</td>
		</tr>
	</table>
</body>
</html>