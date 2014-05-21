<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Rol</title>
<SCRIPT language="JavaScript" src="<s:url value='/js/valida.js'/>"></SCRIPT>
</head>
<script language='javascript'>

	function aceptar(){
		if(trim(document.getElementById('formulario').nombre.value)=="")
			alert('Debe rellenar el nombre del Rol.');
		else
			document.getElementById('formulario').submit();			
	}
	
	function seguroModificar(){
		if(confirm('Se modificara el usuario ')){
			modifica();			
		}
	} 
	
	function modifica(){
		if(trim(document.getElementById('formulario').nombre.value)==""){
			alert('Debe rellenar el nombre del Rol.');
		}
		else{
			document.getElementById('formulario').id.value =<c:out value="${roledit.id}" />		
			document.getElementById('formulario').submit();
		}
	}
	

</script>
<body>
	<s:if test="!empty.usuario">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="tabla_lista">
			<tr>
				<td width="60%" valign="middle" class="cuer01"><span
					class="texto01">Gesti&oacute;n de Roles</span><span class="texto02"></span>
				</td>
			</tr>
		</table>
		<s:form action="altaRol" namesapace="/" method="post" styleId="formularion">
			<table width="99%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="tabla_lista3">
				<tr>
					<td colspan="6">Editar rol</td>
				</tr>
				<tr>
					<td colspan="2"><b>Nombre Rol *</b>&nbsp;&nbsp; <input
						name="nombreRol" type="text" class="text01" id="nombreRol"
						value="" size="30" /></td>
					<td>&nbsp;</td>
					<td colspan="2"><b>Descripdi&oacute;n</b>&nbsp;&nbsp; <input
						name="descripcionRol" type="text" class="text01"
						id="descripcionRol" value="" size="30" /></td>
				</tr>
			</table>
			<table width="99%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="tabla_lista3">
				<tr>
					<td width="25%" align="center" class="privTexto">GESTIÓN DE
						USUARIOS</td>
					<td width="25%" align="center" class="privTexto">GESTIÓN DE
						ROLES</td>
					<td width="25%" align="center" class="privTexto">GESTIÓN DE
						PROVEEDORES</td>
					<td width="25%" align="center" class="privTexto">GESTIÓN DE
						CLIENTES</td>
				</tr>
				<tr>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionUsuarios'">
									<input type="hidden" name="gestionUsuarios"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionUsuarios' && #pagina.path!='gestionUsuarios'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionRoles'">
									<input type="hidden" name="gestionRoles"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionRoles' && #pagina.path!='gestionRoles'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionProveedores'">
									<input type="hidden" name="gestionProveedores"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionProveedores' && #pagina.path!='gestionProveedores'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionClientes'">
									<input type="hidden" name="gestionClientes"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionClientes' && #pagina.path!='gestionClientes'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
				</tr>
				<tr>
					<td width="25%" align="center" class="privTexto">GESTIÓN DE
						DATOS INTERNOS</td>
					<td width="25%" align="center" class="privTexto">GESTIÓN
						FACTURA ALMACENADA</td>
					<td width="25%" align="center" class="privTexto">GESTIÓN DE
						INFORMACIÓN FACTURA</td>
					<td width="25%" align="center" class="privTexto">GESTIÓN FIRMA
						ELECTRONICA</td>
				</tr>
				<tr>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionDatosInterno'">
									<input type="hidden" name="gestionDatosInterno"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionDatosInterno' && #pagina.path!='gestionDatosInterno'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionFacturasAlmacenadas'">
									<input type="hidden" name="gestionFacturasAlmacenadas"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionFacturasAlmacenadas' && #pagina.path!='gestionFacturasAlmacenadas'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionInformacion'">
									<input type="hidden" name="gestionInformacion"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionInformacion' && #pagina.path!='gestionInformacion'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionFirmaElectronica'">
									<input type="hidden" name="gestionFirmaElectronica"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionFirmaElectronica' && #pagina.path!='gestionFirmaElectronica'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>

							</s:iterator>
						</table>
					</td>
				</tr>
				<tr>
					<td width="100%" align="center" class="privTexto">CREACIÓN
						FACTURA</td>
				</tr>
				<tr>
					<td>
						<table border=0 width="90%" class="recuadro">
							<s:iterator value="paginas" status="paginasStatus" var="pagina">
								<s:if test="#pagina.path != 'gestionFactura'">
									<input type="hidden" name="gestionFactura"
										value="#pagina.idpagina">
								</s:if>
								<s:if
									test="#pagina.ambito=='gestionFactura' && #pagina.path!='gestionFactura'">
									<tr>
										<td><s:checkbox name="#pagina.path"
												value="#pagina.idpagina" /></td>
										<td><s:property value="#pagina.descripcion" /></td>
									</tr>
								</s:if>
							</s:iterator>
						</table>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td><s:url value="javascript:aceptar()">
							<br>
							<img src='<s:a href="/WEB-INF/images/aceptar.gif"/>'
								alt="Aceptar" width="93" height="32" border="0"
								longdesc="Aceptar Usuario">
						</s:url></td>
					<td><a href="<s:url action='rol'/>"><img
							src="<s:a href='/WEB-INF/images/volver.gif'/>" alt="volver"
							width="93" height="32" border="0" longdesc="volver"></a></td>
				</tr>
			</table>
			<s:if test="idRol == 0">
				<s:hidden name="idRol" value="0" />
			</s:if>
			<s:if test="idRol > 0">
				<s:hidden name="idRol" value="#Rol.idRol" />
			</s:if>
		</s:form>
	</s:if>
</body>
</html>