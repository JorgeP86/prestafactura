<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<s:url value='/pages/css/listadoClientes.css'/>"/>
<script language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></script>
<title>Prestafactura</title>
</head>
<body>



<%----------- LISTAR CLIENTES ------------%>
		<div id="datospropiostitle">Datos Propios</div>
		<div id="datospropiostabla">
		<table title="Datos Propios">
			<tr style="background:#97c700">
				<td>Identificacion Fiscal:</td>
				<td>Nombre:</td>
				<td>Primer Apellido:</td>
				<td>Segundo Apellido:</td>
				<td>Provincia:</td>
				<td>Localidad:</td>
				<td>Razón Social:</td>
				<td>Nombre Comercial</td>
				<td colspan="2"></td>
			</tr>
				<tr>
					<td><s:property value="%{datosPropios.identificacionFiscal.identificacionFiscal}"/></td>
					<td><s:property value="%{datosPropios.nombre}"/></td>
					<td><s:property value="%{datosPropios.apellido1}"/></td>
					<td><s:property value="%{datosPropios.apellido2}"/></td>
					<td><s:property value="%{datosPropios.direccion.provincia.provincia}"/></td>
					<td><s:property value="%{datosPropios.direccion.localidad.localidad}"/></td>
					<td><s:property value="%{datosPropios.entidadLegal.razonSocial}"/></td>
					<td><s:property value="%{datosPropios.entidadLegal.nombreComercial}"/></td>
				
				<td>
						<s:url action="EliminarDatosPropiosAction" var="borrarDatos">
							<s:param name="identificacionFiscal" value="%{identificacionFiscal}"></s:param>
						</s:url>
						<s:a href="<s:property value='#borrarDatos'/>">
							<img alt="borrarDatos" src="<s:url value='/images/eliminar_peq.jpg'/>" border="0" longdesc="Borrar Datos"/>
						</s:a>
					</td>
				</tr>
			</table>
			</div>
			
</body>
</html>