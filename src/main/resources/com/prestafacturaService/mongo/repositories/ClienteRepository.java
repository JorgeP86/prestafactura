package com.prestafacturaService.mongo.repositories;

import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Cliente;
import com.prestafacturaService.mongo.repositories.propios.ClienteRepositoryCustom;


@Repository
public interface ClienteRepository extends ClienteRepositoryCustom, GenericRepository<Cliente> {

}
