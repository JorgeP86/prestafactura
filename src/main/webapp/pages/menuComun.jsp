<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
</head>
<body>
	<s:div><h3>Men&uacute;</h3></s:div>
	<hr>
	<div id="cssmenu">
		<ul>
			<li class="active"><a href="<s:url action='home'/>"><span>Home</span></a></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n
						Factura</span></a>
				<ul>
					<li><a href="<s:url action='CrearFacturaAction'/>"><span>Crear Factura</span></a></li>
					<li><a href="<s:url action='FacturasRecibidasAction'/>"><span>Facturas recibidas</span></a></li>
					<li class="last"><a href="<s:url action='FacturasEnviadasAction'/>"><span>Facturas
								enviadas</span></a></li>
				</ul></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n
						Clientes</span></a>
				<ul>
				
				<s:url action="AltaClienteFormAction" var="altaCliente">
						<s:param name="idCliente" value="0"></s:param>
					</s:url>
					<li><a href="<s:property value='#altaCliente'/>"><span>Alta Cliente</span></a></li>
					<li class="last"><a href="<s:url action='AccesoClientesAction'/>"><span>Cartera de
								clientes</span></a></li>
				</ul></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n
						Proveedores</span></a>
				<ul>
					<li><a href="<s:url action='AltaProveedorAction'/>"><span>Alta Proveedor</span></a></li>
					<li class="last"><a href="<s:url action='AccesoProveedorAction'/>"><span>Proveedores</span></a></li>
				</ul></li>
				
			<li class="last"><a href="<s:url action='AccesoGestionDatosPropios'/>"><span>Gesti&oacute;n de
						Datos Propios</span></a></li>
		</ul>
	</div>

</body>
</html>