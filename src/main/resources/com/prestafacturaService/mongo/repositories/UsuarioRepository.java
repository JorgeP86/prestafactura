package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.pestafacturaService.mongo.repositories.propios.UsuarioRepositoryPropio;
import com.prestafacturaService.mongo.dto.Usuario;


@Repository
public interface UsuarioRepository extends UsuarioRepositoryPropio, GenericRepository<Usuario>{

}
