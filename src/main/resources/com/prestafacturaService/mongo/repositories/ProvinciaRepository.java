package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Provincia;
import com.prestafacturaService.mongo.repositories.propios.ProvinciaRepositoryCustom;


@Repository
public interface ProvinciaRepository extends ProvinciaRepositoryCustom, GenericRepository<Provincia>{

}
