package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Rol;
import com.prestafacturaService.mongo.repositories.propios.RolRepositoryCustom;

@Repository
public interface RolRepository extends RolRepositoryCustom, GenericRepository<Rol>{

	Boolean existNombreRol(String nombreRol);

	

}
