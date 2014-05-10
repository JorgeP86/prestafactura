<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<table border="1" cellpadding="2" cellspacing="2" align="left">
	<tr>
		<td align="left"><h3><strong>Prestafactura</strong></h3></td>
		<td align="right">Bienvenido:<s:property value="username"/></td>
		<td><a href="<s:url action='LogoutAction'/>">Logout</a></td>
	</tr>
</table>
</html>