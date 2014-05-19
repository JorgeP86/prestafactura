package com.prestafacturaService.mongo.repositories;


import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.CodigoPais;
import com.prestafacturaService.mongo.repositories.propios.CodigoPaisRepositoryCustom;

@Repository
public interface CodigoPaisRepository extends CodigoPaisRepositoryCustom, GenericRepository<CodigoPais>{

}
