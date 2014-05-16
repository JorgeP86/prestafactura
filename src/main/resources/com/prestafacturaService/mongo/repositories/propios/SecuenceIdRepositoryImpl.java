package com.prestafacturaService.mongo.repositories.propios;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.prestafacturaService.mongo.dto.SecuenceId;



public class SecuenceIdRepositoryImpl {
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public Integer getNextSequenceId(String key){// throws SequenceException {
 
	  //get sequence id
	  Query query = new Query(Criteria.where("id").is(key));
 
	  //increase sequence id by 1
	  Update update = new Update();
	  update.inc("seq", 1);
 
	  //return new increased id
	  FindAndModifyOptions options = new FindAndModifyOptions();
	  options.returnNew(true);
 
	  //this is the magic happened.
	
	  SecuenceId seqId = mongoTemplate.findAndModify(query, update, options, SecuenceId.class);
 
	  //if no id, throws SequenceException
          //optional, just a way to tell user when the sequence id is failed to generate.
	//  if (seqId == null) {
	//	throw new SequenceException("Unable to get sequence id for key : " + key);
	  //}
 
	  return seqId.getSeq();
 
	}
	
	
	
	
	public void insertSecuence(){
		SecuenceId secuence=new SecuenceId();
		secuence.setId("idRol");
		secuence.setSeq(0);
		
		 mongoTemplate.insert(secuence);
	}
 
}

