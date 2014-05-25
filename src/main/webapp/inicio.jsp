<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/login.css'/>"/>
<title>Login</title>
</head>
<body>
	<s:div id="login_div">
		<s:fielderror name="invalid"></s:fielderror>
		<s:form action="LoginAction" namespace="/" method="post">
		<fieldset>
			<legend align="left" id="legend">Prestafactura</legend>
		<table border="0" id="login_table">
		<tr>
			<td>
			<s:textfield name="username" requiered="true" label="User" labelposition="left" cssClass="usernameClass"/>
			</td>
		</tr>
		<tr>
			<td>
			<s:password name="password" requiered="true" label="Password" labelposition="left" cssClass="passwordClass"/>
			</td>
		</tr>
		<tr>
			<td align="right">
				<s:submit type="image" src="images/entrar_login.gif"/>
			</td>
		</tr>
		</table>
		</fieldset>
		</s:form>
		
	</s:div>
</body>
</html>