<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src= "http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="<s:url value='/pages/js/menu_jquery.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/menu_comun.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/templatePrestafactura.css'/>"/>
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>

    <s:div id="header"><tiles:insertAttribute name="header"/></s:div>
	<s:div id="welcome"><tiles:insertAttribute name="welcome"/></s:div>
	<hr/>
	<s:div id="content">
	<table width="80%" border="0" cellspacing="0" cellpadding="0" id="tabla_menus">
		<tr>
			<td id="td_template_menu">
				<tiles:insertAttribute name="menuComun"/>
			</td>
			<td id="body">
				<tiles:insertAttribute name="body"/>
			</td>
		</tr>
	</table>
	</s:div>
	<s:div id="footer"><tiles:insertAttribute name="footer"/></s:div>
</body>
</body>
</html>