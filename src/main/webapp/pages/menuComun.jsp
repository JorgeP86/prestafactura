<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<script src= "http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#cssmenu ul ul li:odd').addClass('odd');
			$('#cssmenu ul ul li:even').addClass('even');
			$('#cssmenu > ul > li > a').click(function() {
				$('#cssmenu li').removeClass('active');
				$(this).closest('li').addClass('active');
				var checkElement = $(this).next();
				if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
					$(this).closest('li').removeClass('active');
					checkElement.slideUp('normal');
				}
				if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
					$('#cssmenu ul ul:visible').slideUp('normal');
					checkElement.slideDown('normal');
				}
				if ($(this).closest('li').find('ul').children().length == 0) {
					return true;
				} else {
					return false;
				}
			});
		});
	</script>
	
	<link rel="stylesheet" type="text/css" href="/pages/css/menu_comun.css"/>
</head>
<body>
	<div id="cssmenu">
		<ul>
			<li class="active"><a href="/inicio.jsp"><span>Home</span></a></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n
						Factura</span></a>
				<ul>
					<li><a href="#"><span>Crear Factura</span></a></li>
					<li><a href="#"><span>Facturas recibidas</span></a></li>
					<li class="last"><a href="#"><span>Facturas
								enviadas</span></a></li>
				</ul></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n
						Clientes</span></a>
				<ul>
					<li><a href="#"><span>Alta cliente</span></a></li>
					<li class="last"><a href="#"><span>Cartera de
								clientes</span></a></li>
				</ul></li>
			<li class="has-sub"><a href="#"><span>Gesti&oacute;n
						Proveedores</span></a>
				<ul>
					<li><a href="#"><span>Alta Proveedor</span></a></li>
					<li class="last"><a href="#"><span>Proveedores</span></a></li>
				</ul></li>
				
			<li class="last"><a href="#"><span>Gesti&oacute;n de
						Datos Propios</span></a></li>

		</ul>
	</div>

</body>
</html>