package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Proveedor;
import com.prestafacturaService.mongo.repositories.propios.ProveedorRepositoryCustom;

@Repository
public interface ProveedorRepository extends ProveedorRepositoryCustom, GenericRepository<Proveedor>{

}
