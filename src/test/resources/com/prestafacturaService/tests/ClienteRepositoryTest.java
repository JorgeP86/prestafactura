package com.prestafacturaService.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.dto.DetallesContacto;
import com.prestafacturaService.mongo.dto.Direccion;
import com.prestafacturaService.mongo.dto.DireccionEntrega;
import com.prestafacturaService.mongo.dto.EntidadLegal;
import com.prestafacturaService.mongo.dto.IdentificacionFiscal;
import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.repositories.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml","Test-applicationContext.xml"})
public class ClienteRepositoryTest {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Before
	public void setUp(){
		mongoTemplate.dropCollection("cliente");
		mongoTemplate.createCollection("cliente");
		
		IdentificacionFiscal idFiscal= new IdentificacionFiscal();
		idFiscal.setIdentificacionFiscal("123456789");
		
		Provincia provinciaCliente=new Provincia();
		provinciaCliente.setProvincia("Sevilla");
		
		Localidad localidadCliente=new Localidad();
		localidadCliente.setLocalidad("Cantillana");
		
		CodigoPais codigoPaisCliente=new CodigoPais();
		codigoPaisCliente.setCodigoPais("España");
		
		Direccion diCliente=new Direccion();
		diCliente.setTipodireccion("Dirección Cliente");
		diCliente.setCalle("calle");
		diCliente.setCalleAdicional("calleAdicional");
		diCliente.setCodigoPostal("100");
		diCliente.setDepartamento("lsi");
		diCliente.setNumeroEdificio("1");
		diCliente.setProvincia(provinciaCliente);
		diCliente.setLocalidad(localidadCliente);
		diCliente.setPostBox("1001");
		diCliente.setCodigoPais(codigoPaisCliente);
		
		//
		DetallesContacto dcCliente=new DetallesContacto();
		dcCliente.setDireccionWeb("www.maria.com");
		dcCliente.setFax("954884658");
		dcCliente.setMail("maria@gmail.com");
		dcCliente.setPersonaContacto("maria");
		dcCliente.setTelefono("954886359");
		
		///
		Provincia pEntrega=new Provincia();
		pEntrega.setProvincia("Sevilla");
		Localidad lEntrega=new Localidad();
		lEntrega.setLocalidad("Cantillana");
		
		
		CodigoPais cpaisEntrega= new CodigoPais();
		cpaisEntrega.setCodigoPais("España");
		
		Direccion diEntrega=new DireccionEntrega();
		diEntrega.setTipodireccion("Dirección Entrega");
		diEntrega.setCalle("calleEntrega");
		diEntrega.setCalleAdicional("calleAdicionalEntrega");
		diEntrega.setCodigoPostal("102");
		diEntrega.setDepartamento("departamentoEntrega");
		diEntrega.setNumeroEdificio("1");
		diEntrega.setProvincia(pEntrega);
		diEntrega.setLocalidad(lEntrega);
		diEntrega.setPostBox("1002");
		diEntrega.setCodigoPais(cpaisEntrega);
		
		///
		
		Provincia pEmpresa=new Provincia();
		pEmpresa.setProvincia("Sevilla");
		Localidad lEmpresa=new Localidad();
		lEmpresa.setLocalidad("Cantillana");
		
		CodigoPais cpaisEmpresa= new CodigoPais();
		cpaisEmpresa.setCodigoPais("España");
		
		Direccion direcccionELegal=new Direccion();
		direcccionELegal.setTipodireccion("Dirección Empresa");
		direcccionELegal.setCalle("calleEmpresa");
		direcccionELegal.setCalleAdicional("calleAdicionalEmpresa");
		direcccionELegal.setCodigoPostal("103");
		direcccionELegal.setDepartamento("departamentoEmpresa");
		direcccionELegal.setNumeroEdificio("3");
		direcccionELegal.setProvincia(pEmpresa);
		direcccionELegal.setLocalidad(lEmpresa);
		direcccionELegal.setPostBox("1003");
		direcccionELegal.setCodigoPais(cpaisEmpresa);
		//
		DetallesContacto dContactoEmpresa=new DetallesContacto();
		dContactoEmpresa.setDireccionWeb("direccionWebEmpresa");
		dContactoEmpresa.setFax("faxEmpresa");
		dContactoEmpresa.setMail("mailEmpresa");
		dContactoEmpresa.setPersonaContacto("personaContactoEmpresa");
		dContactoEmpresa.setTelefono("telefonoEmpresa");
		//
		EntidadLegal eLCliente=new EntidadLegal();
		eLCliente.setDatosRegistrales("datosRegistrales");
		eLCliente.setNombreComercial("nombreComercial");
		eLCliente.setRazonSocial("razonSocial");
		eLCliente.setDireccion(direcccionELegal);
		
		Cliente clienteNuevo= new Cliente();
			clienteNuevo.setNombre("nombreCliente");
			clienteNuevo.setApellido1("apellidoPCliente");
			clienteNuevo.setApellido2("apellidoSCliente");
			clienteNuevo.setIdentificacionFiscal(idFiscal);
			clienteNuevo.setDireccion(diCliente);
			clienteNuevo.setDirEntrega(diEntrega);
			clienteNuevo.setDetallesContacto(dcCliente);
			clienteNuevo.setEntidadLegal(eLCliente);
			clienteNuevo.setDirEntrega(diEntrega);
			
		
		Cliente alta=clienteRepository.save(clienteNuevo);
		
		
		
	}
	
	@Test
	public void test() {
		
		
	}
}
