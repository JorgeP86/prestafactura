package com.prestafacturaService.mongo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestafacturaService.mongo.repositories.SecuenceIdRepository;

@Service
public class SecuenceManager {

	@Autowired
	private SecuenceIdRepository secuenceIdRepository;
	
	public int NextSequenceId(String key){
		return secuenceIdRepository.getNextSequenceId(key);
		
	}
	
	public void CreateSecuence(){
		secuenceIdRepository.insertSecuence();
	}
}
