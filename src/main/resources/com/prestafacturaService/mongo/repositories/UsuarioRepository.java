package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Usuario;
import com.prestafacturaService.mongo.repositories.propios.UsuarioRepositoryCustom;


@Repository
public interface UsuarioRepository extends UsuarioRepositoryCustom, GenericRepository<Usuario>{

}
