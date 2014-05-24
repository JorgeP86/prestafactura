package com.prestafacturaService.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.repositories.CodigoPaisRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml","Test-applicationContext.xml"})
public class CodigoPaisRepositoryTest {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CodigoPaisRepository codigoPaisRepository;
	
	@Before
	public void setUp(){
	mongoTemplate.dropCollection("codigoPais");
	mongoTemplate.createCollection("codigoPais");
	
	String[] nombresPais={"Afganist�n", "Akrotiri", "Albania", "Alemania", "Andorra", "Angola", "Anguila", "Ant�rtida", "Antigua y Barbuda", "Antillas Neerlandesas", "Arabia Saud�", "Arctic Ocean", "Argelia", "Argentina", "Armenia", "Aruba", "Ashmore andCartier Islands", "Atlantic Ocean", "Australia", "Austria", "Azerbaiy�n", "Bahamas", "Bahr�in", "Bangladesh", "Barbados", "B�lgica", "Belice", "Ben�n", "Bermudas", "Bielorrusia", "Birmania Myanmar", "Bolivia", "Bosnia y Hercegovina", "Botsuana", "Brasil", "Brun�i", "Bulgaria", "Burkina Faso", "Burundi", "But�n", "Cabo Verde", "Camboya", "Camer�n", "Canad�", "Chad", "Chile", "China", "Chipre", "Clipperton Island", "Colombia", "Comoras", "Congo", "Coral Sea Islands", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dhekelia", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "El Vaticano", "Emiratos �rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa�a", "Estados Unidos", "Estonia", "Etiop�a", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab�n", "Gambia", "Gaza Strip", "Georgia", "Ghana", "Gibraltar", "Granada", "Grecia", "Groenlandia", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Ecuatorial", "Guinea-Bissau", "Guyana", "Hait�", "Honduras", "Hong Kong", "Hungr�a", "India", "Indian Ocean", "Indonesia", "Ir�n", "Iraq", "Irlanda", "Isla Bouvet", "Isla Christmas", "Isla Norfolk", "Islandia", "Islas Caim�n", "Islas Cocos", "Islas Cook", "Islas Feroe", "Islas Georgia del Sur y Sandwich del Sur", "Islas Heard y McDonald", "Islas Malvinas", "Islas Marianas del Norte", "IslasMarshall", "Islas Pitcairn", "Islas Salom�n", "Islas Turcas y Caicos", "Islas V�rgenes Americanas", "Islas V�rgenes Brit�nicas", "Israel", "Italia", "Jamaica", "Jan Mayen", "Jap�n", "Jersey", "Jordania", "Kazajist�n", "Kenia", "Kirguizist�n", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "L�bano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macao", "Macedonia", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mal�", "Malta", "Man, Isle of", "Marruecos", "Mauricio", "Mauritania", "Mayotte", "M�xico", "Micronesia", "Moldavia", "M�naco", "Mongolia", "Montserrat", "Mozambique", "Namibia", "Nauru", "Navassa Island", "Nepal", "Nicaragua", "N�ger", "Nigeria", "Niue", "Noruega", "Nueva Caledonia", "Nueva Zelanda", "Om�n", "Pacific Ocean", "Pa�ses Bajos", "Pakist�n", "Palaos", "Panam�", "Pap�a-Nueva Guinea", "Paracel Islands", "Paraguay", "Per�", "Polinesia Francesa", "Polonia", "Portugal", "Puerto Rico", "Qatar", "Reino Unido", "Rep�blica Centroafricana", "Rep�blica Checa", "Rep�blica Democr�tica del Congo", "Rep�blica Dominicana", "Ruanda", "Rumania", "Rusia", "S�hara Occidental", "Samoa", "Samoa Americana", "San Crist�bal y Nieves", "San Marino", "San Pedro y Miquel�n", "San Vicente y las Granadinas", "Santa Helena", "Santa Luc�a", "Santo Tom� y Pr�ncipe", "Senegal", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Southern Ocean", "Spratly Islands", "Sri Lanka", "Suazilandia", "Sud�frica", "Sud�n", "Suecia", "Suiza", "Surinam", "Svalbard y Jan Mayen", "Tailandia", "Taiw�n", "Tanzania", "Tayikist�n", "TerritorioBrit�nicodel Oc�ano Indico", "Territorios Australes Franceses", "Timor Oriental", "Togo", "Tokelau", "Tonga", "Trinidad y Tobago", "T�nez", "Turkmenist�n", "Turqu�a", "Tuvalu", "Ucrania", "Uganda", "Uni�n Europea", "Uruguay", "Uzbekist�n", "Vanuatu", "Venezuela", "Vietnam", "Wake Island", "Wallis y Futuna", "West Bank", "World", "Yemen", "Yibuti", "Zambia", "Zimbabue"};
	
		for(String p:nombresPais){
			CodigoPais pais= new CodigoPais();
			pais.setCodigoPais(p);	
			codigoPaisRepository.save(pais);
		}

		
	}
		@Test
	public void test() {
		List<CodigoPais> paises= new ArrayList<CodigoPais>();
		paises=codigoPaisRepository.findAll();
		for(CodigoPais p:paises){
			System.out.println(p.getCodigoPais());
			
		}
	}
}
