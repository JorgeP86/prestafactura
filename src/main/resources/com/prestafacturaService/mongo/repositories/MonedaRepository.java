package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Moneda;
import com.prestafacturaService.mongo.repositories.propios.MonedaRepositoryCustom;

@Repository
public interface MonedaRepository extends MonedaRepositoryCustom, GenericRepository<Moneda>{
}
