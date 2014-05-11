package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.DatosPropios;
import com.prestafacturaService.mongo.repositories.propios.DatosPropiosRepositoryCustom;

@Repository
public interface DatosPropiosRepository extends DatosPropiosRepositoryCustom, GenericRepository<DatosPropios>{

}
