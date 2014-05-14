package com.prestafacturaService.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.repositories.RecursoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml","Test-applicationContext.xml"})
public class RecursoRepositoryTest {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Before
	public void setUp(){
		Recurso altaUsuario = new Recurso();
		Recurso bajaUsuario = new Recurso();
		Recurso editarUsuario = new Recurso();
		Recurso consultarUsuario = new Recurso();
		Recurso listarUsuarios = new Recurso();
		
		Recurso altaRol = new Recurso();
		Recurso bajaRol = new Recurso();
		Recurso editarRol = new Recurso();
		Recurso consultarRol = new Recurso();
		Recurso listarRoles = new Recurso();
		
		Recurso altaCliente = new Recurso();
		Recurso bajaCliente = new Recurso();
		Recurso editarCliente = new Recurso();
		Recurso consultarCliente = new Recurso();
		Recurso listarClientes = new Recurso();
		
		Recurso altaProveedor = new Recurso();
		Recurso bajaProveedor = new Recurso();
		Recurso editarProveedor = new Recurso();
		Recurso consultarProveedor = new Recurso();
		Recurso listarProveedores = new Recurso();
		
		Recurso altaDatosInternos = new Recurso();
		Recurso editarDatosInternos = new Recurso();
		Recurso consultarDatosInternos = new Recurso();
		
		Recurso consultarInformacion = new Recurso();
		Recurso eliminarInformacion = new Recurso();
		Recurso publicarInformacion = new Recurso();
		
		Recurso consultarFacturaAlmacenada = new Recurso();
		Recurso descargarFacturaAlmacenada = new Recurso();
		
		Recurso generarFirmaElectronica = new Recurso();
		Recurso consultarFirmaElectronica = new Recurso();
		
		Recurso crearFactura = new Recurso();
		
		List<Recurso> recursos = new ArrayList<Recurso>();
		
		//GESTION USUARIOS
		
		altaUsuario.setIdpagina("1");
		altaUsuario.setPath("altaUsuario");
		altaUsuario.setDescripcion("Acceso a dar de Alta a Usuarios");
		altaUsuario.setAmbito("gestionUsuarios");
		
		bajaUsuario.setIdpagina("2");
		bajaUsuario.setPath("bajaUsuario");
		bajaUsuario.setDescripcion("Acceso a dar de Baja a Usuarios");
		bajaUsuario.setAmbito("gestionUsuarios");
		
		editarUsuario.setIdpagina("3");
		editarUsuario.setPath("editarUsuario");
		editarUsuario.setDescripcion("Acceso para editar Usuarios");
		editarUsuario.setAmbito("gestionUsuarios");
		
		consultarUsuario.setIdpagina("4");
		consultarUsuario.setPath("consultarUsuario");
		consultarUsuario.setDescripcion("Acceso para consultar Usuarios");
		consultarUsuario.setAmbito("gestionUsuarios");
		
		listarUsuarios.setIdpagina("5");
		listarUsuarios.setPath("listarUsuarios");
		listarUsuarios.setDescripcion("Acceso para listar Usuarios");
		listarUsuarios.setAmbito("gestionUsuarios");
		
		//GESTION FACTURA
		
		crearFactura.setIdpagina("6");
		crearFactura.setPath("crearFactura");
		crearFactura.setDescripcion("Acceso para crear Facturas");
		crearFactura.setAmbito("gestionFactura");
		
		//GESTION ROLES
		
		altaRol.setIdpagina("7");
		altaRol.setPath("altaRol");
		altaRol.setDescripcion("Acceso a dar de Alta Roles");
		altaRol.setAmbito("gestionRoles");

		bajaRol.setIdpagina("8");
		bajaRol.setPath("bajaRol");
		bajaRol.setDescripcion("Acceso a dar de Baja Roles");
		bajaRol.setAmbito("gestionRoles");
		
		editarRol.setIdpagina("9");
		editarRol.setPath("editarRol");
		editarRol.setDescripcion("Acceso para editar Roles");
		editarRol.setAmbito("gestionRoles");
		
		consultarRol.setIdpagina("10");
		consultarRol.setPath("consultarRol");
		consultarRol.setDescripcion("Acceso para consultar Roles");
		consultarRol.setAmbito("gestionRoles");
		
		listarRoles.setIdpagina("11");
		listarRoles.setPath("listarRoles");
		listarRoles.setDescripcion("Acceso para listar Roles");
		listarRoles.setAmbito("gestionRoles");
		
		//GESTION CLIENTES
		
		altaCliente.setIdpagina("12");
		altaCliente.setPath("altaCliente");
		altaCliente.setDescripcion("Acceso a dar de Alta Clientes");
		altaCliente.setAmbito("gestionClientes");
		
		bajaCliente.setIdpagina("13");
		bajaCliente.setPath("bajaClientes");
		bajaCliente.setDescripcion("Acceso a dar de Baja Clientes");
		bajaCliente.setAmbito("gestionClientes");
		
		editarCliente.setIdpagina("14");
		editarCliente.setPath("editarClientes");
		editarCliente.setDescripcion("Acceso para editar Clientes");
		editarCliente.setAmbito("gestionClientes");
		
		consultarCliente.setIdpagina("15");
		consultarCliente.setPath("consultarClientes");
		consultarCliente.setDescripcion("Acceso consultar Clientes");
		consultarCliente.setAmbito("gestionClientes");

		listarClientes.setIdpagina("16");
		listarClientes.setPath("listarClientes");
		listarClientes.setDescripcion("Acceso para listar Clientes");
		listarClientes.setAmbito("gestionClientes");
		
		//GESTION PROVEEDORES
		
		altaProveedor.setIdpagina("17");
		altaProveedor.setPath("altaProveedor");
		altaProveedor.setDescripcion("Acceso a dar de Alta Proveedores");
		altaProveedor.setAmbito("gestionProveedores");
		
		bajaProveedor.setIdpagina("18");
		bajaProveedor.setPath("bajaProveedor");
		bajaProveedor.setDescripcion("Acceso a dar de Baja Proveedores");
		bajaProveedor.setAmbito("gestionProveedores");
		
		editarProveedor.setIdpagina("19");
		editarProveedor.setPath("editarProveedor");
		editarProveedor.setDescripcion("Acceso para editar Proveedor");
		editarProveedor.setAmbito("gestionProveedores");
		
		consultarProveedor.setIdpagina("20");
		consultarProveedor.setPath("consultarProveedor");
		consultarProveedor.setDescripcion("Acceso consultar Proveedor");
		consultarProveedor.setAmbito("gestionProveedores");

		listarProveedores.setIdpagina("21");
		listarProveedores.setPath("listarProveedores");
		listarProveedores.setDescripcion("Acceso para listar Proveedores");
		listarProveedores.setAmbito("gestionProveedores");
		
		//GESTION DATOS INTERNOS
		
		altaDatosInternos.setIdpagina("22");
		altaDatosInternos.setPath("altaDatos");
		altaDatosInternos.setDescripcion("Acceso a dar de Alta Datos Internos");
		altaDatosInternos.setAmbito("gestionDatosInternos");
		
		editarDatosInternos.setIdpagina("23");
		editarDatosInternos.setPath("editarDatos");
		editarDatosInternos.setDescripcion("Acceso para editar Datos Internos");
		editarDatosInternos.setAmbito("gestionDatosInternos");
		
		consultarDatosInternos.setIdpagina("24");
		consultarDatosInternos.setPath("consultarDatos");
		consultarDatosInternos.setDescripcion("Acceso consultar Datos Internos");
		consultarDatosInternos.setAmbito("gestionDatosInternos");
		
		//GESTION INFORMACION FACTURA
		
		consultarInformacion.setIdpagina("25");
		consultarInformacion.setPath("consultarInformacion");
		consultarInformacion.setDescripcion("Acceso para consultar Informacion de Factura");
		consultarInformacion.setAmbito("gestionInformacion");
		
		eliminarInformacion.setIdpagina("26");
		eliminarInformacion.setPath("eliminarInformacion");
		eliminarInformacion.setDescripcion("Acceso eliminar Informacion");
		eliminarInformacion.setAmbito("gestionInformacion");
		
		publicarInformacion.setIdpagina("27");
		publicarInformacion.setPath("publicarInformacion");
		publicarInformacion.setDescripcion("Acceso para publicar Informacion");
		publicarInformacion.setAmbito("gestionInformacion");
		
		//GESTION FACTURAS ALMACENADAS
		
		consultarFacturaAlmacenada.setIdpagina("28");
		consultarFacturaAlmacenada.setPath("consultarFactura");
		consultarFacturaAlmacenada.setDescripcion("Acceso consultar Facturas Almacenadas");
		consultarFacturaAlmacenada.setAmbito("gestionFacturasAlmacenadas");

		descargarFacturaAlmacenada.setIdpagina("29");
		descargarFacturaAlmacenada.setPath("descargarFactura");
		descargarFacturaAlmacenada.setDescripcion("Acceso para descargar Facturas Almacenadas");
		descargarFacturaAlmacenada.setAmbito("gestionFacturasAlmacenadas");
		
		//GESTION FIRMA ELECTRONICA
		
		generarFirmaElectronica.setIdpagina("30");
		generarFirmaElectronica.setPath("generarFirmaElectronica");
		generarFirmaElectronica.setDescripcion("Acceso para Firmar Facturas");
		generarFirmaElectronica.setAmbito("gestionFirmaElectronica");
		
		consultarFirmaElectronica.setIdpagina("31");
		consultarFirmaElectronica.setPath("consultarFirmaElectronica");
		consultarFirmaElectronica.setDescripcion("Acceso para consultar Firma Electronica");
		consultarFirmaElectronica.setAmbito("gestionFirmaElectronica");
		
		recursos.add(altaUsuario);
		recursos.add(bajaUsuario);
		recursos.add(editarUsuario);
		recursos.add(consultarUsuario);
		recursos.add(listarUsuarios);
		recursos.add(altaRol);
		recursos.add(bajaRol);
		recursos.add(editarRol);
		recursos.add(consultarRol);
		recursos.add(listarRoles);
		recursos.add(altaCliente);
		recursos.add(bajaCliente);
		recursos.add(editarCliente);
		recursos.add(consultarCliente);
		recursos.add(listarClientes);
		recursos.add(altaProveedor);
		recursos.add(bajaProveedor);
		recursos.add(editarProveedor);
		recursos.add(consultarProveedor);
		recursos.add(listarProveedores);
		recursos.add(altaDatosInternos);
		recursos.add(editarDatosInternos);
		recursos.add(consultarDatosInternos);
		recursos.add(consultarInformacion);
		recursos.add(eliminarInformacion);
		recursos.add(publicarInformacion);
		recursos.add(consultarFacturaAlmacenada);
		recursos.add(descargarFacturaAlmacenada);
		recursos.add(generarFirmaElectronica);
		recursos.add(consultarFirmaElectronica);
		recursos.add(crearFactura);
		
		recursoRepository.save(recursos);
		
	}
	
	@Test
	public void test() {
		List<Recurso> recursos = recursoRepository.findAll();
		for(Recurso r:recursos){
			System.out.println(r.getPath());
		}
	}

}
