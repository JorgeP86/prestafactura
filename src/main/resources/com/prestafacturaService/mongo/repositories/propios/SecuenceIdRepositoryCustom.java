package com.prestafacturaService.mongo.repositories.propios;


public interface SecuenceIdRepositoryCustom {
	int  getNextSequenceId(String key);
	void insertSecuence();
}
