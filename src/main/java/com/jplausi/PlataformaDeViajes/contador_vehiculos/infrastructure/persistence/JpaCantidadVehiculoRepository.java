package com.jplausi.PlataformaDeViajes.contador_vehiculos.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;


public interface JpaCantidadVehiculoRepository extends CrudRepository<CantidadVehiculoEntity,String> {
    
}
