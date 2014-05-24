package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Localidad;
import com.prestafacturaService.mongo.repositories.propios.LocalidadRepositoryCustom;

@Repository
public interface LocalidadRepository extends LocalidadRepositoryCustom, GenericRepository<Localidad>{

}
