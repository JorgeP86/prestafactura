<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
    <s:div id="header"><tiles:insertAttribute name="header"/></s:div>
	<s:div id="welcome"><tiles:insertAttribute name="welcome"/></s:div>
	<hr/>
	<s:div id="body"><tiles:insertAttribute name="body"/></s:div>
	<s:div id="footer"><tiles:insertAttribute name="footer"/></s:div>
</body>
</html>