<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT language="JavaScript" src="<s:url value='/pages/js/valida.js'/>"></SCRIPT>
<title>Gesti&oacute;n Roles</title>
</head>
<script language='javascript'>
	
	function aceptar(){
			
			if(trim(document.getElementById('formulario').nombre.value)=="")
				
					alert('Debe rellenar el nombre del Rol.');
			else
					document.forms['frm'].submit();			
	}

</script>
<body>
<s:if test="%{#session.usuario != null}">
	<table>
		<tr>
			<td>Gesti&oacute;n de Roles</td>
		</tr>
	</table>
<%-- 
	<s:url action="AltaRolAction" var="alta">
		<s:param name="idRol" value="0"></s:param>
	</s:url>--%>

<s:form action="AltaRolAction" name="frm" namespace="/" method="post" id="altaRol">

	<fieldset>
	<legend>Alta nuevo Rol</legend>
	<table width="90%">
		<tr>
			<td colspan="2">
				<s:textfield name="nombreRol" label="Nombre Rol*" value="" size="30" id="nombreRol"/>
			</td>
			<td>&nbsp;</td>
			<td colspan="2">
				<s:textfield name="descripcionRol" label="Descripción rol*" value="" size="30" id="descripcionRol"/>
			</td>
		</tr>

	</table>
	<s:div>
		<s:fielderror name="invalidRolAlta">
		</s:fielderror>
	</s:div>
	</fieldset>

	<table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0"  class="tabla_lista3">
		<tr>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N DE USUARIOS</td>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N DE ROLES</td>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N DE PROVEEDORES</td>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N DE CLIENTES</td>
		</tr>
		<tr>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
						<%--
						<s:if test="%{#recurso.path == 'gestionUsuarios'}">
							<s:hidden key="gestionUsuarios" value="%{recurso.idpagina}"/>  
						</s:if>
						 --%>	
						<s:if test="%{#recurso.ambito=='gestionUsuarios' && #recurso.path!='gestionUsuarios'}">
							<tr>
								<td><s:property value="%{#recurso.idpagina}"/></td>
								<td><s:checkbox name="%{#recurso.path}" value="#recurso.idpagina"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionRoles'}">
							<s:hidden key="gestionRoles" value="%{#recurso.idpagina}"/>
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionRoles' && #recurso.path!='gestionRoles'}">
							<tr>
								<td><s:property value="%{#recurso.idpagina}"/></td>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionProveedores'}">
							<s:hidden key="gestionProveedores" value="%{#recurso.idpagina}"/>
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionProveedores' && #recurso.path!='gestionProveedores'}">
							<tr>
								<td><s:property value="%{#recurso.idpagina}"/></td>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionClientes'}">
							<s:hidden key="gestionClientes" value="%{#recurso.idpagina}"/>
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionClientes' && #recurso.path!='gestionClientes'}">
							<tr>
								<td><s:property value="%{#recurso.idpagina}"/></td>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N DE DATOS INTERNOS</td>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N FACTURAS ALMACENADAS</td>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N DE INFORMACI&Oacute;N FACTURA</td>
			<td  width="25%" align="center" class="privTexto">GESTI&Oacute;N FIRMA ELECTR&Oacute;NICA</td>
		</tr>
		<tr>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionDatosInternos'}">
							<s:hidden key="gestionDatosInternos" value="%{#recurso.idpagina}"/>  
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionDatosInternos' && #recurso.path!='gestionDatosInternos'}">
							<tr>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionFacturasAlmacenadas'}">
							<s:hidden key="gestionFacturasAlmacenadas" value="%{#recurso.idpagina}"/>
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionFacturasAlmacenadas' && #recurso.path!='gestionFacturasAlmacenadas'}">
							<tr>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionInformacion'}">
							<s:hidden key="gestionInformacion" value="%{#recurso.idpagina}"/>  
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionInformacion' && #recurso.path!='gestionInformacion'}">
							<tr>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#recurso.path == 'gestionFirmaElectronica'}">
							<s:hidden key="gestionFirmaElectronica" value="%{#recurso.idpagina}"/>  
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionFirmaElectronica' && #recurso.path!='gestionFirmaElectronica'}">
							<tr>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
						
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td  width="100%" align="center" class="privTexto">CREACI&Oacute;N FACTURA</td>
		</tr>
		<tr>
			<td>
				<table  border=0 width="90%" class="recuadro">
					<s:iterator value="recursos" status="paginasStatus" var="recurso">
					<%--
						<s:if test="%{#pagina.path == 'gestionFactura'}">
							<s:hidden key="gestionFactura" value="%{#recurso.idpagina}"/>  
						</s:if>
					--%>	
						<s:if test="%{#recurso.ambito=='gestionFactura' && #recurso.path!='gestionFactura'}">
							<tr>
								<td><s:checkbox name="%{#recurso.path}" value="%{#recurso.idpagina}"/></td>
								<td><s:property value="%{#recurso.descripcion}"/></td>
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<%--<s:hidden name="idRol" value="0"></s:hidden>	--%>	
				<s:submit type="button" value="altaRol"/>
			</td>
			  
			 <td>
			 	<a href="<s:url action='home'/>"><img alt="volver" src="<s:url value='/images/volver.gif'/>" width="93" height="32" border="0" longdesc="volver"/></a>
			 </td>
		</tr>
	</table>
	<%--
	<s:if test="idRol == 0">
		<s:hidden name="idRol" value="0"/>
	</s:if>
	<s:if test="idRol > 0">
		<s:hidden name="idRol" value="#Rol.idRol"/>
	</s:if>
	 --%>
	
	</s:form>

</s:if>
</body>
</html>