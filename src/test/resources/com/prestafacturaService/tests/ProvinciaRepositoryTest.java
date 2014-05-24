package com.prestafacturaService.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.repositories.LocalidadRepository;
import com.prestafacturaService.mongo.repositories.ProvinciaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"applicationContext.xml","Test-applicationContext.xml"})
public class ProvinciaRepositoryTest {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private LocalidadRepository localidadRepository;
	
	@Before
	public void setUp(){
		
		mongoTemplate.dropCollection("provincia");
		mongoTemplate.createCollection("provincia");
		mongoTemplate.dropCollection("localidad");
		mongoTemplate.createCollection("localidad");
		
		String[] nombresProvincias={"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
				"Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
				"Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
				"Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
				"Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
		
		Set<Localidad> sevilla= new HashSet<Localidad>();
		String[] sLocalidadesSevilla={"Alanís","Cazalla de la Sierra","Cantillana","Coria del rio","Constantina","Guadalcanal","Pedroso","Osuna", "Lora del Rio", "Villaverde","Camas","Fuentes de Andalucia"};
		for(String l:sLocalidadesSevilla){
			Localidad loSe=new Localidad();
			loSe.setLocalidad(l);
			sevilla.add(loSe);
			localidadRepository.save(loSe);
			
			
		}
		
		for(String p:nombresProvincias){
			Provincia pro=new Provincia();
			pro.setProvincia(p);
			if(p.equals("Sevilla")){
				pro.setLocalidades(sevilla);
			}
			provinciaRepository.save(pro);
		}

	}	
	
	
	@Test
	public void test() {
		List<Provincia> provincias=new ArrayList<Provincia>();
		provincias=provinciaRepository.findAll();
		for(Provincia pr:provincias){
			System.out.println(pr.getProvincia());
			if(pr.getProvincia().equals("Sevilla")){
				for(Localidad l:pr.getLocalidades()){
					System.out.println(l.getLocalidad());
				}
			}
		}
		
		
	}
	
			
}
