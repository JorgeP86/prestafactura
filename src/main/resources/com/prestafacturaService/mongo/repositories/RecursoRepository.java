package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Recurso;
import com.prestafacturaService.mongo.repositories.propios.RecursoRepositoryCustom;

@Repository
public interface RecursoRepository extends RecursoRepositoryCustom, GenericRepository<Recurso>{

}
