<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></SCRIPT>
<title>Gesti&oacute;n Usuarios</title>
</head>
<script language='javascript'>
	
	function aceptar(){
			
			if(trim(document.getElementById('formulario').nombre.value)=="")
				
					alert('Debe rellenar el nombre del Rol.');
			else
					document.forms['fruser'].submit();			
	}

</script>
<body>

<s:if test="%{#session.usuario!= null}">
	<table>
		<tr>
			<td>Gesti&oacute;n de Usuarios</td>
		</tr>
	</table>
<s:form action="AltaUsuarioAction" name="fruser" namespace="/" method="post" styleId="formulario">
	
	<fieldset>
	<legend>Alta Nuevo Usuario</legend>
	<table border="1" width="90%">
		<tr>
			<td>
				<s:textfield name="nombre" label="Nombre Usuario" labelposition="left" size="20"/>
			</td>
			<td>
				<s:textfield name="apellido1" label="Primer Apellido" labelposition="left" size="20"/>
			</td>
			<td>
				<s:textfield name="apellido2" label="Segundo Apellido" labelposition="left" size="20"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="login" label="Login" labelposition="left" size="20"/>
			</td>
			<td>
				<s:password name="password" label="Password" labelposition="left" size="20"/>
			</td>
			<td>
				<s:password name="password2" label="Repetir Password" labelposition="left" size="20"/>
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="email" label="E-mail" labelposition="left" size="20"/>
			</td>
			<td>
				<s:textfield name="departamento" label="Departamento" labelposition="left" size="20"/>
			</td>
			
			<td colspan="1">
				<s:select label="Selecciona Rol" labelposition="left" headerKey="1"
  				headerValue="-- Please Select --" name="nombreRol" list="listRoles" listValue="%{nombre}" value="%{nombre}" listKey="%{nombre}" key="%{nombre}"/>
			</td>
			
		</tr>
		<tr></tr>	
	</table>
	</fieldset>
	

	<table>
		<tr>
			<td>
			
				<s:hidden name="idUsuario" value="0"></s:hidden>	
				<s:submit type="button" value="altaUsuario" src='/mages/alta_b.gif'/>			
			 </td>
			 <td>
			 	<a href="<s:url action='home'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
			 </td>
		</tr>
	</table>
	




</s:form>
</s:if>


</body>
</html>