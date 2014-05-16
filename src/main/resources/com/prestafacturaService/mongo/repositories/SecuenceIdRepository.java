package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.SecuenceId;
import com.prestafacturaService.mongo.repositories.propios.SecuenceIdRepositoryCustom;

@Repository
public interface SecuenceIdRepository extends SecuenceIdRepositoryCustom,  GenericRepository<SecuenceId>{

}
