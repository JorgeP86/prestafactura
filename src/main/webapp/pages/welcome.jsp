<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
	<table width="100%" border="0" id="table_welcome" align="right">
		<tr>
			<td align="right">Bienvenido:<s:property value="%{#session.usuario.getLogin()}"/></td>
			<td><a href="<s:url action='LogoutAction'/>">Logout</a></td>
		</tr>
	</table>
</body>
