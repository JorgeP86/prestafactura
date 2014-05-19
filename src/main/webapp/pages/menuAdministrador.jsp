<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
</head>
<body>
	<h3>Men&uacute; Administrador</h3>
	<hr/>
		<div id="cssmenu">
		<ul>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n de Usuarios</span></a>
				<ul>
					<li><a href="<s:url action='AltaUsuarioFormAction'/>"><span>Alta usuario</span></a></li>
					<li class="last"><a href="<s:url action='AccesoUsuarioAction'/>"><span>Usuarios</span></a></li>
				</ul></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n de Roles</span></a>
				<ul>
					<s:url action="AltaRolFormAction" var="altaRol">
						<s:param name="idRol" value="0"></s:param>
					</s:url>
					<li><a href="<s:property value='#altaRol'/>"><span>Alta rol</span></a></li>
					
					<li class="last"><a href="<s:url action='AccesoRolAction'/>"><span>Roles</span></a></li>
				</ul></li>
		</ul>
	</div>
</body>
</html>