package com.prestafacturaService.mongo.repositories;


import org.springframework.stereotype.Repository;

import com.prestafacturaService.mongo.dto.Factura;
import com.prestafacturaService.mongo.repositories.propios.FacturaRepositoryCustom;

@Repository
public interface FacturaRepository extends FacturaRepositoryCustom,GenericRepository<Factura>{

}
